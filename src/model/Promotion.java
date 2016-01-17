/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "PROMOTION")
public class Promotion extends Item {
  
    Date PromotionStart;
    String Promocode;
    Date PromotionEnd;
    String Name;
    double TotalDiscount;
    
   @OneToMany(cascade=CascadeType.ALL)
    Set<Item> PromotionItems;
   PromotionType type;
   double discount; 

    public Promotion(double l_Price) {
        super(l_Price);
    }
}
enum PromotionType
{
Combo,
fixedAmmount,
percentage;
public String toString() 
    {
        return name().charAt(0) + name().substring(1);
    }
}