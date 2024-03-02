package com.mycompany.hibernate_prueba;

import DAOImplementations.GameDAOImplementation;
import DAOImplementations.MinerDAOImplementation;
import DAOImplementations.ProfessionDAOImplementation;
import DAOImplementations.UserDAOImplementation;
import Models.Game;
import Models.Miner;
import Models.Profession;
import Models.User;
import Relations.MinerPK;

public class Hibernate_Prueba {

    public static void main(String[] args) {
        Hibernate_config hc = new Hibernate_config();
        UserDAOImplementation userDao = new UserDAOImplementation();
        GameDAOImplementation gameDao = new GameDAOImplementation();
        MinerDAOImplementation minerDAO = new MinerDAOImplementation();
        ProfessionDAOImplementation professionDAO = new ProfessionDAOImplementation();
//        ArrayList<User> array = ir.readUser(hc.getManager());
//        for (User user : array) {
//            System.out.println(user);
//        }

//        Usuarios  
        User r1 = new User(0, "123", "222");
        userDao.addUser(r1, hc.getManager());
        
        //Juego
        Game g1 = new Game(r1,0,"Game 1",1,1);
        Game g2 = new Game(r1,0,"Game 2",1,1);
        Game g3 = new Game(r1,0,"Game 3",1,1);
        gameDao.addGame(g1, hc.getManager());
        gameDao.addGame(g2, hc.getManager());
        gameDao.addGame(g3, hc.getManager());
        
        //Profesiones
        Profession p1 = new Profession("Taladrador");
        Profession p2 = new Profession("Ingeniero");
        Profession p3 = new Profession("Explorador");
        Profession p4 = new Profession("Asalto");
        professionDAO.addProfession(p1, hc.getManager());
        professionDAO.addProfession(p2, hc.getManager());
        professionDAO.addProfession(p3, hc.getManager());
        professionDAO.addProfession(p4, hc.getManager());
        
        //Mineros
        Miner m1 = new Miner(new MinerPK(g1, p1));
        Miner m2 = new Miner(new MinerPK(g1, p2));
        Miner m3 = new Miner(new MinerPK(g1, p3));
        Miner m4 = new Miner(new MinerPK(g1, p4));
        minerDAO.addMiner(m1, hc.getManager());
        minerDAO.addMiner(m2, hc.getManager());
        minerDAO.addMiner(m3, hc.getManager());
        minerDAO.addMiner(m4, hc.getManager());
    }  
}
