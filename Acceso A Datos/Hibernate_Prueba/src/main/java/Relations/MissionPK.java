package Relations;

import Models.Game;
import Models.Profession;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class MissionPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "id_Game")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id_Profession")
    private Profession profession;
}