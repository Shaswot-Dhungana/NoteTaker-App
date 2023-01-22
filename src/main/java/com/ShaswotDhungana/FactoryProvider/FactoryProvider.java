package com.ShaswotDhungana.FactoryProvider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class FactoryProvider {

	public static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		
		if(factory==null) {
			
		    // Building Session Factory..
	
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
				
		      
		      
		}

		return factory;
		
		
	}
	
	
	public void closeSessionFactory() {
		
		if(factory.isOpen()) {
			
			factory.close();
		}
		
	}
	
	
	
}
