
package model;

import java.sql.Date;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "PERSON")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
    private Long    ID ;
   
   @OneToMany(cascade=CascadeType.ALL)
    private Set<Address> Addresslist;
   
    private String  FirstName;
   
    private String  LastName;
   
    private Date    DOB;
    
    private String  Password;
   
    public Person(String l_FirstName, String l_LastName, Date l_DOB,
                  String l_Password, Address ad)
    {
       FirstName=l_FirstName;
       LastName=l_LastName;
       DOB=l_DOB;
       Password=l_Password;
       Addresslist.add(ad);
    }
    
    
   public String GetName()
   {
    return FirstName+" "+LastName;
   }
   public String GetAddress( int importance)
   {
     Address[] t =  (Address [])Addresslist.toArray();
       return (t[importance]).GetAddress();
   }
    public Set<Address> GetAddress( )
   {
       return Addresslist;
   }
   
   public void SetAddress(Address newAddress)
   {
       Addresslist.add(newAddress);
   }
   public Date GetDOB()
   {
        return DOB;
   }
 
   
}
