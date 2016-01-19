
package model;


import javax.persistence.*;

@Entity
@Table(name = "Trailer")
public class Trailer extends Accessoires {
    
  
    trailerUse type;
    Boolean rainproof;

    public Trailer(double l_Price, trailerUse l_type, Boolean l_rainproof) {
        super(l_Price);
        type= l_type;
        rainproof=l_rainproof;
        
    }
    
    public boolean isRainProof()
    {
        return rainproof;
    } 
    
    public String GetTrailerUse()
    {
        return type.toString();
    }
    
}
