/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.*;


@Entity
@Table(name = "CHAILOCK")
public class Chainlock extends Accessoires {
    int SecuretyLevel;
    lockType lockCategory;

    public Chainlock(double l_Price, int Sl, lockType l_LockChategory ) {
        super(l_Price );
        SecuretyLevel=Sl;
        lockCategory= l_LockChategory;
    }
    
    public int GetSecuretyLevel()
    {
     return SecuretyLevel;
    }
    public String GetLockLevel()
    {
     return lockCategory.toString();
    }
    
}
enum lockType
{
 CableLock,
 ChainLock,
 ULock;
 public String toString() 
    {
        return name().charAt(0) + name().substring(1);
    }
}