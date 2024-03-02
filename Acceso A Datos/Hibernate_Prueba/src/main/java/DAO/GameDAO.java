package DAO;

import Models.Game;
import Models.User;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;

public interface GameDAO {
    //CREATE
    public abstract void addGame(Game game, EntityManager manager); //el Abstract da igual se pone por defecto si no lo aclaras

    //UPDATE
    public abstract void updateGame(Game game,EntityManager manager);

    //READ
    public abstract ArrayList<Game> readGame(EntityManager manager);

    //DELETE
    public abstract void deleteGame(Game game,EntityManager manager);
}
