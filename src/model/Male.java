/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.*;

@Entity
@Table(name = "MALE")
public class Male extends Bike {
    
    public Male() {}
    public Male(double l_Price, String l_Model, String l_Brand, String l_FrameNumber, java.awt.Color l_Color, int l_Gears, int l_FrameSize) {
        super(l_Price, l_Model, l_Brand, l_FrameNumber, l_Color, l_Gears, l_FrameSize);
    }
    
   
    
}
