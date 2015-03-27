package challenges.medium;

import java.io.*;
import java.util.*;

public class LongestLine{
	public static void main2(String[] args){
		 try {
		        File file = new File(args[0]);
		        BufferedReader in = new BufferedReader(new FileReader(file));
		        String line = in.readLine();
		        
		        int limit = Integer.parseInt(line);
		        String[] output = new String[limit];
		        for(int i=0; i<limit; i++){
		        	output[i] = "";
		        }
		        
		        while ((line = in.readLine()) != null) {
		        	int curLen = line.trim().length();
		        	if(curLen < output[limit-1].length()){
		        		continue;
		        	}
		        	for(int i=0; i<limit; i++){
		        		int len = output[i].length();
		        		if(curLen > len){
		        			pushLinesDown(i, line, output);
		        			break;
		        		}
		        	}
		        }
		        printArray(output);
		        in.close();
		    } catch (IOException e) {
		        System.out.println("File Read Error: " + e.getMessage());
		    }     
	}
	
	public static void main(String[] args){
		 try {
		        File file = new File(args[0]);
		        BufferedReader in = new BufferedReader(new FileReader(file));
		        String line = in.readLine();
		        
		        int limit = Integer.parseInt(line);
		        LengthComparator comparator = new LengthComparator();
		        TreeSet<String> sortedLines = new TreeSet<String>(comparator);
		        while ((line = in.readLine()) != null) {
		        	sortedLines.add(line);
		        }
		        for(int i=0; i<limit; i++){
		        	System.out.println(sortedLines.pollFirst());
		        }
		        in.close();
		    } catch (IOException e) {
		        System.out.println("File Read Error: " + e.getMessage());
		    }     
	}
	
	private static void pushLinesDown(int i, String newLine, String[] lines){
		if(i >= lines.length) return;
		if(lines[i].equals("")){
			lines[i] = newLine;
			return;
		}else{
			String old = lines[i];
			lines[i] = newLine;
			pushLinesDown(i+1, old, lines);
		}
	}
	
	private static void printArray(String[] output){
		for(String str: output){
			System.out.println(str);
		}
	}
	
	private static class LengthComparator implements Comparator<String>{
		public int compare(String s1, String s2){
			if(s1.length() < s2.length()){
				return 1;
			}else{
				return -1;
			}
		}
	}
}