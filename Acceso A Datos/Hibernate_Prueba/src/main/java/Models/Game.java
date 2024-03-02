package Models;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    public int calcNivel() {
//        double lv1;
//        int lvl;
//        lv1 = this.getExp() / 100;
//        Math.round(lv1);
//        lvl = (int) lv1;
//        return lvl;
//    }

}
