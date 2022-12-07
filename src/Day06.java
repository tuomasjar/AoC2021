

public class Day06 extends Day{
	public Day06(){
		super(6);
	}
	public void runA(){
		int amountOfRuns=80;
		String input = readNextLine();
		long[] fishes = new long[9];
		String [] parse = input.split(",");
		for(int i=0;i<parse.length;i++) {
			fishes[Integer.parseInt(parse[i])]++;
		}
		for(int i=0;i<amountOfRuns;i++) {
			long breed = fishes[0];
			for(int j=0;j<8;j++) {
				fishes[j]=fishes[j+1];
			}
			fishes[8]=breed;
			fishes[6]+=breed;
		}
		long amount=0;
		for(int i=0;i<fishes.length;i++){
			amount+=fishes[i];
		}
		System.out.println(amount);
	}
	public void runB(){
		
		resetScanner();
		int amountOfRuns=256;
		String input = readNextLine();
		long[] fishes = new long[9];
		String [] parse = input.split(",");
		for(int i=0;i<parse.length;i++) {
			fishes[Integer.parseInt(parse[i])]++;
		}
		for(int i=0;i<amountOfRuns;i++) {
			long breed = fishes[0];
			for(int j=0;j<8;j++) {
				fishes[j]=fishes[j+1];
			}
			fishes[8]=breed;
			fishes[6]+=breed;
		}
		long amount=0;
		for(int i=0;i<fishes.length;i++){
			amount+=fishes[i];
		}
		System.out.println(amount);
	}
}