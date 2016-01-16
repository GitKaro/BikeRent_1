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
}
enum lockType
{
 CableLock,
 ChainLock,
 ULock
}