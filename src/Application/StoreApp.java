/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class StoreApp {
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
	
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        configureSessionFactory();
        
        Session session = null;
	Transaction tx=null;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
		
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
      
    }
    
}
