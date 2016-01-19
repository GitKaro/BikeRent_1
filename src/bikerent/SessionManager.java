/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerent;

import java.util.Properties;
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
public class SessionManager {
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;
    
    private static Session session = null;
  //  private static Transaction tx  = null;
    
    private static void configureSessionFactory() throws HibernateException {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
	    
        Properties properties = configuration.getProperties();
	    
	serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
	sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
   }
    
    public SessionManager() {
        // Configure the session factory
	configureSessionFactory();
        session = sessionFactory.openSession();
        //tx      = session.beginTransaction();
    }
    
    public static Session getSession() {
        return session;
    }
//    
//    public static Transaction getTransaction() {
//        return tx;
//    }
    
    public void closeSession() {
        session.close();
    }
}
