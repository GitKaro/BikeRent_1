/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerent;

import java.awt.Color;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import model.Accessoires;
import model.Address;
import model.Bike;
import model.Chainlock;
import model.Child;
import model.Customer;
import model.Female;
import model.Helmet;
import model.Item;
import model.Male;
import model.Person;
import model.Trailer;
import static model.lockType.*;
import model.trailerUse;
import static model.trailerUse.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 *
 * @author Karolina
 */
public class Test1 {
    
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
    
    @org.junit.Test
    public void test() {
        configureSessionFactory();
        
        Session session = null;
        Transaction tx=null;
        
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        addCustomer(session);
        addBikes(session);
        addAccessiores(session);
        // Committing the change in the database.
        session.flush();
        tx.commit();
        System.out.println(" ############################### ");
        System.out.println(countBikes(session));
        assertEquals("Count of bikes must be 4: ", 4, countBikes(session));
        assertEquals("Count of person must be 3: ", 3, countPerson(session));
        assertEquals("Count of accessoires must be 8: ", 8, countAccessoires(session));
        assertEquals("Count of item must be 12: ", 12, countItem(session));
    }
   
    
   private static Date generateDate(String date) {
       SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
       java.util.Date parsed = null;
       try {
           parsed = format.parse(date);
       } catch (ParseException ex) {
           Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
       }
       Date sqldt = new java.sql.Date(parsed.getTime());
       return sqldt;
   }
   
   private static void addCustomer(Session session) {
       
       // CUSTOMER 1 #########################
       
       Date d1 = generateDate("01.11.1990");
       
       Address a1 = new Address(
               "Teststreet",
               "12",
               "22456",
               "Hamburg",
               "Germany"
       );
       
       Customer c1 = new Customer(
               "Karo",
               "Wochnik",
               d1, // 01.11.1990
               "k.wochnik@bla.de",
               "12345",
               a1
       );
       
       // CUSTOMER 2 #########################
       
       Date d2 = generateDate("05.02.1990");
       
       Address a2 = new Address(
               "Blastreet",
               "4",
               "22489",
               "Hamburg",
               "Germany"
       );
       
       Customer c2 = new Customer(
               "Torben",
               "Zurhelle",
               d2, // 05.02.1990
               "t.zurhelle@test.de",
               "12345",
               a2
       );
       
       // CUSTOMER 3 #########################
       
       Date d3 = generateDate("17.05.1984");
       
       Address a3 = new Address(
               "Britstreet",
               "67",
               "55678",
               "Berlin",
               "Germany"
       );
       
       Customer c3 = new Customer(
               "Britney",
               "Spears",
               d3, // 17.05.1984
               "britney@spears.de",
               "12346",
               a3
       );
       
       session.save(c1);
       session.save(c2);
       session.save(c3);
   }
   
   private static void addBikes(Session session) {
 
       // FEMALE BIKE 1 ################
       Female f1 = new Female(
               10.0,
               "City",
               "Orton",
               "4570a45",
               Color.GREEN,
               7,
               52
       );
       
       // FEMALE BIKE 2 ################
       Female f2 = new Female(
               12.0,
               "City",
               "Vermont",
               "479bc45",
               Color.RED,
               7,
               54
       );
       
       // MALE BIKE 1 ##################
       Male m1 = new Male(
               15.0,
               "Mountainbike",
               "Merida",
               "82574a22",
               Color.BLUE,
               14,
               26
       );
       
       // CHILD BIKE 1 #################
       Child c1 = new Child(
               8.0,
               "Race",
               "Vermont",
               "20578if1",
               Color.GRAY,
               3,
               18,
               true
       );
       
       session.save(f1);
       session.save(f2);
       session.save(m1);
       session.save(c1);
   }
   
   
    private static void addAccessiores(Session session) {
 
       // HELMET 1 ################
       Helmet h1 = new Helmet(
               5.0
       );
       
       // HELMET 2 ################
       Helmet h2 = new Helmet(
               7.0
       );
       
       // HELMET 3 ################
       Helmet h3 = new Helmet(
               4.0
       );
       
       // LOCK 1 ################
       Chainlock c1 = new Chainlock(
               5.0,
               2,
               CableLock
       );
       
       // LOCK 2 ################
       Chainlock c2 = new Chainlock(
               6.0,
               3,
               ChainLock
       );
       
       // LOCK 3 ################
       Chainlock c3 = new Chainlock(
               8.0,
               7,
               ULock
       );
       
       // TRAILER 1 ################
       Trailer t1 = new Trailer(
               15.0,
               ChildrenTailor,
               false
       );
       
       // TRAILER 2 ################
       Trailer t2 = new Trailer(
               20.0,
               GoodsTailer,
               true
       );
       
       session.save(h1);
       session.save(h2);
       session.save(h3);
       session.save(c1);
       session.save(c2);
       session.save(c3);
       session.save(t1);
       session.save(t2);
   }
   
   
   private static int countBikes(Session session) {
       List<Bike> bList = session.createQuery("from Bike").list();
       return bList.size();
   }
   
   private static int countPerson(Session session) {
       List<Person> pList = session.createQuery("from Person").list();
       return pList.size();
   }
   
   private static int countAccessoires(Session session) {
       List<Accessoires> aList = session.createQuery("from Accessoires").list();
       return aList.size();
   }
   
   private static int countItem(Session session) {
       List<Item> iList = session.createQuery("from Item").list();
       return iList.size();
   }
   
}
