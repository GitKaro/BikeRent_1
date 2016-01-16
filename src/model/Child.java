/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.*;

@Entity
@Table(name = "CHILD")
public class Child extends Bike {
    boolean supportWheels; 

    public Child(double l_Price, String l_Model, String l_Brand, String l_FrameNumber, java.awt.Color l_Color, int l_Gears, int l_FrameSize,boolean l_SupportWheels) {
        super(l_Price, l_Model, l_Brand, l_FrameNumber, l_Color, l_Gears, l_FrameSize);
        supportWheels=l_SupportWheels;
    }

    
    
    boolean HasSupportWheels()
    {
        return supportWheels;
    }
    
}
