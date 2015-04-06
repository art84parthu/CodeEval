package challenges.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BitPositions {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String[] lineArray = line.trim().split(",");
				if(lineArray.length == 3){
					try{
						int n = Integer.parseInt(lineArray[0].trim());
						int p1 = Integer.parseInt(lineArray[1].trim()) - 1;
						int p2 = Integer.parseInt(lineArray[2].trim()) - 1;

						int nRightP1 = n >>> p1;
						int nRightP2 = n >>> p2;
						
						int bitP1 = nRightP1 & 1;
						int bitP2 = nRightP2 & 1;
						
						if(bitP1 == bitP2){
							System.out.println("true");
						}else{
							System.out.println("false");
						}
					}catch(NumberFormatException nbe){
						
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
}
