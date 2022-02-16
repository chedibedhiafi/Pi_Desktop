/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author 21694
 */
public class Employe extends Utilisateur{
    
    private String role;

    public Employe() {
    }

    public Employe(String role, int id, String login, String mdp, String date_naissance, String nom, String prenom, String email,String pattern) {
        super(id, login, mdp, date_naissance, nom, prenom, email,pattern);
        this.role = role;
    }

    public Employe(String role, String login, String mdp, String date_naissance, String nom, String prenom, String email,String pattern) {
        super(login, mdp, date_naissance, nom, prenom, email,pattern);
        this.role = role;
    }

    @Override
    public String toString() {
        
        return  "Employe{" + "role=" + role + '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
}
