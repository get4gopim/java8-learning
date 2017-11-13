package com.example.learning.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApp {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
			return sessionFactory;
		} catch (Throwable ex) {
            ex.printStackTrace();
            throw ex;
        }
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		/*addEvent();*/
		displayEvents();
	}

	private static void addEvent() {
		try {
			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			
			Event event = new Event();
			event.setDate(new Date());
			event.setTitle("New Year Holiday");
			
			session.save(event);
			
			session.getTransaction().commit();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void displayEvents() {
		try {
			Session session = getSessionFactory().openSession();
			
			List<Event> events = session.createQuery("from Event").list();
			
			for (Event e : events) {
				System.out.println(e.toString());
			}
			
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

}
