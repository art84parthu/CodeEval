package challenges.medium;

import java.io.*;

public class MthToLast{
	
	public static void main(String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.trim().split("\\s");
	            int len = lineArray.length - 1;
	            if (len > 0) {
	               String s = lineArray[lineArray.length-1];
	               try{
	            	   int m = Integer.parseInt(s);
	            	   if(m <= len){
	            		   System.out.println(lineArray[len-m]);
	            	   }
	               }catch(NumberFormatException nbe){}
	            }
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }
	}
}
	