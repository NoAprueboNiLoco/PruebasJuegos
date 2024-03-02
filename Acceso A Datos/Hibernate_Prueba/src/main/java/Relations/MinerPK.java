package Relations;

import Models.Game;
import Models.Profession;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class MinerPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_Game")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id_Profession")
    private Profession profession;

    public MinerPK() {
    }

    public MinerPK(Game game, Profession profession) {
        this.game = game;
        this.profession = profession;
    }

    public Game getGame() {
        return game;
    }

    public Profession getProfession() {
        return profession;
    }
}