
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
 
}
enum Condition
{
CosmeticDefects,
SmallIssues,
BigDamage,
CompleteDamege
}