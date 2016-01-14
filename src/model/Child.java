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
    
}
