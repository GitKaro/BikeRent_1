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

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Address(String street, String zip, String city, String country) {
        this.street = street;
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

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id, street, zip, city, country);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//
//        Address that = (Address) obj;
//
//        return Objects.equal(this.id, that.id)
//                && Objects.equal(this.street, that.street)
//                && Objects.equal(this.zip, that.zip)
//                && Objects.equal(this.city, that.city)
//                && Objects.equal(this.country, that.country);
//    }
        
}
