/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import  java.awt.Color;
import java.lang.reflect.Field;
import java.util.Date;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "BIKE")
public class Bike extends Item {
   
   private String Model;
   private String Brand;
   private String FrameNumber;
   private Color Color; 
   private int Gears;
   private int FrameSize;
    
    @OneToMany
    Set<Defect> Defects;
    
    @OneToMany
    Set<OrderItem> Orders;

   

    public Bike(double l_Price,String l_Model,String l_Brand,String l_FrameNumber,Color l_Color, int l_Gears, int l_FrameSize) {
        super(l_Price);
        Model=l_Model;
        Brand =l_Brand;
        FrameNumber = l_FrameNumber;
        Color =l_Color;
        FrameSize= l_FrameSize;
    }
    
   public String  getModel()
   {
       return Model;
   }
   
   public String getBrand()
   {
       return Brand;
   }        
   public String  getFrameNumber()
   {
       return FrameNumber;
   }
   
   public String getColor()
   {
       return Color.toString();
   }

    public int getGears()
    {
        return Gears;
    }
    
    public void changeGears(int newGears)
    {
        Gears= newGears;
    }
     
      
    public int getFrameSize()
    {
        return FrameSize;
    }
    
    public Condition getBikeState()
    {
        Condition state = null;
        for(Defect issue : Defects)
        {
            
            if(!issue.state())
            {
                if(issue.State()==Condition.CompleteDameged)
                {
                    return Condition.CompleteDameged;
                      
                }
                 if(issue.State()==Condition.BigDamaged)
                {
                  
                    state= Condition.BigDamaged;
                      
                }
                  if(issue.State()==Condition.CosmeticDefects)
                {
                    if(state== Condition.SmallIssues|| state==null)
                    {
                        state= Condition.CosmeticDefects;
                    } 
                }
                   if(issue.State()==Condition.SmallIssues)
                {
                     if( null ==state)
                    {
                        state= Condition.SmallIssues;
                    }
                      
                }
                
            }
        }
        return state;
    }
    public boolean IsRentable(Date Start, Date End )
    {
        boolean Rentable= true;
        for(OrderItem order :Orders)
        {
            if((order.parentOrder.StartRenting.after(Start)) || (order.parentOrder.EndRenting.before(End)))
            {
              Rentable=false;  
            } 
           
        }
        return Rentable;
    }
}

