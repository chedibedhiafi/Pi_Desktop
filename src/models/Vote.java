/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Haroun
 */
public class Vote {
    private int id;
    private int type;
    private Commentaire id_source;
    private Utilisateur id_user;
    //deault constructor
    public Vote() {
    }
    //full comment constructor

    public Vote(int id, int type, Commentaire id_source, Utilisateur id_user) {
        this.id = id;
        this.type = type;
        this.id_source = id_source;
        this.id_user = id_user;
    }

    
    
    
    
    //comment constructor no id
    
       
    public Vote(int type, Commentaire id_source, Utilisateur id_user) {
        this.type = type;
        this.id_source = id_source;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public Commentaire getId_source() {
        return id_source;
    }

    public Utilisateur getId_user() {
        return id_user;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId_source(Commentaire id_source) {
        this.id_source = id_source;
    }

    public void setId_user(Utilisateur id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Vote{" + "id=" + id + ", type=" + type + ", id_source=" + id_source + ", id_user=" + id_user + '}';
    }
    
    

    
    

    
    
    
    
    
    
    
}
