
package DAO;

import com.mycompany.Logica_negocio.Role;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;

public interface RolDAO {
    //hacer el CRUD
    
    //CREATE
    public abstract void addRole( Role role,EntityManager manager); //el Abstract da igual se pone por defecto si no lo aclaras 
    
    //UPDATE
    public abstract void updateRole( Role role,EntityManager manager);
    
    //READ
    public abstract ArrayList<Role> readRole(EntityManager manager);
    
    //DELETE
    public abstract void deleteRole( Role role,EntityManager manager);
    
}
