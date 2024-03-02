package DAO;

import Models.User;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;

public interface UserDAO {
    //hacer el CRUD
    //CREATE
    public abstract void addUser(User usr, EntityManager manager); //el Abstract da igual se pone por defecto si no lo aclaras
    //UPDATE
    public abstract void updateUser( User usr,EntityManager manager);
    //READ
    public abstract ArrayList<User> readUser(EntityManager manager);
    //DELETE
    public abstract void deleteUser( User usr,EntityManager manager);
} 