package wordHierarchy;

public class Character implements Comparable<Character>{
	private char letter;
	
	public Character(char ch){
		letter=ch;
	}
	
	public char getLetter() {
		return letter;
	}
	
	@Override
	public int compareTo(Character o) {
		return (int)letter-(int)o.getLetter();
	}
	
	@Override
	public boolean equals (Object o){
	    if (this == o)
	        return true;
	      if (!(o instanceof Character))
	        return false;
	      else
	    	  return this.getLetter()==((Character)o).getLetter();
	}
	
	@Override
	public String  toString(){
		String ans=new String(letter+"");
		return ans;
	}
}
