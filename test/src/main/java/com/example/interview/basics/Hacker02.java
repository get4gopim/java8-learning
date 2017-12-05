package com.example.interview.basics;

import java.util.Arrays;
import java.util.Scanner;

public class Hacker02 {

	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
		// Complete this function
		int[] ret = new int[2];

		int alice = ((a0 > b0) ? 1 : 0) + ((a1 > b1) ? 1 : 0) + ((a2 > b2) ? 1 : 0);
		int bob = ((b0 > a0) ? 1 : 0) + ((b1 > a1) ? 1 : 0) + ((b2 > a2) ? 1 : 0);

		System.out.println(alice + " " + bob);

		if (a0 > b0) {
			ret[0] += 1;
		} else if (a0 < b0) {
			ret[1] += 1;
		}

		if (a1 > b1) {
			ret[0] += 1;
		} else if (a1 < b1) {
			ret[1] += 1;
		}

		if (a2 > b2) {
			ret[0] += 1;
		} else if (a2 < b2) {
			ret[1] += 1;
		}

		return ret;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
	}
	
	static int solve(int n, int[] s, int d, int m){
        // Complete this function
		int dsum = 0;
		int res = 0;
		
		if (s.length == 1) {
			return 1;
		} else {
			for (int i=m;i<s.length - m;i++) {
				if (s[i] == m && i < s.length-1) {
					dsum = s[i] + s[i+1];
					if (dsum == d) {
						res++;
					}
				}
				if (s[i] == m && i > 0) {
					dsum = s[i] + s[i-1];
					if (dsum == d) {
						res++;
					}
				}
			}
			
			return res;
		}
    }
	
	
	static int[] getRecord(int[] s){
        // Complete this function
        int max = s[0], min = s[0];
        int[] res = new int[2];
        
        for (int i=1;i<s.length;i++) {
        	System.out.println(String.format("s[%d] = %d; max = %d; min = %d; res[0] = %d", i, s[i], max, min, res[0])); 
            if (s[i] > max) {
            	max = s[i];
                res[0] += 1;
            } else if (s[i] < min) {
            	min = s[i];
                res[1] += 1;
            }           
        }
        
        return res;
    }
	
	public static void reverseNo() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        
        for(int arr_i=n-1; arr_i >= 0; arr_i--) {
            System.out.print(arr[arr_i] + " ");
        }
	}
	
	static int[] solve(int[] grades){
		int[] a = new int[grades.length];

		for (int i=0;i<grades.length;i++) {
			int rem = grades[i] % 5;
			if ( grades[i] >= 38 && rem >= 3) {
				a[i] = grades[i] += 5 - rem;
			} else {
				a[i] = grades[i];
			}
		}
		
		return a;
    }
	
	static String timeConversion(String s) {
		// 07:05:45PM
		String str[] = s.split(":");
		int hh = Integer.parseInt(str[0]);
		String mm = str[1];
		String ss = str[2];
		
		String ampm = ss.substring(ss.length()-2);
		String sec = ss.substring(0, ss.length()-2);
		
		if (ampm.equalsIgnoreCase("PM") && hh != 12) {
			hh += 12;
		} else if (ampm.equalsIgnoreCase("AM") && hh == 12) {
			hh -= 12;
		}
		
		return String.format("%02d:%s:%s", hh, mm, sec);
    }
	
	static int birthdayCakeCandles(int n, int[] ar) {
		Arrays.sort(ar);
		int max = Arrays.stream(ar).max().getAsInt();
		
		int sum = 0;
		for (int i=(n-1);i>=0;i--) {
			System.out.println(String.format("ar[%d] = %d", i, ar[i]));
			if (max == ar[i]) {
				sum += 1;
			} else {
				break;
			}
		}

		return sum;
    }
	
	public static void minMax() {
		Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextLong();
        }
        
        long myarr[] = new long[5];
        long sum = Arrays.stream(arr).sum();
        for (int i=0;i<5;i++) {
        	myarr[i] = sum - arr[i];
        }
        
        Arrays.sort(myarr);
        
        System.out.println(String.format("%d %d", myarr[0], myarr[4])); 
	}
	
	public static void staircase() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		
		String stair = "#";
		String format = "%" + n + "s";
		for (int i=0;i<n;i++) {
			System.out.println( String.format(format, stair) );
			stair += "#";
		}
	}
	
	public static void plusMinusFraction() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        int pos = 0, neg = 0, zero = 0;
        for (int i=0;i<arr.length;i++) {
        	//System.out.println(String.format("arr[%d] = %d", i, arr[i]));
        	if (arr[i] < 0) {
        		neg++;
        	} else if (arr[i] > 0) {
        		pos++;
        	} else {
        		zero++;
        	}
        	
        }
        
        //System.out.println(String.format("%d, %d, %d / %d", neg, zero, pos, n));
        
        float p = (float) pos/arr.length;
        float ne = (float) neg/arr.length;
        float z = (float) zero/arr.length;
        System.out.println( String.format("%06f", p) );
        System.out.println( String.format("%06f", ne) );
        System.out.println( String.format("%06f", z) );
        
	}

	public static void findDiagonalDifference(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[][] = new int[n][n];
		for (int a_i = 0; a_i < n; a_i++) {
			for (int a_j = 0; a_j < n; a_j++) {
				a[a_i][a_j] = in.nextInt();
			}
		}

		int sum = 0;
		int dsum = 0;
		for (int i = 0, j = n; i < n; i++) {
			int x = --j;
			System.out.println(String.format("a[%d][%d] = %d", i, i, a[i][i]));
			System.out.println(String.format("a[%d][%d] = %d", i, x, a[i][x]));
			sum += a[i][i];
			dsum += a[i][x];
		}

		int val = sum - dsum;
		System.out.println((val < 0) ? -val : val);

	}

}
