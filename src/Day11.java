import java.util.ArrayList;
import java.util.Arrays;

public class Day11 extends Day{
	public Day11(){
		super(11);
	}
	public void runA(){
		ArrayList<String> inputParse=new ArrayList<>();
		while(true) {
			String input = readNextLine();
			if(input==null)break;
			inputParse.add(input);
		}
		int[][] octopus = new int[inputParse.size()][inputParse.get(0).length()];
		boolean[][] flash = new boolean[inputParse.size()][inputParse.get(0).length()];
		
		for(int i=0;i<inputParse.size();i++) {
			for(int j=0;j<inputParse.get(0).length();j++) {
				octopus[i][j]=Integer.parseInt(inputParse.get(i).charAt(j)+"");
			}
		}
		
		int flashes=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<octopus.length;j++) {
				for(int k=0;k<octopus[0].length;k++) {
					flashes+=step(octopus,flash,j,k);
					
				}	
			}
			flash=new boolean[octopus.length][octopus[0].length];
		}
		System.out.println(flashes);
	}
	
	public int step(int[][] octopus, boolean[][] flashes,int x, int y) {
		int flash=0;
		if(x>=octopus.length || y>=octopus.length || x<0 || y<0)return 0;
		if(flashes[x][y])return 0;
		octopus[x][y]++;
		if(octopus[x][y]>9){
			octopus[x][y]=0;
			flashes[x][y]=true;
			flash++;
			flash+=step(octopus,flashes,x-1,y-1);
			flash+=step(octopus,flashes,x-1,y);
			flash+=step(octopus,flashes,x-1,y+1);
			flash+=step(octopus,flashes,x,y-1);
			flash+=step(octopus,flashes,x,y+1);
			flash+=step(octopus,flashes,x+1,y-1);
			flash+=step(octopus,flashes,x+1,y);
			flash+=step(octopus,flashes,x+1,y+1);
			return flash;
		}else {
			return 0;
		}
	}
	public void printTable(int[][] printable) {
		for(int i=0;i<printable.length;i++) {
			for(int j=0;j<printable[0].length;j++) {
				System.out.print(printable[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void runB(){
		resetScanner();
		ArrayList<String> inputParse=new ArrayList<>();
		while(true) {
			String input = readNextLine();
			if(input==null)break;
			inputParse.add(input);
		}
		int[][] octopus = new int[inputParse.size()][inputParse.get(0).length()];
		boolean[][] flash = new boolean[inputParse.size()][inputParse.get(0).length()];
		
		for(int i=0;i<inputParse.size();i++) {
			for(int j=0;j<inputParse.get(0).length();j++) {
				octopus[i][j]=Integer.parseInt(inputParse.get(i).charAt(j)+"");
			}
		}
		
		int flashes=0;
		boolean check=true;
		while(check) {
			check=false;
			for(int j=0;j<octopus.length;j++) {
				for(int k=0;k<octopus[0].length;k++) {
					step(octopus,flash,j,k);
					
				}	
			}
			flash=new boolean[octopus.length][octopus[0].length];
			
			
			for(int h=0;h<octopus.length;h++) {
				for(int g=0;g<octopus[0].length;g++) {
					if(octopus[h][g]!=0)check=true;
				}
			}
			flashes++;
		}
		System.out.println(flashes);
	}
}