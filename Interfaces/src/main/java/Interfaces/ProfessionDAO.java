package Interfaces;

import Models.Profession;
import jakarta.persistence.EntityManager;

public interface ProfessionDAO {
    public abstract void addProfession(Profession pfs, EntityManager manager); //el Abstract da igual se pone por defecto si no lo aclaras
}
