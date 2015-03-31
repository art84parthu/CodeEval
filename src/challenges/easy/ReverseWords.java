package challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWords {
	public static void main(String[] args) {
	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.trim().split("\\s");
	            int i=lineArray.length-1;
	            for(; i>0; i--){
	            	System.out.print(lineArray[i] + " ");
	            }
	            System.out.println(lineArray[i]);
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }         
	}
}
