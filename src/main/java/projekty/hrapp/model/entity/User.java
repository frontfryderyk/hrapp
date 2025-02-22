package projekty.hrapp.model.entity;

import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "rating")
    private double eloRating;
    @Column
    private String salt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    public User(Long id, String username, String password, double eloRating, String salt, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.eloRating = 0.0; //jaka wartosc?
        this.salt = "";
        this.userType = userType;
    }

    public User() {

    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setEloRating(double eloRating) {
        this.eloRating = eloRating;
    }

    public double getEloRating() {
        return eloRating;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }
}
