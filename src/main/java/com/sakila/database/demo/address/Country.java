package com.sakila.database.demo.address;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {
    //table id found at this particular column
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;

    @Column(name="country")
    private String country_;

    //constructor
    public Country() {
        //empty constructor for reading and creating repo
    }

    //getters and setters
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry_() {
        return country_;
    }

    public void setCountry_(String country) {
        this.country_ = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country_ + '\'' +
                '}';
    }
}
