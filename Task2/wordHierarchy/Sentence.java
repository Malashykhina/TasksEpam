package wordHierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sentence extends ArrayList<Word>{

	public void sort(final char ch){
		Collections.sort(this,new Comparator<Word>(){
			@Override
			public int compare(Word o1, Word o2) {
				char charToCount=ch;
				Character c=new Character(charToCount);
				if (o1.getNumberOFLeter(c)!=o2.getNumberOFLeter(c)){
					//compares according to number of letter @ch in this word
					return o1.getNumberOFLeter(c)-o2.getNumberOFLeter(c);
				}else 
					return o1.compareTo(o2);
				//compares in alphabetical order if words has same number of letters @ch
			}
			
		}); 
	}

	@Override
	public String  toString(){
		StringBuilder sb =new StringBuilder();
		for (Word s :this ){
			sb.append(s+" ");
			sb.append(' ');
		}
		return sb.toString();
	}
}
