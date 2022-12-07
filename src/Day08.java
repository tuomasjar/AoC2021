import java.util.ArrayList;

public class Day08 extends Day{
	public Day08(){
		super(8);
	}
	public void runA(){
		ArrayList<String[]> input = new ArrayList<>();
		ArrayList<String[]> output= new ArrayList<>();
		
		
		while(!endOfFile) {
			String inputParse = readNextLine();
			if(inputParse==null)break;
			String[] limited = inputParse.split("\\|");
			input.add(limited[0].trim().split(" "));
			output.add(limited[1].trim().split(" "));
		}
		int amount=0;
		for(String[] x:output) {
			for(String y:x) {
				if(y.length()==2) {
					
					amount++;
					break;
				}
				if(y.length()==3) {
					
					amount++;
					break;
				}
				if(y.length()==4) {
					
					amount++;
					break;
				}
				if(y.length()==7) {

					amount++;
					break;
				}
			}
		}
		System.out.println(amount);
		}
	public void runB(){
		resetScanner();
		ArrayList<String[]> input = new ArrayList<>();
		ArrayList<String[]> output= new ArrayList<>();
		int sum=0;
		while(!endOfFile) {
			String inputParse = readNextLine();
			if(inputParse==null)break;
			String[] limited = inputParse.split("\\|");
			input.add(limited[0].trim().split(" "));
			output.add(limited[1].trim().split(" "));
		}
		
		for(int i=0;i<input.size();i++) {
			String[] numbers = new String[10];
			String[] deduce = input.get(i);
			
			for(int j=0;j<deduce.length;j++) {
				if(deduce[j].length()==2) {
					numbers[1]=deduce[j];
				}
				if(deduce[j].length()==3) {
					numbers[7]=deduce[j];
				}
				if(deduce[j].length()==4) {
					numbers[4]=deduce[j];
				}
				if(deduce[j].length()==7) {
					numbers[8]=deduce[j];
				}
			}
			
			for(int j=0;j<deduce.length;j++) {
				if(deduce[j].length()!=6)continue;
				int notcommon=0;
				int common=0;
				for(int k=0;k<deduce[j].length();k++) {
					if(numbers[7].contains(deduce[j].charAt(k)+"") || numbers[4].contains(deduce[j].charAt(k)+"")) {
						common++;
						
					}else {
						notcommon++;
					
					}
				}
				if(notcommon==2) {
					int zero=0;
					for(int h=0;h<numbers[7].length();h++) {
						if(deduce[j].contains(numbers[7].charAt(h)+"")){
							zero++;
						}
					}
					if(zero==3) {
						numbers[0]=deduce[j];
					}else {
						numbers[6]=deduce[j];
					}
				}
				else if(notcommon==1) {
					numbers[9]=deduce[j];
				}
			}
			
			for(int j=0;j<deduce.length;j++) {
				if(deduce[j].length()!=5)continue;
				int notcommon=0;
				for(int k=0;k<deduce[j].length();k++) {
					if(!numbers[6].contains(deduce[j].charAt(k)+"")) {
						notcommon++;
					}
				}
				
				if(notcommon==1) {
					int two=0;
					for(int h=0;h<numbers[4].length();h++){
						if(deduce[j].contains(numbers[4].charAt(h)+"")) {
							
						}else {
							two++;
						}
					}
					if(two==1)numbers[3]=deduce[j];
					else numbers[2]=deduce[j];
				}
				else if(notcommon==0)numbers[5]=deduce[j];
			}
			
			int outputNumber=0;
			for(int h=output.get(i).length-1;h>=0;h--) {
				String current = output.get(i)[h];
				for(int g=0;g<numbers.length;g++) {
					if(compare(current,numbers[g])) {
						outputNumber+=g*Math.pow(10,output.get(i).length-1.0-h);
					}
				}
			}
			sum+=outputNumber;
		}
		System.out.println(sum);
		
	}
	public boolean compare(String a, String b){
		if(a==null || b==null)return false;
		if(a.length()!=b.length())return false;
		int amount=0;
		for(int i=0;i<a.length();i++) {
			if(b.contains(a.charAt(i)+"")) {
				amount++;
			}
		}
		if(amount==a.length())return true;
		return false;
	}
}