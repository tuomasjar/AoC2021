import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static String getTimeString(long runtime) {
		long ms=0;
		long ns=0;
		long us=0;
		ms = runtime/1_000_000;
		us = (runtime%1_000_000)/1000;
		ns = runtime%1000;
//        String result = (runtime / 1_000_000) + " ms";
//        if (runtime < 1000) {
//            result += " (" + runtime + " ns)";
//        } else if (runtime < 1_000_000) {
//            result += " (" + runtime / 1_000 + "µs)";
//        }
        return ms+" ms "+us+" µs "+ns+" ns";
    }

	public static void main(String[] args) {
		Day14 day=new Day14();
		System.out.println("A: ");
		long time = System.nanoTime();
		day.runA();
		long runtime = System.nanoTime()-time;
		System.out.println(getTimeString(runtime));
		System.out.println("B: ");
		long time2 = System.nanoTime();
		day.runB();
		long runtime2 = System.nanoTime()-time2;
		System.out.println(getTimeString(runtime2));
		
		
	}
	
	public static void makeTemplate() {
		for(int i=1;i<26;i++) {
			String fileNumber="";
			if(i<10)fileNumber="0"+i;
			else fileNumber=""+i;
			try {
				FileWriter fw = new FileWriter("./src/Day"+fileNumber+".java");
				StringBuilder str = new StringBuilder();
				str.append("public class Day"+fileNumber+" extends Day{\n");
				str.append("\tpublic Day"+fileNumber+"(){\n");
				str.append("\t\tsuper("+i+");\n");
				str.append("\t}\n");
				str.append("\tpublic void runA(){\n");
				str.append("\t\tSystem.out.println(\""+i+" A\");\n");
				str.append("\t}\n");
				str.append("\tpublic void runB(){\n");
				str.append("\t\tSystem.out.println(\""+i+" B\");\n");
				str.append("\t}\n");
				str.append("}");
				fw.write(str.toString());
				File f = new File("./res/Day"+fileNumber+"input.txt");
				f.createNewFile();
				fw.close();
			}catch(IOException e) {
				System.out.println("Failed");
			}
		}
	}
	public static void caseTemplate() {	
			try {
				FileWriter fw = new FileWriter("./res/case.txt");
				StringBuilder str = new StringBuilder();
				str.append("switch(latest){\n");
				for(int i=1;i<26;i++) {
					String caseNumber=""+i;
					String file = "";
					if(i<10)file="0"+i;
					else file = ""+i;
					str.append("\tcase "+caseNumber+":\n");
					str.append("\t\tDay"+file+" day"+caseNumber+"=new Day"+file+"();\n");
					str.append("\t\tSystem.out.println(\"Day "+caseNumber+":\");\n");
					str.append("\t\tSystem.out.println(\"A: \");\n");
					str.append("\t\tday"+caseNumber+".runA();\n");
					str.append("\t\tSystem.out.println(\"B: \");\n");
					str.append("\t\tday"+caseNumber+".runB();\n");
					str.append("\t\tbreak;\n");
					
				}
				str.append("\t}\n");
				fw.write(str.toString());
				File f = new File("./res/case.txt");
				
				f.createNewFile();
				fw.close();
			}catch(IOException e) {
				System.out.println("Failed");
			}
		}
	
}
