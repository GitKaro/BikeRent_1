
package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Defects")
public class Defect implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.TABLE)
 int id; 
 String Description; 
@OneToOne(fetch=FetchType.LAZY)
 Employee assighnedEngeneer;

boolean fixed;
Condition DefectState; 
 

@OneToOne(fetch=FetchType.LAZY)
 RentingOrder linkedOrder ;  
 
public boolean state()
{
    return fixed;
}
        

public void isFixed()
{
    fixed=false;
}

public Condition State()
{
    return DefectState;
}

public String StartFixing()
{
    return DefectState.toString()+Description;
}
        
public String  assignedEngeneer()
{
 return  assighnedEngeneer.GetAddress(id);
}
}

enum Condition
{
CosmeticDefects,
SmallIssues,
BigDamaged,
CompleteDameged;
@Override
public String toString() 
    {
        return name().charAt(0) + name().substring(1);
    }
}