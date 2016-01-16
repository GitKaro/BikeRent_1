
package model;


import javax.persistence.*;

@Entity
@Table(name = "Helmet")
public class Helmet extends Accessoires{
    
    public Helmet(double l_Price) {
        super(l_Price);
    }
    
   
    
}
