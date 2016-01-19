/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

@Entity
@Table(name = "ACCESSOIRES")
public class Accessoires extends Item {

    

    public Accessoires(double l_Price) {
        super(l_Price);
    }


   
    
}
