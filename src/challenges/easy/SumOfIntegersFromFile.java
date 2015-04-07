package challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumOfIntegersFromFile {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = null;
			Double sum = new Double("0");
			while ((line = in.readLine()) != null) {
				Double num = Double.valueOf(line.trim());
				sum += num;
			}
			
			System.out.println(sum.intValue());
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
}
