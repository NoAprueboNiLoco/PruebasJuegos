package Models;

import Relations.MinerPK;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Miner miner)) return false;
        return exp == miner.exp && upgrades == miner.upgrades && Objects.equals(id, miner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exp, upgrades);
    }
}
