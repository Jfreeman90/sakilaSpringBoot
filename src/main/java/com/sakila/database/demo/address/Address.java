package com.sakila.database.demo.address;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    //table id found at this particular column
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name="address")
    private String address;

    //join each address to show its city and therefore its country
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false, insertable = false, updatable = false)
    private City city;

    @Column(name="district")
    private String district;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;

    //constructor
    public Address() {
        //empty constructor for reading and creating repo
    }

    //getters and setters
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
