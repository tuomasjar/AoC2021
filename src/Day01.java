import java.util.ArrayList;

public class Day01 extends Day{
	
	public Day01() {
		super(1);
	}
	@Override
	public void runA() {
		int previous=Integer.parseInt(readNextLine());
		int amount=0;
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			int current=Integer.parseInt(input);
			if(current>previous)amount++;
			previous=current;
		}
		System.out.println(amount);
	}
	@Override
	public void runB() {
		resetScanner();
		int indexA=0;
		int indexB=-1;
		int indexC=-2;
		
		int aSum=0;
		int bSum=0;
		int cSum=0;
		
		ArrayList<Integer> sums=new ArrayList<>();
		boolean cont=true;
		while(cont) {
			int current=0;
			String input=readNextLine();
			if(input==null)cont=false;
			else if(endOfFile)cont=false;
			else {
				current=Integer.parseInt(input);
			}
			
			if(indexA<3 && indexA>=0) {
				aSum+=current;
				indexA++;
			}else if(indexA<0) {
				indexA++;
			}else if(indexA==3) {
				sums.add(aSum);
				aSum=0;
				indexA=1;
				aSum+=current;
			}
			if(indexB<3 && indexB>=0) {
				bSum+=current;
				indexB++;
			}else if(indexB<0) {
				indexB++;
			}else if(indexB==3) {
				sums.add(bSum);
				bSum=0;
				indexB=1;
				bSum+=current;
			}
			if(indexC<3 && indexC>=0) {
				cSum+=current;
				indexC++;
			}else if(indexC<0) {
				indexC++;
			}else if(indexC==3) {
				sums.add(cSum);
				cSum=0;
				indexC=1;
				cSum+=current;
			}
		}
		int amount=0;
		for(int i=0;i<sums.size()-1;i++) {
			if(sums.get(i)<sums.get(i+1))amount++;
		}
		System.out.println(amount);
	}
	
	

}
