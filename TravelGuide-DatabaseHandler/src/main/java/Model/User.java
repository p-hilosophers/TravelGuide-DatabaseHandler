package Model;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="users")
public class User  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="UserId")
    private UUID userid;

    private String name;

    private String surname;

    private String email;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){}
    public User(UUID userid, String name, String surname, String email,String password) {
        this.userid = userid;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
