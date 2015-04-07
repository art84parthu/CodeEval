package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/*
 * This got a score of 53.something
 * Pangram2 performed a lil better than this. 
 * 1	Java	Apr 07, 2015	Solved	100	818	5636096	no		---
 */
public class Pangram{
	private static final char[] alphabets = new char[27];
	
	private static final HashMap<Character, Integer> alphabetOrder = new HashMap<Character, Integer>();
	static {
		alphabetOrder.put('a', 1); alphabetOrder.put('b', 2); alphabetOrder.put('c', 3); alphabetOrder.put('d', 4);
		alphabetOrder.put('e', 5); alphabetOrder.put('f', 6); alphabetOrder.put('g', 7); alphabetOrder.put('h', 8); 
		alphabetOrder.put('i', 9); alphabetOrder.put('j', 10); alphabetOrder.put('k', 11); alphabetOrder.put('l', 12); 
		alphabetOrder.put('m', 13); alphabetOrder.put('n', 14); alphabetOrder.put('o', 15); alphabetOrder.put('p', 16); 
		alphabetOrder.put('q', 17); alphabetOrder.put('r', 18); alphabetOrder.put('s', 19); alphabetOrder.put('t', 20); 
		alphabetOrder.put('u', 21); alphabetOrder.put('v', 22); alphabetOrder.put('w', 23); alphabetOrder.put('x', 24);
		alphabetOrder.put('y', 25); alphabetOrder.put('z', 26); 
	}
	
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim().toLowerCase();
				
				initAlphaArray();
				for(int i=0; i<line.length(); i++){
					Character c = line.charAt(i);
					Integer index = alphabetOrder.get(c);
					if(index != null){
						alphabets[index] = '\u0000';
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
		Iterator<Map.Entry<Character, Integer>> it = alphabetOrder.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>)it.next();
			alphabets[(int)pair.getValue()] = (char)pair.getKey();
		}
	}

}