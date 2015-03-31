package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RemoveChars {
	public static void main(String[] args) {
	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	String[] lineArray = line.trim().split(",");
	        	if(lineArray.length == 2){
	        		String chars = lineArray[1].trim();
	        		String str = lineArray[0].trim();
	        		StringBuffer result = new StringBuffer();
	        		int i=0;
	        		for(; i<str.length(); i++ ){
	        			String c = str.charAt(i)+"";
	        			if(!chars.contains(c)){
	        				result.append(c);
	        			}
	        		}
	        		System.out.println(result);
	        	}
	        }
	        in.close();
	    } catch (IOException e) {
	    	System.out.println("File Read Error: " + e.getMessage());
	    }         
	}
}
