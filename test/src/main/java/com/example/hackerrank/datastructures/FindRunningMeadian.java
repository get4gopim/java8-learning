package com.example.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindRunningMeadian {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        
        double[] res = new double[n];
        int j = 0;        
        
        for(int a_i=0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            
            List<Integer> list = new ArrayList<>();
        	for (int k=0;k<=a_i;k++) {        		
        		list.add(a[k]);        		
        	}        	
            
            Collections.sort(list);
            
            int x = list.size() / 2;
        	if (x == 0 || list.size() % 2 != 0) {
        		res[j] = list.get(x);
        	} else if (list.size() % 2 == 0) {        		
        		res[j] = ((double) list.get(x-1) + list.get(x)) / 2;
        	}
        	j++;
        }        
        
        Arrays.stream(res).forEach(System.out::println);
        
        in.close();
	}
	

}
