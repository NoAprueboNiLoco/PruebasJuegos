package DAOImplementations;

import Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import DAO.UserDAO;

public class UserDAOImplementation implements UserDAO {

    @Override
    public void addUser(User user, EntityManager manager) {
        EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(user);
            transaction.commit();
    }

    @Override
    public void updateUser(User user, EntityManager manager) {
        User userAux = manager.find(User.class, user.getId_user());
        // te creas un rol auxiliar para guardar los datos actualizados 
        manager.getTransaction().begin();
        userAux.setPass(user.getPass());
        userAux.setMail(user.getMail());
        userAux.setId_user(user.getId_user());
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public ArrayList<User> readUser(EntityManager manager) {
        List<User> users = manager.createQuery("SELECT u FROM user u", User.class).getResultList();
        return new ArrayList<User>(users);
    }

    @Override
    public void deleteUser(User user, EntityManager manager) {

        User userAux = manager.find(User.class, user.getId_user()); // funciona muy parecido al update

        manager.getTransaction().begin();
        manager.remove(userAux);
        manager.getTransaction().commit();
        manager.close();
    }

}
