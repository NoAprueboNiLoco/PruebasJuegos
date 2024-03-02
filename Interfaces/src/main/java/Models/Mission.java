package Models;

import Relations.MissionPK;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getGameExp() {
        return gameExp;
    }

    public void setGameExp(int gameExp) {
        this.gameExp = gameExp;
    }

    public int getMinerExp() {
        return minerExp;
    }

    public void setMinerExp(int minerExp) {
        this.minerExp = minerExp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public MissionPK getId() {
        return id;
    }

    public void setId(MissionPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mission mission)) return false;
        return credits == mission.credits && gameExp == mission.gameExp && minerExp == mission.minerExp && Objects.equals(difficulty, mission.difficulty) && Objects.equals(result, mission.result) && Objects.equals(id, mission.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(difficulty, credits, gameExp, minerExp, result, id);
    }
}
