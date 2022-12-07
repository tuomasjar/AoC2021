

public class Day02 extends Day{
	
	public Day02() {
		super(2);
	}
	@Override
	public void runA() {

		int depth=0;
		int horizontal=0;
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			String[] parts = input.split(" ");
			if(parts[0].charAt(0)=='f')horizontal+=Integer.parseInt(parts[1]);	
			if(parts[0].charAt(0)=='u')depth-=Integer.parseInt(parts[1]);
			if(parts[0].charAt(0)=='d')depth+=Integer.parseInt(parts[1]);
		}
		int result=depth*horizontal;
		System.out.println(result);
	}
	@Override
	public void runB() {
		resetScanner();
		int depth=0;
		int horizontal=0;
		int aim=0;
		
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			String[] parts = input.split(" ");
			if(parts[0].charAt(0)=='f') {
				horizontal+=Integer.parseInt(parts[1]);
				depth+=aim*Integer.parseInt(parts[1]);
			}
			if(parts[0].charAt(0)=='u')aim-=Integer.parseInt(parts[1]);
			if(parts[0].charAt(0)=='d')aim+=Integer.parseInt(parts[1]);
		}
		int result=depth*horizontal;
		System.out.println(result);
	}
}
