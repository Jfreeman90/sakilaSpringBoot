package com.sakila.database.demo.address;
import javax.persistence.*;

@Entity
@Table(name="city")
public class city {
    //table id found at this particular column
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name="city")
    private String city;

    //join each city to show its country
    @ManyToOne
    @JoinColumn(name="country_id", nullable=false, insertable = false, updatable = false)
    private com.sakila.database.demo.address.country country;

    //constructor
    public city() {
    }

    //getters and setters
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public com.sakila.database.demo.address.country getCountry() {
        return country;
    }

    public void setCountry(com.sakila.database.demo.address.country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                '}';
    }
}
