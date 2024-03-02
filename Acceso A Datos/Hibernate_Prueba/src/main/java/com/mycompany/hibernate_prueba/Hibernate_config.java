package com.mycompany.hibernate_prueba;

import jakarta.persistence.*;

public class Hibernate_config {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public Hibernate_config() {
        this.setFactory(Persistence.createEntityManagerFactory("HIbernateTestPU"));
    }
    
    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getManager() {
        return manager = new Hibernate_config().getFactory().createEntityManager();
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public void closeConection() {
        manager.close();
        factory.close();
    }
}
