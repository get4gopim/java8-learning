package com.example.interview.basics;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Hacker1 {

	public Hacker1() {
		// TODO Auto-generated constructor stub
	}

	static long getWays(long goal, long[] coins){

        long[] solutionsTable = new long[(int)goal+1];

        solutionsTable[0] = (long)1;

        int step = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = (int)coins[i]; j <= goal; j++) {
            	int count = j - (int) coins[i];
                solutionsTable[j] += solutionsTable[count];

                System.out.println("---------------" + " step " + step + " ----------------");
                System.out.println("ultimate goal: " + goal);
                System.out.println("coins available: " + Arrays.toString(coins));
                System.out.println("current coin: " + coins[i]);
                System.out.println("current goal: " + j + "\n");

                System.out.println(Arrays.toString(solutionsTable) + "\n");

                step++;
            }
        }

        return solutionsTable[(int)goal];

    }

	static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++)
        {
        	//System.out.println(String.format("%d - %d = %d", arr[i], arr[i+1], arr[i]-arr[i+1]));
            int currentMin = Math.abs(arr[i]-arr[i+1]);
            min = Math.min(min, currentMin);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
	
	static int camelCase(String s) {
		int count = 0;
		
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isUpperCase(ch)) {
				//System.out.println(" " + ch);
				count++;
			}
		}
		
		return count+1;
	}
	
	static int migratoryBirds(int n, int[] ar) {
        // Complete this function
		Map<Integer, Integer> typeCounts = new HashMap<>();
		for (int i = 1; i<=5; i++) {
			typeCounts.put(i, 0);
		}
		
		int max = 0;
		for (int i=0;i<n;i++) {
			for (Integer key : typeCounts.keySet()) {
				if (ar[i] == key) {
					int count = typeCounts.get(key) + 1;
					typeCounts.put(key, count);
					System.out.println(String.format("ar[%d], %d == %d +++ %d", i, ar[i], key, count));
				}
			}
		}
		
		int val = 0;
		for (Integer key : typeCounts.keySet()) {
			if (typeCounts.get(key) > max) {
				max = typeCounts.get(key);
				val = key;
			}
			System.out.println(key + "::" + typeCounts.get(key));
		}
		
		return val;
    }
	
	static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        int counter = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
            	//if (i > j) System.out.println(String.format("ar[%d] = %d; ar[%d] = %d", i, ar[i], j, ar[j]));
            	
                if ( (i > j) && ((ar[i] + ar[j]) % k == 0) ) {
                	//System.out.println(String.format("(%d, %d)", ar[i], ar[j]));
                	counter++;
                }
            }
        }
        return counter;
    }

	
	static String super_reduced_string(String s){
        // Complete this function	
		
		char c[] = s.toCharArray();
		System.out.println(c.length);
		Arrays.sort(c);
		System.out.println(c.length);
		
		String back = Arrays.toString(c);
		System.out.println(back.toString());
		
		int i = 0;
		while (i < c.length) {
			System.out.println(" i = " + i + "; back.len = " + c.length);
			if ((i < c.length) && (c[i] == c[i+1]) ) {
				back = back.substring(i+1);
			}
			i++;
		}
		
        return "Empty String";
    }
	
	static int betweenTwoSets(int[] a, int[] b) {
        // Complete this function         
        int xMin = 1, xMax = 101;
        int sum = 0;
        
        intCheck:
        for (int i=xMin; i<=xMax; i += xMin) {

            for (int num : a) {
                if (i % num != 0) {
                    continue intCheck;
                }
            }

            for (int num : b) {
                if (num % i != 0) {
                    continue intCheck;
                }
            }

            sum++;
        }

        return sum;
    }
	
	static String kangaroo(int x1, int v1, int x2, int v2) {
		int n = 20000;
		if (x1 > x2) {
			n = x1 * n;
		} else {
            n = x2 * n;
        }
		
		//System.out.println(String.format("times == %d", n));
		
		for (int i=x1, j=x2; i<n; i += v1, j += v2) {
			//System.out.println(String.format("%d == %d", i, j));
			if (i == j) {
				return "YES";
			}
		}
		
		return "NO";
    }
	
	public static void appleAndOrange() {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        
        // code begins
        
        int a_arr[] = new int[apple.length];
        for (int i=0; i<apple.length; i++) {
            a_arr[i] = a + apple[i];
        }

        int b_arr[] = new int[orange.length];
        for (int i=0; i<orange.length; i++) {
            b_arr[i] = b + orange[i];
        }

        int a_sum = 0;
        for (int i=0; i<a_arr.length; i++) {
            if (a_arr[i] >= s && a_arr[i] <= t) {
                a_sum += 1;
            }
        } 

        int b_sum = 0;
        for (int i=0; i<b_arr.length; i++) {
            if (b_arr[i] >= s && b_arr[i] <= t) {
                b_sum += 1;
            }
        }

        System.out.println(a_sum);
        System.out.println(b_sum);
    }
	
	public static void testMain() throws Exception {
		List<String> list = new ArrayList<>();
		list.add("19th Oct 2015");
		list.add("25th Mar 2004");
		list.add("1st Jan 2504");
		list.add("3rd Feb 2114");
		
		String[] inArr = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(inArr));		
		//Arrays.stream(inArr).forEach(str -> System.out.println(str));
		
		String[] outArr = test(inArr);
		
		System.out.println(Arrays.toString(outArr));
		//Arrays.stream(outArr).forEach(str -> System.out.println(str));
	}
	
	public static String[] test(String... inputArr) throws ParseException {
		List<String> list = new ArrayList<>();
		
		/*SimpleDateFormat fmt = new SimpleDateFormat("DD/Mmm/yyyy");
		SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd");*/
		
		for (String input : inputArr) {
			
			LocalDate ldt = LocalDate.parse(input, DateTimeFormatter.ofPattern("d['st']['th']['nd']['rd'] MMM yyyy",Locale.ENGLISH));
			System.out.println(" --> " + ldt.toString());
			
			String arr[] = input.split(" ");
			
			String year = arr[2];
			String mon = arr[1];
			String dateStr =  arr[0];
			String dt = dateStr.substring(0, dateStr.length()-2);
			dt = String.format("%02d", Integer.parseInt(dt));
			
			DateMonth mm = DateMonth.valueOf(mon);
			
			list.add(year + "-" + mm.getMon() + "-" + dt);
		}
		
		return list.toArray(new String[list.size()]);
	}
	
	public static long power(int x, int y) throws Exception {
		if (x < 0 || y < 0) {
			throw new Exception("n or p should not be negative.");
		} else if (x == 0 || y == 0) {
			throw new Exception("n and p should not be zero.");
		}
		return (int) Math.pow(x, y);
		
		// System.out.println("" + power(-1, 0));
	}
	
	public void exceptionHandling() {
		Scanner s = new Scanner(System.in);
		int x = 0, y = 0;
		try {
			x = s.nextInt();
			y = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("java.util.InputMismatchException");
			System.exit(0);
		}
		try {
			int result = x / y;
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
	}

	public void test() throws IOException {
		A a = new A();
		B b = new B();
		A c = b;
	}

}

enum DateMonth {
	Jan("01"), Feb("02"), Mar("03"),  Oct("10");
	
	private String mon;
	
	private DateMonth(String m) {
		this.mon = m;
	}

	public String getMon() {
		return mon;
	}
}

class A {

	public A() throws IOException {
		throw new IOException("ex");
	}
}

class B extends A {
	public B() throws IOException {
		super();
	}
}

class C extends A {
	public C() throws IOException {
		super();
	}
}
