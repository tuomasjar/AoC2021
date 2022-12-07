import java.util.*;

public class Day03 extends Day{
	public Day03(){
		super(3);
	}
	public void runA(){
		int[] gammas = new int[12];
		int[] epsilons= new int[12];
		int[] binaries = new int[12];
		double amount=0;
		
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			for(int i=0;i<input.length();i++) {
				binaries[i]+=Integer.parseInt(input.charAt(i)+"");
			}
			amount++;
		}
		for(int i=0;i<binaries.length;i++) {
			double percent = binaries[i]/amount;
			if(percent>=0.5)gammas[i]=1;
			else epsilons[i]=1;
		}
		int gamma =0;
		int epsilon=0;
		for(int i=0;i<gammas.length;i++) {
			if(gammas[i]==1)gamma+=(int)Math.pow(2, gammas.length-i-1);
			if(epsilons[i]==1)epsilon+=(int)Math.pow(2, epsilons.length-i-1);
		}
		
		System.out.println("Power: "+(gamma*epsilon));
		}
	
	
	public void runB(){
		int numberOfBits=12;
		resetScanner();
		ArrayList<String> inputOxygen = new ArrayList<>();
		ArrayList<String> inputCO2 = new ArrayList<>();
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			inputOxygen.add(input);
			inputCO2.add(input);
		}
		int one=0;
		int zero=0;
		for(int i=0;i<numberOfBits;i++) {
			one=0;
			zero=0;
			if(inputOxygen.size()==1)break;
			for(int j=0;j<inputOxygen.size();j++) {
				if(inputOxygen.get(j).charAt(i)=='1')one++;
				else zero++;
			}
			if(one>=zero) {
				for(int k=0;k<inputOxygen.size();k++) {
					if(inputOxygen.get(k).charAt(i)=='0') {
						inputOxygen.remove(k);
						if(inputOxygen.size()==1)break;
						k--;
					}
				}
			}else {
				for(int k=0;k<inputOxygen.size();k++) {
					if(inputOxygen.get(k).charAt(i)=='1') {
						inputOxygen.remove(k);
						if(inputOxygen.size()==1)break;
						k--;
					}
				}
			}
		}
		int oxy=Integer.parseInt(inputOxygen.get(0),2);
		System.out.println(oxy);
		for(int i=0;i<numberOfBits;i++) {
			one=0;
			zero=0;
			if(inputCO2.size()==1)break;
			for(int j=0;j<inputCO2.size();j++) {
				if(inputCO2.get(j).charAt(i)=='1')one++;
				else zero++;
			}
			
			if(zero>one) {
				for(int k=0;k<inputCO2.size();k++) {
					if(inputCO2.get(k).charAt(i)=='0') {
						inputCO2.remove(k);
						if(inputCO2.size()==1)break;
						k--;
					}
				}
			}else {
				
				for(int k=0;k<inputCO2.size();k++) {
					if(inputCO2.get(k).charAt(i)=='1') {
						inputCO2.remove(k);
						if(inputCO2.size()==1)break;
						k--;
					}
				}
			}
		}
		int co2=Integer.parseInt(inputCO2.get(0),2);
		System.out.println(co2);
		System.out.println(co2*oxy);
		
	}
}