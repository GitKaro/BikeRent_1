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
    String TotalDiscount;
    
   @OneToMany(cascade=CascadeType.ALL)
    Set<Item> PromotionItems;
   PromotionType type;
   double discount; 
}
enum PromotionType
{
Combo,
fixedAmmount,
percentage
}