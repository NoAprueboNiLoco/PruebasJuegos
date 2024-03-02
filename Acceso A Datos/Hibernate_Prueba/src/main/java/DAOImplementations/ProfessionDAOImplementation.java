package DAOImplementations;

import DAO.ProfessionDAO;
import Models.Profession;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProfessionDAOImplementation implements ProfessionDAO{

    @Override
    public void addProfession(Profession pfs, EntityManager manager) {
        EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(pfs);
            transaction.commit();
    }
    
}
