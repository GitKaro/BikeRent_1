
package model;


import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person {
    
    public Customer(String l_FirstName, String l_LastName, Date l_DOB, Address ad) {
        super(l_FirstName, l_LastName, l_DOB, ad);
    }
    
}
