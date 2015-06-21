package readingWritingFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import wordHierarchy.Sentence;
import wordHierarchy.Word;
import wordHierarchy.Character;

public class FileWorker {
	public static Sentence read(String path){
		Sentence answer=new Sentence();
		BufferedReader bufferedReader = null;
		try {
		bufferedReader = new BufferedReader(new FileReader(path));

		int symbol = bufferedReader.read();
		
		
		ArrayList<Character> aLCh=new ArrayList<Character>();
		while (symbol != -1) {  // we will get '-1' in the end of file
		      char c = (char) symbol;// transfer to char
		      if ((c>='a')&&(c<='z')||(c>='A')&&(c<='Z')){
		    	  aLCh.add(new Character(c));//is from the alphabet
		      } else{
		    	  if(aLCh.size()!=0){
		    	  answer.add(new Word(aLCh));
		    	  //adding new word, if ArrayList<Character> aLCh is not empty
		    	  aLCh=new ArrayList<Character>();
		    	  //make new array to collect next symbols for the next word
		    	  }
		      }
		      symbol = bufferedReader.read(); //Read next symbol 
		}
		}catch (FileNotFoundException  e) {
			System.out.println("Sorry, can't find file with such a name");
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            if (bufferedReader != null) {
                try {
                	bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return answer;	
		
	}
	
	public static void write(String path, Sentence s){

	    File file = new File(path);
	 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            out.print(s);
	        } finally {
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}

}
