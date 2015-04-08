package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintPrimes {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				StringBuilder sb = new StringBuilder();
				int num = Integer.parseInt(line);
				if(num >= 2){
					sb.append("2");
				}
				int i=3;
				while( i<num ){
					if(checkIfPrime(i)){
						sb.append(","+i);
					}
					i = i+2;
				}
				if(sb.length() > 0){
					System.out.println(sb);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
	
	private static boolean checkIfPrime(int num){
		if(num <= 1) return false;
		
		for(int i=3; i*i <= num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
}
