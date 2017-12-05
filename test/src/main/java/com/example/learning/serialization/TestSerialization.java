package com.example.learning.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class TestSerialization {

	private static final Logger LOGGER = Logger.getLogger(TestSerialization.class);
	
	public static void main(String[] args) {
		
		Author auth = new Author();
		auth.setAuthorName("Henry Ford");
		List<String> history = new ArrayList<>();
		history.add("12/02/2002");
		history.add("05/11/2007");
		auth.setHistory(history);
		auth.setPublisherName("Vikatan Publish");
		//auth.setTitle("Thirai Bimbamnagl");
		
		auth.setIssueName("Malai Malar");
		auth.setTotalPages(852);

		LOGGER.debug(auth.toString());
		
		//writeObject(auth);
		auth = readObject();

		LOGGER.debug(auth.toString());
	}

	private static void writeObject(Author obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("magazine"))) {
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e.toString(), e);
		}
	}

	private static Author readObject() {
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("magazine"))) {
			return (Author) oos.readObject();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e.toString(), e);
		}
		return null;
	}	
}
