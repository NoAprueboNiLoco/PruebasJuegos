package Interfaces;

import Models.Miner;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;


public interface MinerDAO {
    //CREATE
    public abstract void addMiner(Miner mnr, EntityManager manager); //el Abstract da igual se pone por defecto si no lo aclaras
    //UPDATE
    public abstract void updateMiner( Miner mnr,EntityManager manager);
    //READ
    public abstract ArrayList<Miner> readMiner(EntityManager manager);
    //DELETEArrayList
    public abstract void deleteMiner( Miner mnr,EntityManager manager);
}
