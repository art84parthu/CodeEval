package challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Multiples {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String[] lineArray = line.trim().split(",");
				int x = Integer.parseInt(lineArray[0].trim());
				int n = Integer.parseInt(lineArray[1].trim());
				int multiples = n;
				if(n < x){
					while(multiples < x){
						multiples = multiples + n;
					}
					System.out.println(multiples);
				}else{
					System.out.println(n);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
}
