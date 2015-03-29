package challenges.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubSequence {

	 public static void main (String[] args) throws IOException {
	        File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            if(line.length() > 0){
	            	String[] sequences = line.split(";");
	            	if(sequences.length == 2){
	            		HashMap<Character, Integer> presenceMap = new HashMap<Character, Integer>();
	            		int mapIndex = 0;
	            		if(sequences[0].length() > sequences[1].length()){
	            			mapIndex = 1;
	            		}
	            		int[] seqIndices = new int[sequences[mapIndex].length()];
	            		populateMap(mapIndex, sequences, presenceMap, seqIndices);
	            		
	            		List<LinkedList<Integer>> subsequences = new ArrayList<LinkedList<Integer>>();
	            	
	            		for(int i=0; i<seqIndices.length; i++){
	            			boolean charAdded = false;
	            			int index = seqIndices[i];
	            			for(LinkedList<Integer> seqj : subsequences){
	            				if(seqj.size() > 0 && seqj.getLast() < seqIndices[i]){
	            					seqj.addLast(seqIndices[i]);
	            					charAdded = true;
	            				}
	            			}
	            			if(!charAdded && index >= 0){
	            				LinkedList<Integer> newSubSequence = new LinkedList<Integer>();
	            				newSubSequence.addLast(seqIndices[i]);
	            				subsequences.add(newSubSequence);
	            			}
	            		}
	            		
	            		int maxSeqIndex = 0;
	            		for(int i=0; i<subsequences.size(); i++){
	            			LinkedList<Integer> seqj = subsequences.get(i);
	            			if(seqj.size() > subsequences.get(maxSeqIndex).size()){
	            				maxSeqIndex = i;
	            			}
	            		}
	            		
	            		LinkedList<Integer> result = subsequences.get(maxSeqIndex);
	            		int index = Math.abs(mapIndex-1);
	            		String seq = sequences[index];
	            		for(int i: result){
	            			System.out.print(seq.charAt(i));
	            		}
	            		System.out.println();
	            		
	            	}
	            }
	        }
	        buffer.close();
	    }

	private static void populateMap(int mapIndex, String[] sequences,
			HashMap<Character, Integer> presenceMap, int[] seqIndices) {
		String seq = sequences[mapIndex];
		for(int i=0; i<seq.length(); i++){
			presenceMap.put(seq.charAt(i), i);
			seqIndices[i] = -1;
		}
		int index = Math.abs(mapIndex-1);
		seq = sequences[index];//Get the other string
		for(int i=0; i<seq.length(); i++){
			char c = seq.charAt(i);
			Integer i1 = presenceMap.get(c);
			if( i1 != null){
				seqIndices[i1] = i;
			}
		}
	}
	
	
	
}
