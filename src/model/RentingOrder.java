/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "ORDER")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RentingOrder implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    
   @Type(type="date")
    Date  BookingDate;
   
    @Type(type="date")
    Date StartRenting;
   
    @Type(type="date")
    Date EndRenting;
   
   @OneToOne(fetch = FetchType.LAZY)
    Customer Borrower;
    
   
    orderStatus Status; 
    
   @OneToMany
    Set<OrderItem> BorrowingItems;
   
   public void RentingOrder(Date StartDate, Date EndDate, Customer l_Borrower,orderStatus l_Status)
   {
      Date date    = new Date(Calendar.getInstance().getTime().getTime());
      BookingDate  = date;
      StartRenting=StartDate;
      EndRenting= EndDate;
      Borrower= l_Borrower;
      Status=l_Status;
   }
}
enum orderStatus
{
    Reserved,
    Orderd,
    Completed,
    Canceled;
    public String toString() 
    {
        return name().charAt(0) + name().substring(1);
    }
    
}