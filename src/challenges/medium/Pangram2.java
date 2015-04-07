package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * This got a score of 56.417
 * A little better in memory and performance
 * 2	Java	Apr 07, 2015	Solved	100	490	4509696	yes		56.417
 */
public class Pangram2{
	private static final char[] alphabets = new char[27];
	
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim().toLowerCase();
				
				initAlphaArray();
				for(int i=1; i<=26; i++){
					char c = alphabets[i];
					if(line.contains(String.valueOf(c))){
						alphabets[i] = '\u0000';
					}
				}
				
				boolean pangram = true;
				for(int i=1; i<= 26; i++){
					if(alphabets[i] != '\u0000'){
						pangram = false;
						System.out.print(alphabets[i]);
					}
				}
				if(!pangram){
					System.out.println();
				}else{
					System.out.println("NULL");
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
	private static void initAlphaArray(){
		alphabets[1]='a';alphabets[2]='b';alphabets[3]='c';alphabets[4]='d';alphabets[5]='e';alphabets[6]='f';
		alphabets[7]='g';alphabets[8]='h';alphabets[9]='i';alphabets[10]='j';alphabets[11]='k';alphabets[12]='l';
		alphabets[13]='m';alphabets[14]='n';alphabets[15]='o';alphabets[16]='p';alphabets[17]='q';alphabets[18]='r';
		alphabets[19]='s';alphabets[20]='t';alphabets[21]='u';alphabets[22]='v';alphabets[23]='w';alphabets[24]='x';
		alphabets[25]='y';alphabets[26]='z';
	}

}