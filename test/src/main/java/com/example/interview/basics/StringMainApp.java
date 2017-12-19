package com.example.interview.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class StringMainApp {

	public static void main(String[] args) {
		MyClass1 call = new MyClass1();
		call.test();
		
		Object obj = null;
		method(null);
		method(obj);
		
		
		
		String key = "KING";
		System.out.println("KING = " + key.hashCode() );
		
		int rightShift16 = key.hashCode() >>> 16;
		System.out.println("rightShift16 = " + rightShift16 );
		
		int hashXOR = key.hashCode() ^ rightShift16;
		System.out.println("hashXOR = " + hashXOR );
		
		int bitAnd = hashXOR & 15;
		System.out.println("bitAnd = " + bitAnd );
		
		System.out.println("map.hash  = " + hash(key) );
		System.out.println("map.hash.index  = " + indexFor(hash(key), 16) );
		
		Map<String, String> map = new HashMap<>();
		map.put(key, "10017897943");
		map.put("QUEEN", "1002");
		map.put("BISHOP", "1003");
		
		map.keySet().stream().forEach(s -> System.out.println(s + "->" + map.get(s)));
		
		Map<String, String> cmap = new ConcurrentHashMap<>();
		cmap.put(key, "10017897943");
		cmap.put("QUEEN", "1002");
		cmap.put("BISHOP", "1003");
		
		cmap.keySet().stream().forEach(s -> System.out.println(s + "->" + map.get(s)));
		String oldVal = cmap.putIfAbsent(key, "99999");
		System.out.println("END = " + oldVal);
	} 
	
	 /*public final int hashCode(Object key) {
         return Objects.hashCode(key) ^ Objects.hashCode(value);
     }*/
	
	static final int hash(Object key) {
	    int h;
	    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	static int indexFor(int h, int length) {
	    return h & (length-1);
	}
	
	public static void method(Object obj) {
		Function<Integer, Integer> squareRoot = x -> x * x;
		
		System.out.println("OBJ :: " + squareRoot.apply(5));
		
	}
	
	public static void method(String obj) {
		System.out.println("STR");
	}
	
	/*public static void method(MyClass1 obj) {
		System.out.println("MyClass1");
	}*/
	
}

class MyClass1 {
	
	private String s1 = "Hello";
	
	public void test() {
		String s2 = new String("Hello");
		String s3 = s2.intern();
		String s4 = s2;
		
		System.out.println("s1 == s2 = " + (s1 == s2) );
		System.out.println("s1 == s3 = " + (s1 == s3) );
		System.out.println("s1 == s4 = " + (s1 == s4) );
		System.out.println("s3 == s4 = " + (s3 == s4) );
		System.out.println("s4 == s2 = " + (s4 == s2) );
	}
}
