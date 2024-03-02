package Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
public class User {
    
    @Id
    @Column(name = "Id_User")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(name = "Mail")
    private String mail;
    @Column(name = "Password")
    private String pass;
    
    @OneToMany(mappedBy = "id_to_user", cascade = CascadeType.ALL)
    private List<Game> games = new ArrayList<>();

    public User() {
    }

    public User(int id_user, String mail, String pass) {
        this.id_user = id_user;
        this.mail = mail;
        this.pass = pass;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}