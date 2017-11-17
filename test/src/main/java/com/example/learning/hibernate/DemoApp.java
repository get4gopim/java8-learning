package com.example.learning.hibernate;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoApp {
	
	private static final Logger LOGGER = Logger.getLogger(DemoApp.class);
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception ex) {
            LOGGER.error(ex);
        }
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		addEvent();
		displayEvents();
	}

	private static void addEvent() {
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			
			Event event = new Event();
			event.setDate(new Date());
			event.setTitle("New Year Holiday");
			
			session.save(event);
			
			tx.commit();
		} catch (Exception ex) {
			LOGGER.error(ex);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void displayEvents() {
		try (Session session = getSessionFactory().openSession()) {
			
			List<Event> events = session.createQuery("from Event").list();
			
			for (Event e : events) {
				LOGGER.debug(e.toString());
			}
			
		} catch (Exception ex) {
			LOGGER.error(ex);
		}
	}

}
