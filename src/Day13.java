import java.util.ArrayList;

public class Day13 extends Day{
	public Day13(){
		super(13);
	}
	
	public class Point{
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public void runA(){
		ArrayList<Point> mapPoints = new ArrayList<>();
		ArrayList<String> instructions = new ArrayList<>();
		boolean foldInstructions=false;
		while(true) {
			String input = readNextLine();
			if(input==null)break;
			if(input.isBlank())foldInstructions=true;
			if(!foldInstructions) {
				String[] splitInput = input.split(",");
				int x = Integer.parseInt(splitInput[1]);
				int y= Integer.parseInt(splitInput[0]);
				
				Point point = new Point(x,y);
				mapPoints.add(point);
			}else {
				if(!input.isBlank())instructions.add(input);
			}
		}
		int maxY=0;
		int maxX=0;
		for(Point point:mapPoints) {
			if(point.x>maxX)maxX=point.x;
			if(point.y>maxY)maxY=point.y;
		}
		maxX++;
		maxY++;
		int[][] map = new int[maxX][maxY];
		for(Point point:mapPoints) {
			map[point.x][point.y]=1;
		}
		
		
		String[] whatToDo = instructions.get(0).split("=");
		int foldLine = Integer.parseInt(whatToDo[1]);
		char axis = whatToDo[0].charAt(whatToDo[0].length()-1);
		int[][] result = foldMap(axis,foldLine,map);
		int sum=0;
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				sum+=result[i][j];
			}
		}
		System.out.println(sum);
	}
	public void runB(){
		resetScanner();
		ArrayList<Point> mapPoints = new ArrayList<>();
		ArrayList<String> instructions = new ArrayList<>();
		boolean foldInstructions=false;
		while(true) {
			String input = readNextLine();
			if(input==null)break;
			if(input.isBlank())foldInstructions=true;
			if(!foldInstructions) {
				String[] splitInput = input.split(",");
				int x = Integer.parseInt(splitInput[1]);
				int y= Integer.parseInt(splitInput[0]);
				
				Point point = new Point(x,y);
				mapPoints.add(point);
			}else {
				if(!input.isBlank())instructions.add(input);
			}
		}
		int maxY=0;
		int maxX=0;
		for(Point point:mapPoints) {
			if(point.x>maxX)maxX=point.x;
			if(point.y>maxY)maxY=point.y;
		}
		maxX++;
		maxY++;
		int[][] map = new int[maxX][maxY];
		for(Point point:mapPoints) {
			map[point.x][point.y]=1;
		}
		int[][] result = map;
		for(String instruction:instructions) {
			String[] whatToDo = instruction.split("=");
			int foldLine = Integer.parseInt(whatToDo[1]);
			char axis = whatToDo[0].charAt(whatToDo[0].length()-1);
			result = foldMap(axis,foldLine,result);
			int sum=0;
		}
		
		printTable(result);
	}
	
	public void printTable(int[][] map) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]==1)sb.append("#");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public int[][] foldMap(char axis, int foldLine, int[][] map){
		int[][] result;
		//Foldaus suunta
		if(axis=='y') {
			//Alustetaan pienempi taulukko
			result = new int[foldLine][map[0].length];
			//lisää ykkönen foldaus suuntaan ja nollaa lähtöarvo
			for(int i=foldLine;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					int distance = i-foldLine;
					if(map[i][j]==1) {
						map[i][j]=0;
						map[foldLine-distance][j]=1;
					}
				}
			//Kopioi "käsin" arvot uuteen pienempään taulukkoon
			}
			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result[i].length;j++) {
					result[i][j]=map[i][j];
				}
			}
			//palauta taulukko
			return result;
		//Ja sitten sama toiseen suuntaan:
		}else {
			result = new int[map.length][foldLine];
			for(int i=0;i<map.length;i++) {
				for(int j=foldLine;j<map[i].length;j++) {
					int distance = j-foldLine;
					if(map[i][j]==1) {
						map[i][j]=0;
						map[i][foldLine-distance]=1;
					}
				}
				
			}
			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result[i].length;j++) {
					result[i][j]=map[i][j];
				}
			}
			return result;
		}
	}
}