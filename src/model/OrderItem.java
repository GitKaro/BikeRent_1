/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


@Entity
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    @OneToMany
    RentingOrder parentOrder;
    
    @OneToMany
    Set<Item> Product;
    
    public RentingOrder getParentOrder()
    {
        return parentOrder;
    }
    public Set<Item> GetProducts()
    {
     return Product;
    }
    public void AddProducts(Item newItem)
    {
        Product.add(newItem);
    }
    public void RemoveProducts(Item OldItem)
    {
        Product.remove(OldItem);
    }
    

  
}
