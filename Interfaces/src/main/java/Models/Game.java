package Models;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Games")
public class Game {
    @Id
    @Column(name = "Id_Games")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Game;
    @Column(name = "Name")
    private String name;
    @Column(name = "Exp")
    private int exp;
    @Column(name = "Credits")
    private int credits;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_User")
    private User id_to_user;
    
    @OneToMany(mappedBy = "id.game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private List<Miner> midTable;
    
    
    public Game(){}
    
    public Game(User id_to_usuario, int id, String nombre, int exp, int creditos) {
        this.id_to_user = id_to_usuario;
        this.id_Game = id;
        this.name = nombre;
        this.exp = exp;
        this.credits = creditos;
    }

    public int getId_Game() {
        return id_Game;
    }

    public void setId_Game(int id_Game) {
        this.id_Game = id_Game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public User getId_to_user() {
        return id_to_user;
    }

    public void setId_to_user(User id_to_user) {
        this.id_to_user = id_to_user;
    }

    public List<Miner> getMidTable() {
        return midTable;
    }

    public void setMidTable(List<Miner> midTable) {
        this.midTable = midTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return id_Game == game.id_Game && exp == game.exp && credits == game.credits && Objects.equals(name, game.name) && Objects.equals(id_to_user, game.id_to_user) && Objects.equals(midTable, game.midTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Game, name, exp, credits, id_to_user, midTable);
    }

    //    public int calcNivel() {
//        double lv1;
//        int lvl;
//        lv1 = this.getExp() / 100;
//        Math.round(lv1);
//        lvl = (int) lv1;
//        return lvl;
//    }

}
