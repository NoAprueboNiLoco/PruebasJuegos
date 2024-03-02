package Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    
}
