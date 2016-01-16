
package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "OnlineAccess")
public class OnlineAccess implements Serializable {
    
       
    private String Username;
    private char[] Password;
    
    @OneToOne
    @Id
     Customer AssignedUser; 
    
    public Customer checkLogin(char[] enterdPassword )
    {
        if(enterdPassword == Password)
        {
            return AssignedUser;
        }
        else 
            return null;
    }
    public boolean ChangePassword(char[] oldPassword, char[] newPassword)
    {
        if(Password==oldPassword)
        {
            Password =newPassword;
            return true;
        }
        return false;
    }
    public String getUsername()
    {
        return Username;
    }
}
