package org.telran.validationexample.com.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Account> accounts = new ArrayList<>();

    @NotBlank(message = "Field name is mandatory")
    private String cd ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    public User(){
        //
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public UserProfile getPersonProfile() {
        return userProfile;
    }

    public void setPersonProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", accounts=" + accounts +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", personProfile=" + userProfile +
                '}';
    }
}
