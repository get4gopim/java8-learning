package com.example.hackerrank.datastructures;

import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int finalArr[] = new int[a.length];
        for (int i=k, j=0;i<n;i++, j++) {
        	finalArr[j] = a[i];
        }
        
        for (int i=0, j=(n-k);i<k;i++, j++) {
        	finalArr[j] = a[i];
        }
        
        System.out.print(finalArr[0]);
        for (int i=1; i<n; i++) {
        	System.out.print(" " + finalArr[i]);
        }
    }

}
