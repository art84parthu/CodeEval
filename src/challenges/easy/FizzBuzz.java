package challenges.easy;

import java.io.*;

public class FizzBuzz {
	public static void main(String[] args) {
	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.trim().split("\\s");
	            if (lineArray.length == 3) {
	            	int X = Integer.parseInt(lineArray[0]);
	            	int Y = Integer.parseInt(lineArray[1]);
	            	int N = Integer.parseInt(lineArray[2]);
	            	
	            	System.out.println();
	            	int i=1;
	            	for(; i<N; i++){
	            		printFizzBuzz(i, X, Y);
	            		System.out.print(" ");
	            	}
	            	printFizzBuzz(i, X, Y);
	            } 
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
	
	private static void printFizzBuzz(int i, int X, int Y){
		if(i / X == 0 && i / Y == 0){
			System.out.print("FB");
		}else if(i / X == 0){
			System.out.print("F");
		}else if(i / Y == 0){
			System.out.print("B");
		}else{
			System.out.print(i);
		}
	}
}
