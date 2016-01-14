
package model;

import java.util.Date;
import java.io.Serializable;
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
    private Set <Address>Address;
   
    private String  FirstName;
   
    private String  LastName;
   
    private Date    DOB;
    
    
    
}
