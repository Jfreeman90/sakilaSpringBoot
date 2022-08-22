package com.sakila.database.demo.actor;
import com.sakila.database.demo.film.filmInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//class to deal with the actor objects withdrawn from the actor database.
@Entity
@Table(name="actor")
public class actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;

    //Attributes
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    //join each actor to a list of films theyve been in
    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    List<filmInfo> films = new ArrayList<>();

    //generators
    public actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //constructors
    public actor() {
    }

    //getters and setters
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public List<filmInfo> getFilms() {
        return films;
    }

    public void setFilms(List<filmInfo> films) {
        this.films = films;
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

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
