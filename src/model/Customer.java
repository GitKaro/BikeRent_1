
package model;


import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person {
    
    private String Mail = null;
    
    public Customer() {}
    public Customer(String l_FirstName, String l_LastName, Date l_DOB,
                    String Mail, String Password, Address ad) {
        super(l_FirstName, l_LastName, l_DOB, Password, ad);
        this.Mail = Mail;
    }
    
}
