package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FirstNonRepeatingChar {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if(line.trim().length() > 0){
					System.out.println(findFirstNonRepeatingChar(line.trim()));
				}
			}
			
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}               
	}
	
	
	public static Character findFirstNonRepeatingChar(String s){
		if(s == null || s.trim().length() == 0) return null;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++){
			Character c = s.charAt(i);
			Integer count = map.get(c);
			if(count == null){
				map.put(c, 1);
			}else{
				map.put(c, ++count);
			}
		}
		
		for(int i=0; i<s.length(); i++){
			Character c = s.charAt(i);
			Integer count = map.get(c);
			if(count == 1){
				return c;
			}
		}
		
		return null;
	}
}
