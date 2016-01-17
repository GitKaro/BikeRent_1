/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerent;

import Application.NewCustomer;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Address;
import model.Customer;
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
public class AddCustomer {
    
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
           // Configure the session factory
	configureSessionFactory();
        
        NewCustomer custframe = new NewCustomer();
        custframe.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                if (custframe.getOK()) {
                    
                    System.out.println("Firstname: " + custframe.getFirstname());
                    System.out.println("Lastname: "  + custframe.getLastname());
                    System.out.println("Dob: " + custframe.getDob());
                    System.out.println("Mail: " + custframe.getMail());
                    System.out.println("Password: " + custframe.getPW());
                    
                    Address addr = new Address(
                            custframe.getStreet(),
                            custframe.getHousenr(),
                            custframe.getZip(),
                            custframe.getCity(),
                            custframe.getCountry()
                    );
                    this.saveCustomer_(
                            custframe.getFirstname(),
                            custframe.getLastname(),
                            custframe.getDob(),
                            custframe.getMail(),
                            custframe.getPW(),
                            addr
                    );
                }
                
            }
            public Boolean saveCustomer_(String fname,
                                String lname,
                                String DOB,
                                String Mail,
                                String PW,
                                Address addr) {
        
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                java.util.Date date = null;
                try {
                    date = format.parse(DOB);
                } catch (ParseException ex) {
                    Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                Customer cust;
                cust = new Customer(fname, lname, sqlDate, Mail, PW, addr);

                Session session = null;
                Transaction tx=null;

                try {
                    session = sessionFactory.openSession();
                    tx = session.beginTransaction();
                    // Saving to the database
                    session.save(cust);	
                    // Committing the change in the database.
                    session.flush();
                    tx.commit();

                    // Fetching saved data
                    List<Customer> custList = session.createQuery("from Customer").list();

                    System.out.println("customer:");
                    for (Customer c : custList) {
                        System.out.println("Name: " + c.getName());
                    }
                    System.out.println("addresses:");
                    // Fetching saved data
                    List<Address> addrList = session.createQuery("from Address").list();

                    for (Address a : addrList) {
                        System.out.println("Name: " + a.getStreet());
                    }

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
                return true;
            }
        });
    }
    
}
