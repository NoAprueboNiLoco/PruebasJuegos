package com.mycompany.Logica_negocio;

import jakarta.persistence.*;

@Entity(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // secuencia es una cuestion de ordenado de ids
    private int id_user;
    
    @Basic
    private String firstname;
    
    @Column(name = "Apellido")
    private String lastname;
    
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    private String password;
    
    @ManyToOne //le avisas que es una FK(ForeingKey)
    @JoinColumn(name = "Role_id") //a que PK referencia la FK que es el Role
    private Role rol;

    public User(int id_user, String firstname, String lastname, String username, String password, Role rol) {
        this.id_user = id_user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id_user;
    }

    public void setId(int id) {
        this.id_user = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id_user + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", rol=" + rol + '}';
    }
    
    
}
