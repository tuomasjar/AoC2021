import java.util.*;

public class Day04 extends Day{
	public Day04(){
		super(4);
	}
	public void runA(){
		String drawNumber = readNextLine();
		String[] numbers= drawNumber.split(",");
		int winningTable=0;
		int lastNumber=0;
		boolean bingo=false;
		ArrayList<String[][]> tables = new ArrayList<>();
		ArrayList<boolean[][]> marked = new ArrayList<>();
		readNextLine();
		while(!endOfFile) {
			String[][] nextTable = new String[5][5];
			for(int i=0;i<5;i++) {
				String nextRow = readNextLine().trim();
				nextTable[i]=nextRow.split(" +");
			}
			boolean[][] nextOne = new boolean[5][5];
			tables.add(nextTable);
			marked.add(nextOne);
			readNextLine();								//skip empty line between tables
		}
		for(int drawingNumbers=0;drawingNumbers<numbers.length;drawingNumbers++) {
			String current = numbers[drawingNumbers];
			for(int iterator = 0;iterator<tables.size();iterator++) {
				String[][] table = tables.get(iterator);
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(table[i][j].equals(current)) {
							marked.get(iterator)[i][j]=true;
						}
					}
				}
			}
			for(int i=0;i<marked.size();i++) {
				boolean[][] check = marked.get(i);
				for(int j=0;j<check.length;j++) {
					if(check[j][0]&&check[j][1]&&check[j][2]&&check[j][3]&&check[j][4]) {
						winningTable=i;
						bingo=true;
						break;
					}
					else if(check[0][j]&&check[1][j]&&check[2][j]&&check[3][j]&&check[4][j]) {
						winningTable=i;
						bingo=true;
						break;
					}
				}
			}
			if(bingo) {
				lastNumber=Integer.parseInt(current);
				
				break;
			}
		}
		String[][] winnerTable = tables.get(winningTable);
		boolean[][] winTable = marked.get(winningTable);
		int sum=0;
		for(int i=0;i<winnerTable.length;i++) {
			for(int j=0;j<winnerTable[i].length;j++) {
				if(!winTable[i][j]) {
					sum+=Integer.parseInt(winnerTable[i][j]);
				}
			}
		}
		System.out.println(sum*lastNumber);
		
	}
	public void runB(){
		resetScanner();
		String drawNumber = readNextLine();
		String[] numbers= drawNumber.split(",");
		int winningTable=0;
		int lastNumber=0;
		boolean bingo=false;
		ArrayList<String[][]> tables = new ArrayList<>();
		ArrayList<boolean[][]> marked = new ArrayList<>();
		ArrayList<Integer> wonTables = new ArrayList<>();
		readNextLine();
		while(!endOfFile) {
			String[][] nextTable = new String[5][5];
			for(int i=0;i<5;i++) {
				String nextRow = readNextLine().trim();
				nextTable[i]=nextRow.split(" +");
			}
			boolean[][] nextOne = new boolean[5][5];
			tables.add(nextTable);
			marked.add(nextOne);
			readNextLine();								//skip empty line between tables
		}
		
		for(int drawingNumbers=0;drawingNumbers<numbers.length;drawingNumbers++) {
			
			String current = numbers[drawingNumbers];
			for(int iterator = 0;iterator<tables.size();iterator++) {
				String[][] table = tables.get(iterator);
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(table[i][j].equals(current)) {
							marked.get(iterator)[i][j]=true;
						}
					}
				}
			}
			for(int i=0;i<marked.size();i++) {
				boolean[][] check = marked.get(i);
				for(int j=0;j<check.length;j++) {
					if(check[j][0]&&check[j][1]&&check[j][2]&&check[j][3]&&check[j][4]) {
						boolean found = false;
						for(int number:wonTables) {
							if(number==i) {
								found=true;
								break;
							}
						}
						if(!found) {
							winningTable=i;
							wonTables.add(i);
							bingo=true;
						}
					}
					else if(check[0][j]&&check[1][j]&&check[2][j]&&check[3][j]&&check[4][j]) {
						boolean found = false;
						for(int number:wonTables) {
							if(number==i) {
								found=true;
								break;
							}
						}
						if(!found) {
							winningTable=i;
							wonTables.add(i);
							bingo=true;
						}
					}
				}
			}
			if(bingo) {
					lastNumber=Integer.parseInt(current);
					bingo=false;
					if(wonTables.size()==(tables.size()))break;
				}				
			}
		String[][] winnerTable = tables.get(winningTable);
		boolean[][] winTable = marked.get(winningTable);
		int sum=0;
		for(int i=0;i<winnerTable.length;i++) {
			for(int j=0;j<winnerTable[i].length;j++) {
				if(!winTable[i][j]) {
					sum+=Integer.parseInt(winnerTable[i][j]);
				}
			}
		}
		System.out.println(sum*lastNumber);
		
	}
}