/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Karolina
 */
public enum trailerUse {
    GoodsTailer,
    ChildrenTailor,
    BikeConnector;
    public String toString() 
    {
        return name().charAt(0) + name().substring(1);
    }
}
