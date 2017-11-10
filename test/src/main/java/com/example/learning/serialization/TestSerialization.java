package com.example.learning.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestSerialization {

	public static void main(String[] args) {
		/*Magazine magazine = new Magazine("The Hindu", "Sun Rise On East", 489);
		
		Author auth = new Author();
		auth.setAuthorName("Henry Ford");
		List<String> history = new ArrayList<>();
		history.add("12/02/2002");
		history.add("05/11/2007");
		auth.setHistory(history);
		
		auth.setIssueName("Malai Malar");
		auth.setTotalPages(852);

		writeObject(auth);*/

		//Author auth = readObject();

		//System.out.println(auth.toString());
		
		System.out.println(Magazine.magazineId);
	}

	private static void writeObject(Author obj) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("magazine"));
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Author readObject() {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("magazine"));
			return (Author) oos.readObject();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
