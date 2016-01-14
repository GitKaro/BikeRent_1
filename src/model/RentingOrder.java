/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "ORDER")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RentingOrder implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    
    Date  BookingDate;
   
    Date StartRenting;
   
    Date EndRenting;
   
   @OneToOne(fetch = FetchType.LAZY)//, mappedBy = "stock", cascade = CascadeType.ALL)
    Customer Borrower;
    
   
    orderStatus Status; 
     
   @OneToMany(cascade=CascadeType.ALL)
    Set<Item> BorrowingItems;
}
enum orderStatus
{
    Reserved,
    Orderd,
    Completed,
    Canceled
}