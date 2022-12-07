import java.util.*;

public class Day05 extends Day{
	public Day05(){
		super(5);
	}
	public class Coordinates{
		int x1,x2;
		int y1,y2;
		
		public Coordinates(int x1,int y1, int x2, int y2) {
		
			this.x1=y1;
			this.x2=y2;
			this.y1=x1;
			this.y2=x2;
		}
		
		public void markLine(int[][]map, boolean A) {
			if(x1==x2 && y1<y2) {
				for(int i=y1;i<=y2;i++) {
					map[x1][i]++;
				}
			}else if(x1==x2 && y2<y1) {
				for(int i=y2;i<=y1;i++) {
					map[x1][i]++;
				}
			}
			else if(y1==y2 && x1<x2) {
				for(int i=x1;i<=x2;i++) {
					map[i][y1]++;
				}
			}else if(y1==y2 && x2<x1) {
				for(int i=x2;i<=x1;i++) {
					map[i][y1]++;
				}
			}
			else if(!A){
				if(x1>x2 && y1>y2) {
					int currentX=x1;
					int currentY=y1;
					while(currentX!=x2 && currentY!=y2) {
						map[currentX][currentY]++;
						if(currentX!=x2)currentX--;
						if(currentY!=y2)currentY--;
					}
					map[currentX][currentY]++;
				}else if(x1>x2 && y2>y1) {
					int currentX=x1;
					int currentY=y1;
					while(currentX!=x2 && currentY!=y2) {
						map[currentX][currentY]++;
						if(currentX!=x2)currentX--;
						if(currentY!=y2)currentY++;
					}
					map[currentX][currentY]++;
				}else if(x2>x1 && y1>y2) {
					int currentX=x1;
					int currentY=y1;
					while(currentX!=x2 && currentY!=y2) {
						map[currentX][currentY]++;
						if(currentX!=x2)currentX++;
						if(currentY!=y2)currentY--;
					}
					map[currentX][currentY]++;
				}else if(x2>x1 && y2>y1) {
					int currentX=x1;
					int currentY=y1;
					while(currentX!=x2 && currentY!=y2) {
						map[currentX][currentY]++;
						if(currentX!=x2)currentX++;
						if(currentY!=y2)currentY++;
					}
					map[currentX][currentY]++;
				}
			}
		}
	}
	
	public void runA(){
		int[][] map = new int[1000][1000];
		ArrayList<Coordinates> coordinates = new ArrayList<>();
		
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			String[] sides = input.split("->");
			String[] aSide = sides[0].split(",");
			String[] bSide = sides[1].split(",");
			Coordinates coordinate = new Coordinates(Integer.parseInt(aSide[0].trim()),Integer.parseInt(aSide[1].trim()),//
					Integer.parseInt(bSide[0].trim()),Integer.parseInt(bSide[1].trim()));
			coordinates.add(coordinate);
		}
		for(Coordinates coordinate : coordinates) {
			coordinate.markLine(map,true);
		}
		int amount=0;
		for(int[] number : map) {
			for(int number1 : number) {
				if(number1>1)amount++;
			}
		}
		System.out.println(amount);
	}
	public void runB(){
		resetScanner();
		int[][] map = new int[1000][1000];
		ArrayList<Coordinates> coordinates = new ArrayList<>();
		
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			String[] sides = input.split("->");
			String[] aSide = sides[0].split(",");
			String[] bSide = sides[1].split(",");
			Coordinates coordinate = new Coordinates(Integer.parseInt(aSide[0].trim()),Integer.parseInt(aSide[1].trim()),//
					Integer.parseInt(bSide[0].trim()),Integer.parseInt(bSide[1].trim()));
			coordinates.add(coordinate);
		}
		for(Coordinates coordinate : coordinates) {
			coordinate.markLine(map,false);
		}
		int amount=0;
		for(int[] number : map) {
			for(int number1 : number) {
				if(number1>1)amount++;
			}
		}
		System.out.println(amount);
	}
}