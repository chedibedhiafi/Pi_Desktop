/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author 21694
 */
public class Employe extends Utilisateur{
    
    private String role;
    private PointDeVente pdv;

    public Employe() {
    }

    public Employe(String login, String mdp) {
        super(login, mdp);
        
    }

    public Employe(String mdp, int id) {
        super(mdp, id);
    }
    
    public Employe(PointDeVente pdv, String role, String login, String mdp, Date date_naissance, String nom, String prenom, String email, int tentative, Date unlock_date) {
        super(login, mdp, date_naissance, nom, prenom, email, tentative, unlock_date);
        this.role = role;
        this.pdv = pdv;
    }

    public Employe(PointDeVente pdv, String role, int id, String login, String mdp, Date date_naissance, String nom, String prenom, String email, int tentative, Date unlock_date) {
        super(id, login, mdp, date_naissance, nom, prenom, email, tentative, unlock_date);
        this.role = role;
        this.pdv = pdv;
    }
    
    public Employe(PointDeVente pdv, String role, String login, String mdp, Date date_naissance, String nom, String prenom, String email) {
        super(login, mdp, date_naissance, nom, prenom, email);
        this.role = role;
        this.pdv = pdv;
    }
    
    public Employe(PointDeVente pdv, String role,int id, String login, String mdp, Date date_naissance, String nom, String prenom, String email) {
        super(id,login, mdp, date_naissance, nom, prenom, email);
        this.role = role;
        this.pdv = pdv;
    }
    
    
    public Employe(String pdv_nom, String role, String login, String mdp, Date date_naissance, String nom, String prenom, String email, int tentative, Date unlock_date) {
        super(login, mdp, date_naissance, nom, prenom, email, tentative, unlock_date);
        this.pdv.setName(pdv_nom);
        this.role = role;
        this.pdv = pdv;
    }
    
    public Employe(String pdv_nom, String role,int id, String login, String mdp, Date date_naissance, String nom, String prenom, String email) {
        super(id,login, mdp, date_naissance, nom, prenom, email);
        this.pdv.setName(pdv_nom);
        this.role = role;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PointDeVente getPdv() {
        return pdv;
    }

    public void setPdv(PointDeVente pdv) {
        this.pdv = pdv;
    }
    

    @Override
    public String toString() {
        return "Employe{"+ "id=" + id + ", login=" + login + ", mdp=" + mdp + ", date_naissance=" + date_naissance + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", role=" + role +", point de vente=" + pdv + '}';
    }

    
    
}
