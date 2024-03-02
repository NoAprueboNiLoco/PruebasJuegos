package Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Profession implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Profession;
    
    @OneToMany(mappedBy = "id.profession")
    private List<Miner> miner;
    
    @OneToMany(mappedBy = "id.profession")
    private List<Mission> mission;
    
    @Column(name = "Profession")
    private String profession;

    public Profession() {
    }

    public Profession(String profession) {
        this.profession = profession;
    }

    public int getId_Profession() {
        return id_Profession;
    }

    public void setId_Profession(int id_Profession) {
        this.id_Profession = id_Profession;
    }

    public List<Miner> getMiner() {
        return miner;
    }

    public void setMiner(List<Miner> miner) {
        this.miner = miner;
    }

    public List<Mission> getMission() {
        return mission;
    }

    public void setMission(List<Mission> mission) {
        this.mission = mission;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profession that)) return false;
        return id_Profession == that.id_Profession && Objects.equals(miner, that.miner) && Objects.equals(mission, that.mission) && Objects.equals(profession, that.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Profession, miner, mission, profession);
    }
}
