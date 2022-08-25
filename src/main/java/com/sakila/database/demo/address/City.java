package com.sakila.database.demo.address;
import javax.persistence.*;

@Entity
@Table(name="city")
public class City {
    //table id found at this particular column
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name="city")
    private String city_;

    //join each city to show its country
    @ManyToOne
    @JoinColumn(name="country_id", nullable=false, insertable = false, updatable = false)
    private Country country;

    //constructor
    public City() {
        //empty constructor for reading and creating repo
    }

    //getters and setters
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity_() {
        return city_;
    }

    public void setCity_(String city) {
        this.city_ = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city_ + '\'' +
                '}';
    }
}
