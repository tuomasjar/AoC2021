import java.io.*;
import java.util.*;

public abstract class Day {
	protected Scanner s;
	protected File f;
	protected boolean fileOpen=false;
	protected boolean endOfFile=false;
	
	protected Day(int number) {
			
		String fileNumber="";
		if(number<10)fileNumber="0"+number;
		else fileNumber=""+number;
		try {
			f = new File("./res/Day"+fileNumber+"input.txt");
			s = new Scanner(f);
			fileOpen=true;
			endOfFile=false;
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
	}
	protected void resetScanner() {
		s.close();
		try {
			s = new Scanner(f);
			fileOpen=true;
			endOfFile=false;
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	protected String readNextLine() {
		if(!s.hasNext()) {
			endOfFile=true;
			return null;
		}
		if(!endOfFile && fileOpen) {
			return s.nextLine();
		}else {
			return null;
		}
	}
	
	public abstract void runA();
	public abstract void runB();
}
