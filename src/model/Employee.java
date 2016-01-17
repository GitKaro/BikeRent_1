
package model;


import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Person {
  
    jobs Position; 
    String EmployeeCode;
 
    Double Salary; 

    public Employee(String l_FirstName, String l_LastName, Date l_DOB, Address ad,String l_Position,Double l_Salary ) {
        super(l_FirstName, l_LastName, l_DOB, ad);
        if(l_Position== "Sales")
        {
            Position=jobs.Sales;
        }
        if(l_Position=="Sales")
        {
        Position = jobs.Engeneer;
        }
        Salary=l_Salary;
    }
    
    public String GetPosition()
    {
        return Position.toString();
    }
    public void ReAssighn(jobs newjob)
    {
        Position=newjob;
    }
    public String GetEmployeeCode()
    {
        return EmployeeCode;
    }
    public void SetEmployeeCode(String Code)
    {
        EmployeeCode=Code;
    }
    
    
    enum jobs
    {
        Sales,
        Engeneer;
       
        public String toString() 
        {
            return name().charAt(0) + name().substring(1);
        }
    }
}
