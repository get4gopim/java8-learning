package com.example.learning.hibernate.util;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.learning.hib.annotation.Department;
import com.example.learning.hib.annotation.Student;
import com.example.learning.hib.annotation.University;

public class HibernateUtil {
	
	private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);
	
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
			configuration.addAnnotatedClass(University.class);
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw ex;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() {
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
		} catch (Exception ex) {
			LOGGER.error(ex);
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
		} catch (Exception ex) {
			LOGGER.error(ex);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> Collection<T> list(final Class<T> object) {
		Session session = getSessionFactory().openSession();
		Collection<T> collection = null;
		LOGGER.debug("Class:" + object.getName());
		try {
			collection = session.createQuery("from " + object.getName()).list();
		} catch (Exception ex) {
			LOGGER.error(ex);
		} finally {
			session.close();
		}
		return collection;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudentByUniversityName(final String universityName) {
		Session session = getSessionFactory().openSession();
		List<Student> students = null;
		try {
			students = session.createQuery("from Student where university.name =:university" ).setParameter("university", universityName).list();
		} catch (Exception ex) {
			LOGGER.error(ex);
		} finally {
			session.close();
		}
		return students;
	}
}
