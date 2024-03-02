package Models;

import Relations.MissionPK;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Mission implements Serializable{
    
    @Column(name = "Difficulty")
    private String difficulty;
    @Column(name = "Credits")
    private int credits;
    @Column(name = "Game Exp")
    private int gameExp;
    @Column(name = "Miner Exp")
    private int minerExp;
    @Column(name = "Result")
    private String result;
    
    @EmbeddedId
    private MissionPK id;
}
