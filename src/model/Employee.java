
package model;


import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Person {
  
    String Position; 
   
 
    Double Salary; 

    
}
