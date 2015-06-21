package runner;

import java.io.IOException;
import java.util.ArrayList;

import readingWritingFile.FileWorker;
import wordHierarchy.Sentence;
import wordHierarchy.Word;

public class SystemRunner {
	
	public static void main(String[] args) {
		
		Sentence arr = FileWorker.read("src\\userData\\InData");
		//System.out.println(arr);

		arr.sort('a');		
		//System.out.println(arr);
		FileWorker.write("src\\userData\\OutData", arr);

	}


}
