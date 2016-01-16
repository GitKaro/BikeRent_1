
package model;


import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Person {
  
    String Position; 
   
 
    Double Salary; 

    public Employee(String l_FirstName, String l_LastName, Date l_DOB, Address ad,String l_Position,Double l_Salary ) {
        super(l_FirstName, l_LastName, l_DOB, ad);
        Position=l_Position;
        Salary=l_Salary;
    }

    public String GetPosition()
    {
        return Position;
    }
    public void ReAssighn(String newjob)
    {
    Position=newjob;
    }
}
