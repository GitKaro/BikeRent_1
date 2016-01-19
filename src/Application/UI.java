/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class UI {
    
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
    private static SessionFactory configureSessionFactory() throws HibernateException 
    {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
	    
        Properties properties = configuration.getProperties();
	    
	serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	    
	return sessionFactory;  
    }
    Employee me;
    Customer currentCustomer;
    Session CurrSession;
    
    UI()
    {
        configureSessionFactory();
	Transaction tx=null;
        CurrSession = sessionFactory.openSession();
        tx = CurrSession.beginTransaction();
        
    }
    
    public Boolean findEmployee(String EmployeeCode)
    {
        Set<Employee> allEmployees;	
            // Fetching saved data
            List<Employee> userList = CurrSession.createQuery("from Employee").list();
			
            for (Employee add : userList) 
            {
               if( add.GetEmployeeCode() == null ? EmployeeCode == null : add.GetEmployeeCode().equals(EmployeeCode))
               {
                   me=add;
                   return true;
               }
            }
                return false;
    }
   public boolean  EmployeeWorksInGarage()
   {
       
    return (me.GetPosition()=="Engeneer") ;
   }
}
