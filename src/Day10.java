import java.util.ArrayList;
import java.util.Comparator;

public class Day10 extends Day{
	public Day10(){
		super(10);
	}
	public void runA(){
		ArrayList<Character> stack = new ArrayList<>();
		int score=0;
		while(!endOfFile) {
			String input = readNextLine();
			char toLookFor='0';
			if(input==null)break;
			stack.clear();
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(' || input.charAt(i)=='[' || input.charAt(i)=='{' || input.charAt(i)=='<') {
					toLookFor=getToLookFor(input.charAt(i));
					stack.add(input.charAt(i));
				}else if(input.charAt(i)==toLookFor) {
					stack.remove(stack.size()-1);
					toLookFor=getToLookFor(stack.get(stack.size()-1));
				}else {
					score+=getScore(input.charAt(i));
					break;
				}
			}
		}
		System.out.println(score);
	}
	
	public int getScore(char input) {
		switch(input) {
		case ')':
			return 3;
		case ']':
			return 57;
		case '}':
			return 1197;
		case '>':
			return 25137;
		default:
			return '0';
		}
	}
	
	public char getToLookFor(char input) {
		switch(input) {
		case '(':
			return ')';
		case '[':
			return ']';
		case '{':
			return '}';
		case '<':
			return '>';
		default:
			return '0';
		}
	}
	public void runB(){
		resetScanner();
		ArrayList<Character> stack = new ArrayList<>();
		ArrayList<String> unCorrupt = new ArrayList<>();
		ArrayList<Long> scores = new ArrayList<>();
		boolean corrupt=false;
		long score=0;
		while(!endOfFile) {
			String input = readNextLine();
			char toLookFor='0';
			if(input==null)break;
			stack.clear();
			corrupt=false;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(' || input.charAt(i)=='[' || input.charAt(i)=='{' || input.charAt(i)=='<') {
					toLookFor=getToLookFor(input.charAt(i));
					stack.add(input.charAt(i));
				}else if(input.charAt(i)==toLookFor) {
					stack.remove(stack.size()-1);
					toLookFor=getToLookFor(stack.get(stack.size()-1));
				}else {
					corrupt=true;
					break;
				}
			}
			if(!corrupt)unCorrupt.add(input);
		}
		for(String input:unCorrupt) {
			stack.clear();
			char toLookFor='0';
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(' || input.charAt(i)=='[' || input.charAt(i)=='{' || input.charAt(i)=='<') {
					toLookFor=getToLookFor(input.charAt(i));
					stack.add(input.charAt(i));
				}else if(input.charAt(i)==toLookFor) {
					stack.remove(stack.size()-1);
					toLookFor=getToLookFor(stack.get(stack.size()-1));
				}
			}
			for(int i=stack.size()-1;i>=0;i--) {
				score*=5;
				score+=getBScore(stack.get(i));
			}
			scores.add(score);
			score=0;
		}
		scores.sort(Comparator.naturalOrder());
		System.out.println(scores.get(22));
	}
	public int getBScore(char input) {
		switch(input) {
		case '(':
			return 1;
		case '[':
			return 2;
		case '{':
			return 3;
		case '<':
			return 4;
		default:
			return 0;
		}
	}
}