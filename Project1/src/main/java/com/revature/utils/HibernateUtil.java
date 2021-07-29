package com.revature.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {

	//we use SessionFactory interface to get a Session
	//we point it to hibernate.cfg.xml file where our database credentials etc. are stored
	
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//Get Session object from our SessionFactory
	
	//we only want one session in this application, hence private static - it is singleton
	
	private static Session sec;
	
	//This method actually gets us a session object using the SessionFactory interface
	//we will be calling it in the dao layer often.
	
	public static Session getSession() {
		if(sec == null) {  //if there isn't a session
			
			sec = sf.openSession(); //get one
			
		}
		
		return sec;
	}
	
	//finally we need a method that closes the Session objects
	//once we are done with our Session, we want to close it to prevent memory leaks
	
	public static void closeSession() {
		sec.close();
		sec = null;
	}
	
}
