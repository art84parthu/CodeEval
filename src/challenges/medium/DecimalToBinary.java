package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DecimalToBinary {
	public static void convertUsingJava(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if(line.length() > 0){
					int num = Integer.valueOf(line);
					System.out.println(Integer.toBinaryString(num));
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if(line.length() > 0){
					int num = Integer.valueOf(line);
					if(num <= 0){
						System.out.println("0");
					}else{
						int[] binary = convert(num, null);
						printBinary(binary);
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
	public static int[] convert(int num, int[] binary){
		if(num == 0) {
			return binary;
		}
		
		int powerValue = 0;
		int power = 0;
		powerValue = Double.valueOf(Math.pow(2, power)).intValue();
		while(powerValue <= num){
			power++;
			powerValue = Double.valueOf(Math.pow(2, power)).intValue();
		}
		binary = createArrayIfRequired(binary, power--);
		binary[power] = 1;
		
		num = num-Double.valueOf(Math.pow(2, power)).intValue();
		if(num > 0) {
			return convert(num, binary);
		}
		return binary;
	}
	
	private static int[] createArrayIfRequired(int[] arr, int size){
		if(arr == null){
			arr = new int[size];
		}
		return arr;
	}
	
	private static void printBinary(int[] bin){
		for(int i=bin.length-1; i>=0; i--){
			System.out.print(bin[i]);
		}
		System.out.println();
	}
}
