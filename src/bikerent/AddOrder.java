/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerent;

import Application.Order;
import java.util.List;
import java.util.Properties;
import model.Bike;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Karolina
 */
public class AddOrder {
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
    private static SessionFactory configureSessionFactory() throws HibernateException {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
	    
        Properties properties = configuration.getProperties();
	    
	serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	    
	return sessionFactory;  
   }
    
    public static void main(String[] args) {
        String[] bike = new String[]{};
        String[] helmet = new String[]{};
        String[] trailer = new String[]{};
        String[] chainlock = new String[]{};
        String temp = "";
        int cnt = 0;
        
        // Configure the session factory
	configureSessionFactory();
        
        Session session = null;
	Transaction tx  = null;
        
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
			
            // Fetching saved data
            List<Bike> bikeList = session.createQuery("from Bike").list();
			
            for (Bike b : bikeList) {
                temp = "";
                temp = b.getModel() + "\t" + b.getBrand();
                bike[cnt] = temp;
            }
            
            System.out.println(" --------------------- " + bikeList.size());
			
	} catch (Exception ex) {
            ex.printStackTrace();
			
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
	} finally{
            if(session != null) {
                session.close();
            }
        }

        
        Order frame = new Order(bike, helmet, trailer, chainlock);
    }
}
