package DAOImplementations;

import DAO.GameDAO;
import Models.Game;
import Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class GameDAOImplementation implements GameDAO{

    @Override
    public void addGame(Game game, EntityManager manager) {
        EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(game);
            transaction.commit();
    }

    @Override
    public void updateGame(Game game, EntityManager manager) {
//        User userAux = manager.find(User.class, user.getId());
//        manager.getTransaction().begin();
//        userAux.setContrasena(game.getContrasena());
//        userAux.setCorreo(game.getCorreo());
//        userAux.setId(game.getId());
//        manager.getTransaction().commit();
//        manager.close();
    }

    @Override
    public ArrayList<Game> readGame(EntityManager manager) {
        List<Game> games = manager.createQuery("SELECT g FROM game g", Game.class).getResultList();
        return new ArrayList<Game>(games);
    }

    @Override
    public void deleteGame(Game game, EntityManager manager) {
    }
    
}
