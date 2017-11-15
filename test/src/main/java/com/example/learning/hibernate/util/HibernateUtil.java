package com.example.learning.hibernate.util;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.learning.hib.annotation.Department;
import com.example.learning.hib.annotation.Student;

public class HibernateUtil {
	
	private final String filePath;
	
	private static SessionFactory sessionFactory;
	
	private ServiceRegistry serviceRegistry;
	
	public HibernateUtil(String filePath) {
		this.filePath = filePath;
		buildSessionFactory();
	}

	private SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure(this.filePath);
			configuration.addAnnotatedClass(Department.class);
			configuration.addAnnotatedClass(Student.class);
			
			//sessionFactory = configuration.configure(this.filePath).buildSessionFactory();
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() throws Exception{
	    if(serviceRegistry!= null) {
	        StandardServiceRegistryBuilder.destroy(serviceRegistry);
	    }
	}
	
	public Object save(Object object) {
		Session session = getSessionFactory().openSession();
		Object obj = null;
		try {
			Transaction tx = session.beginTransaction();
			obj = session.save(object);
			tx.commit();
		} catch (Throwable ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return obj;
	}
	
	public void update(Object object) {
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(object);
			tx.commit();
		} catch (Throwable ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> Collection<T> list(final Class<T> object) {
		Session session = getSessionFactory().openSession();
		Collection<T> collection = null;
		System.out.println("Class:" + object.getName());
		try {
			collection = session.createQuery("from " + object.getName()).list();
		} catch (Throwable ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return collection;
	}
}
