package org.telran.validationexample.com.entity;

import javax.persistence.*;

@Entity
//@Table(name = "profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String profile;

    public UserProfile() {
        //
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "PersonProfile{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                '}';
    }
}
