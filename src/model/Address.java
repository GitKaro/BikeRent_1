/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//import com.google.common.base.Objects;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
   private  Long  id;
   
    private String street;
   
    private String zip;
   
    private String city;
   
    private String country;

   private String housenumber;

    public Address() {
       
    }

    public Address(String street, String zip, String city, String country) {
        this.street = street;
        this.housenumber = housenumber;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  public String gethousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }
  
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

   
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

  
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String GetAddress()
    {
        return this.street +" "+this.housenumber+",\n "+ this.zip +" "+this.city+"\n"+ this.country ;
    }


        
}
