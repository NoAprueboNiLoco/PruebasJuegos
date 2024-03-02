package Relations;

import Models.Game;
import Models.Profession;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public void setGame(Game game) {
        this.game = game;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MinerPK minerPK)) return false;
        return Objects.equals(game, minerPK.game) && Objects.equals(profession, minerPK.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, profession);
    }
}