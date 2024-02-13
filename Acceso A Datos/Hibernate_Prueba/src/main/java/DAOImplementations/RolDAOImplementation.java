package DAOImplementations;

import DAO.RolDAO;
import com.mycompany.Logica_negocio.Role;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class RolDAOImplementation implements RolDAO {

    @Override
    public void addRole(Role role, EntityManager manager) {
        
        
        manager.getTransaction().begin();
        manager.persist(role);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void updateRole(Role role, EntityManager manager) {

        Role rolAux = manager.find(Role.class, role.getId());
        // te creas un rol auxiliar para guardar los datos actualizados 
        manager.getTransaction().begin();
        rolAux.setRole(role.getRole());
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public ArrayList<Role> readRole(EntityManager manager) {
       
        List<Role> roles = manager.createQuery("SELECT r FROM role r", Role.class).getResultList();
        return new ArrayList<Role>(roles);
    }

    @Override
    public void deleteRole(Role role, EntityManager manager) {
        
        Role rolAux = manager.find(Role.class, role.getId()); // funciona muy parecido al update
        
        manager.getTransaction().begin();
        manager.remove(rolAux);
        manager.getTransaction().commit();
        manager.close();
    }

}
