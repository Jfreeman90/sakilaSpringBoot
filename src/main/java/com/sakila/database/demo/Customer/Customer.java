package com.sakila.database.demo.Customer;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name="customer")
public class Customer {
    //id column
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    //attributes
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="active")
    private byte active;
    @Column(name="store_id")
    private int storeId;
    @Column(name="address_id")
    private int addressId;
    //private Timestamp create_date;
    //private Timestamp last_update;

    //constructor
    public Customer(){}

    //add a customer constuctor for an online customer creation
    public Customer(String firstName, String lastName, String email){
     this.firstName=firstName;
     this.lastName=lastName;
     this.email=email;
     //set active to 1 when account is created.
     this.active=1;
     //set store id to 3 if the account has been set up/used online
     this.storeId=3;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", storeId=" + storeId +
                ", addressId=" + addressId +
                '}';
    }
}