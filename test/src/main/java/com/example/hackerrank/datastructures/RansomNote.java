package com.example.hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        System.out.println(solve(magazine, ransom) ? "Yes" : "No");
	}
	
	static boolean solve(String[] magazine, String[] ransom) {
		Map<String, Integer> magMap = new HashMap<>();
		Map<String, Integer> noteMap = new HashMap<>();
		
		fillMap(magazine, magMap);
		fillMap(ransom, noteMap);
		
		for (String note : noteMap.keySet()) {
			if (!magMap.containsKey(note)) return false;
			
			int magWordCount = magMap.get(note);
			int noteWordCount = noteMap.get(note);
			
			if (noteWordCount > magWordCount) return false;
		}
		
		return true;
	}
	
	static void fillMap(String[] words, Map<String, Integer> map) {
		for (String word : words) {
			if (!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				int count = map.get(word) + 1;
				map.put(word, count);
			}
		}
	}

}
