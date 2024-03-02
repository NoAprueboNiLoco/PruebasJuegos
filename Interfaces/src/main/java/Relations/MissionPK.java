package Relations;

import Models.Game;
import Models.Profession;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MissionPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "id_Game")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id_Profession")
    private Profession profession;

    public MissionPK() {
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
        if (!(o instanceof MissionPK missionPK)) return false;
        return Objects.equals(game, missionPK.game) && Objects.equals(profession, missionPK.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, profession);
    }
}