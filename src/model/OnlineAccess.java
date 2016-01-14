
package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "OnlineAccess")
public class OnlineAccess implements Serializable {
    
       
    String Username;
    char[] Password;
    
    @OneToOne
    @Id
     Customer AssignedUser;  
}
