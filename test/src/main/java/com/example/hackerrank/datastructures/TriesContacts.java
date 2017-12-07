package com.example.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriesContacts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        List<String> list = new ArrayList<>();
        List<String> find = new ArrayList<>();
        
        List<Integer> index = new ArrayList<>();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if (op.equals("add")) {
            	list.add(contact);
            } else if (op.equals("find")) {
            	find.add(contact);
            }
        }
        
	}
	
	static void solution() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        List<String> list = new ArrayList<>();
        List<String> find = new ArrayList<>();
        
        List<Integer> index = new ArrayList<>();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if (op.equals("add")) {
            	list.add(contact);
            } else if (op.equals("find")) {
            	find.add(contact);
            }
        }
        
        for (String search : find) {  
        	int count = 0;
        	for (String tobe : list) {
        		if (tobe.contains(search)) {
        			count++;
        		}
        	}
        	index.add(count);
        }
        
        index.stream().forEach(System.out::println);
	}

}
