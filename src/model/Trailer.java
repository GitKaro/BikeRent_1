
package model;


import javax.persistence.*;

@Entity
@Table(name = "Trailer")
public class Trailer extends Accessoires {
    
  
    trailerUse type;
    Boolean rainproof;
    
}
enum trailerUse
{
    GoodsTailer,
    ChildrenTailor,
    BikeConnector
}