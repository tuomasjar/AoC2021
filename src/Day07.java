import java.util.ArrayList;
import java.util.HashMap;

public class Day07 extends Day{
	HashMap<Integer,Integer> sigmas;
	
	public Day07(){
		super(7);
		sigmas=new HashMap<>();
	}
	public int sigma(int x) {
		if(sigmas.containsKey(x))return sigmas.get(x);
		int sum=0;
		for(int i=0;i<=x;i++) {
			sum+=i;
		}
		sigmas.put(x, sum);
		return sum;
	}
	
	public void runA(){
		String input = readNextLine();
		String[] splitInput = input.split(",");
		ArrayList<Integer> crabbys = new ArrayList<>();
		int maxValue=0;
		for(int i=0;i<splitInput.length;i++) {
			crabbys.add(Integer.parseInt(splitInput[i]));
		}
		for(int x:crabbys) {
			if(x>maxValue)maxValue=x;
		}
		int[] crabs = new int[maxValue+1];
		for(int x:crabbys) {
			crabs[x]++;
		}
		long fuel=0;
		for(int i=0;i<crabs.length;i++) {
			long currentFuel=0;
			for(int j=0;j<crabs.length;j++) {
				if(i!=j) {
					currentFuel += Math.abs(i-j)*crabs[j];
				}
			}
			if(fuel==0)fuel=currentFuel;
			else if(fuel>currentFuel)fuel=currentFuel;
		}
		System.out.println(fuel);
	}
	public void runB(){
		resetScanner();
		String input = readNextLine();
		String[] splitInput = input.split(",");
		ArrayList<Integer> crabbys = new ArrayList<>();
		int maxValue=0;
		for(int i=0;i<splitInput.length;i++) {
			crabbys.add(Integer.parseInt(splitInput[i]));
		}
		for(int x:crabbys) {
			if(x>maxValue)maxValue=x;
		}
		int[] crabs = new int[maxValue+1];
		for(int x:crabbys) {
			crabs[x]++;
		}
		long fuel=0;
		for(int i=0;i<crabs.length;i++) {
			long currentFuel=0;
			for(int j=0;j<crabs.length;j++) {
				if(i!=j) {
					currentFuel += sigma(Math.abs(i-j))*crabs[j];
				}
			}
			if(fuel==0)fuel=currentFuel;
			else if(fuel>currentFuel)fuel=currentFuel;
		}
		System.out.println(fuel);
	}
}