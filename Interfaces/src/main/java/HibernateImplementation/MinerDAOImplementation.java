package HibernateImplementation;

import Models.Miner;
import Interfaces.MinerDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.ArrayList;

public class MinerDAOImplementation implements MinerDAO{

    @Override
    public void addMiner(Miner mnr, EntityManager manager) {
        EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(mnr);
            transaction.commit();
    }

    @Override
    public void updateMiner(Miner mnr, EntityManager manager) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Miner> readMiner(EntityManager manager) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteMiner(Miner mnr, EntityManager manager) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
