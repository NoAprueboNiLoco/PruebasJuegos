package com.mycompany.Logica_negocio;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;
    private String role;

    public int getId() {
        return id_rol;
    }

    public void setId(int id) {
        this.id_rol = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id_rol + ", role=" + role + '}';
    }

    public Role(int id, String role) {
        this.id_rol = id;
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

}
