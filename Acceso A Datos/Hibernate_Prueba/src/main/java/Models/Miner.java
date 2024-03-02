package Models;

import Relations.MinerPK;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Miner implements Serializable{
    
    @EmbeddedId
    private MinerPK id;
    
    @Column(name = "Exp")
    private int exp;
    @Column(name = "Upgrades")
    private int upgrades;

    public Miner() {
    }

    public Miner(MinerPK id) {
        this.id = id;
    }
    
    public Miner(int exp, int upgrades) {
        this.exp = exp;
        this.upgrades = upgrades;
    }

    public MinerPK getId() {
        return id;
    }

    public void setId(MinerPK id) {
        this.id = id;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(int upgrades) {
        this.upgrades = upgrades;
    } 
}
