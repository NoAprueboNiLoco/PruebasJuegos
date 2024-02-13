package com.mycompany.hibernate_prueba;

import DAOImplementations.RolDAOImplementation;
import com.mycompany.Logica_negocio.Role;

public class Hibernate_Prueba {

    public static void main(String[] args) {
      
        //new Hibernate_config(); <- esta linea genera la BD
        
        Hibernate_config hc = new Hibernate_config();
        RolDAOImplementation ir = new RolDAOImplementation();
        Role r1 = new Role("Ventas");
        Role r2 = new Role("Compras");
        ir.addRole(r1, hc.getManager());
        ir.addRole(r2, hc.getManager());
        
        hc.closeConection();
    }
}
