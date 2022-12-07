import java.util.*;

public class Day14 extends Day{
	public Day14(){
		super(14);
	}
	public void runA(){
		HashMap<String,String> replace = new HashMap<>();
		String patientZero = readNextLine();
		readNextLine();
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			String[] inputParse = input.strip().split(" -> ");
			replace.put(inputParse[0], inputParse[1]);
		}
		StringBuilder result = new StringBuilder(patientZero);
		for(int i=0;i<10;i++) {
			StringBuilder build = new StringBuilder();
			for(int j=0;j<result.length()-1;j++) {

				String key = ""+result.charAt(j)+result.charAt(j+1);
				build.append(""+result.charAt(j)+replace.get(key));
			}
			build.append(result.charAt(result.length()-1));
			result = build;
		}
		HashMap <Character,Integer> countThemOut = new HashMap<>();
		for(int i=0;i<result.length();i++) {
			if(countThemOut.containsKey(result.charAt(i))) {
				int current = countThemOut.get(result.charAt(i));
				countThemOut.replace(result.charAt(i), ++current);
			}else {
				countThemOut.put(result.charAt(i), 1);
			}
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int amount : countThemOut.values()) {
			if(amount>max)max = amount;
			if(amount<min)min = amount;
		}
		System.out.println(max+" - "+min+" = "+(max-min));
	}
	public void runB(){
		resetScanner();
		HashMap<String,String> replace = new HashMap<>();
		HashMap<String,Long> amounts = new HashMap<>();
		HashMap<Character,Long> calculations =new HashMap<>();
		String patientZero = readNextLine();
		readNextLine();
		while(!endOfFile) {
			String input = readNextLine();
			if(input==null)break;
			String[] inputParse = input.strip().split(" -> ");
			replace.put(inputParse[0], inputParse[1]);
		}
		for(String key:replace.keySet()) {
			amounts.put(key, 0L);
		}
		for(int i=0;i<patientZero.length()-1;i++) {
			String key=""+patientZero.charAt(i)+patientZero.charAt(i+1);
			amounts.replace(key, amounts.get(key)+1);
		}
		
		System.out.println("Amounts: "+amounts.entrySet());
		for(int i=0;i<10;i++) {
			for(String key:amounts.keySet()) {
				HashMap <String,Long> temp = new HashMap<>();
				String key1 = key.charAt(0)+replace.get(key);
				String key2 = replace.get(key)+key.charAt(1);
				amounts.replace(key1, amounts.get(key1)+1);
				amounts.replace(key2,amounts.get(key2)+1);
			}
			System.out.println("Amounts: "+amounts.entrySet());
		}
		
		for(String key:amounts.keySet()) {
			if(calculations.containsKey(key.charAt(0))) {
				calculations.replace(key.charAt(0),calculations.get(key.charAt(0))+amounts.get(key));
			}else {
				calculations.put(key.charAt(0),amounts.get(key));
			}
			
			if(calculations.containsKey(key.charAt(1))) {
				calculations.replace(key.charAt(1),calculations.get(key.charAt(1))+amounts.get(key));
			}else {
				calculations.put(key.charAt(1),amounts.get(key));
			}
		}
		
		long max=0;
		long min=Long.MAX_VALUE;
		for(Long value:calculations.values()) {
			if(value>max)max=value;
			if(value<min)min=value;
		}
		System.out.println(max+"-"+min+"="+(max-min));
	}
}