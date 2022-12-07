import java.util.ArrayList;

public class Day09 extends Day{
	public Day09(){
		super(9);
	}
	public void runA(){
		int sum=0;
		ArrayList<String> map = new ArrayList<>();
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			map.add(input);
		}
		char[][] vents = new char[map.size()][map.get(0).length()];
		for(int i=0;i<vents.length;i++) {
			vents[i]=map.get(i).toCharArray();
		}
		
		for(int i=0;i<vents.length;i++) {
			for(int j=0;j<vents[i].length;j++) {
				if(vents[i][j]=='9')continue;
				if(i>0 && vents[i][j]>vents[i-1][j])continue;
				if(i<vents.length-1 && vents[i][j]>vents[i+1][j])continue;
				if(j>0 && vents[i][j]>vents[i][j-1])continue;
				if(j<vents[i].length-1 && vents[i][j]>vents[i][j+1])continue;
				sum+=Integer.parseInt(vents[i][j]+"")+1;				
			}
		}
		System.out.println(sum);
	}
	public void runB(){
		resetScanner();
		ArrayList<String> map = new ArrayList<>();
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			map.add(input);
		}
		int width=map.size();
		int height=map.get(0).length();
		char[][] vents = new char[width][height];
		boolean[][] counted = new boolean[width][height];
		for(int i=0;i<vents.length;i++) {
			vents[i]=map.get(i).toCharArray();
		}
		int basin1=0,basin2=0,basin3=0;
		for(int i=0;i<vents.length;i++) {
			for(int j=0;j<vents[i].length;j++) {
				if(vents[i][j]=='9')continue;
				if(counted[i][j])continue;
				int basinCurrent=0;
				basinCurrent=getBasinSize(vents,counted,i,j);
				if(basinCurrent>basin1) {
					basin3=basin2;
					basin2=basin1;
					basin1=basinCurrent;
				}else if(basinCurrent>basin2) {
					basin3=basin2;
					basin2=basinCurrent;
				}else if(basinCurrent>basin3) {
					basin3=basinCurrent;
				}
			}
		}
		System.out.println(basin1+"*"+basin2+"*"+basin3+"="+basin1*basin2*basin3);
	}
	
	public int getBasinSize(char[][] vents, boolean[][] counted,int x, int y) {
		int size=1;
		if(x>=vents.length || x<0)return 0;
		if(y<0 || y>=vents[x].length)return 0;
		if(vents[x][y]=='9')return 0;
		if(counted[x][y])return 0;
		counted[x][y]=true;
		size+=getBasinSize(vents,counted,x-1,y);
		size+=getBasinSize(vents,counted,x+1,y);
		size+=getBasinSize(vents,counted,x,y+1);
		size+=getBasinSize(vents,counted,x,y-1);
		return size;
	}
	
	
}