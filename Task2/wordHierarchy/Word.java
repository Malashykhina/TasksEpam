package wordHierarchy;

import java.util.ArrayList;


// task 9
public class Word implements Comparable<Word>{
	private Character[] chArr;
	private int size;
	
	public Word(ArrayList<Character> aLCh){
		chArr=new Character[aLCh.size()];
		for(int i=0; i<aLCh.size();i++){
		chArr[i]=aLCh.get(i);
		}
		size=chArr.length;
	}
	public Word(Character [] chArr){
		this.chArr=chArr;
		size=chArr.length;
	}
	public Word(String s){
		chArr=new Character[s.length()];
		for(int i=0; i<s.length();i++){
		chArr[i]=new Character(s.charAt(i));
		}
		size=s.length();
	}
	
	public Character[] getChArr() {
		return chArr;
	}

	public void setChArr(Character[] chArr) {
		this.chArr = chArr;
	}

	public int getSize() {
		return size;
	}
	public int getNumberOFLeter(Character ch){
		int answer=0;
		for (int i=0;i<size;i++){
			if(chArr[i].equals(ch)){
				answer++;
			}
		}
		return answer;
		
	}

	@Override
	public int compareTo(Word o) {//for sorting in alphabetical order
		int i=0;
		while (((i!=(size-1))&&(i!=(o.getSize()-1)))&&(this.getChArr()[i]).equals(o.getChArr()[i])){
			i++;
		}
		if ((i!=(size-1))&&(i!=(o.getSize()-1))){
			return (chArr[i]).compareTo(o.getChArr()[i]);
		}else{
			if (i==(size-1)){
				return -1;
			}else {return 1;}
		}
	}
	
	@Override
	public String  toString(){
		StringBuilder sb =new StringBuilder();
		for(int i =0; i<size;i++){
			sb.append(chArr[i].toString());
			//sb.append(' ');
		}
		return sb.toString();
	}
}
