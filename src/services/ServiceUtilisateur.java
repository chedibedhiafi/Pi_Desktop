/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iutilisateur;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Utilisateur;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServiceUtilisateur implements Iutilisateur {

    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        String request = "INSERT INTO `utilisateur`(`login`,`mdp`,`date_naissance`,`nom`, `prenom`, `email`, `tentative`, `unlock_date`) VALUES ('" + u.getLogin() + "','" + u.getMdp() + "','" + u.getDate_naissance() + "','" + u.getNom() + "','" + u.getPrenom() + "','" + u.getEmail() + "','" + u.getTentative() + "','" + u.getUnlock_date() + "')";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next())
                    u.setId(rs.getInt(1));    
                }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return u;
        }
        return u;
    }

    @Override
    public List<Utilisateur> afficherUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        String req = "SELECT * FROM utilisateur";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while (rs.next()) {
                utilisateurs.add(new Utilisateur(rs.getInt("id"), rs.getString("login"), rs.getString("mdp"), rs.getDate("date_naissance"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("tentative"),rs.getDate("unlock_date")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    @Override
    public Utilisateur modifierUtilisateur(Utilisateur u) {
        String req = "UPDATE `utilisateur` SET `login`='" + u.getLogin() + "',`mdp`='" + u.getMdp() + "',`date_naissance`='" + u.getDate_naissance() + "',`nom`='" + u.getNom() + "',`prenom`='" + u.getPrenom() + "',`email`='" + u.getEmail() + "' WHERE `id` = " + u.getId() + " ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                u.setEtat("succes");
                return u;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            u.setEtat("echec");
            return u;
        }
        u.setEtat("echec");
        return u;
        
    }

    @Override
    public boolean supprimerUtilisateur(Utilisateur u) {
        String req = "DELETE FROM `utilisateur` WHERE `id` = " + u.getId() + " ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Utilisateur login(Utilisateur u){
        String req = "SELECT * FROM utilisateur WHERE `login` = '"+ u.getLogin() +"'";
        try {
            Statement st = cnx.createStatement();
            Date sys = new Date(System.currentTimeMillis());
            Date newDate = new Date(System.currentTimeMillis()+86400000);
            
                ResultSet rs = st.executeQuery(req);
                
                if(!rs.next()){
                    u.setMsg("Veuillez vérifier vos paramètres");
                    return u;
                }
                else if (rs.getDate("unlock_date").compareTo(sys) >= 0){
                    u.setMsg("Votre compte a été bloqué et ne se réactivera pas avant le "+rs.getDate("unlock_date"));
                    return u;
                }
                else if(!rs.getString("mdp").equals(u.getMdp())){
                    if(rs.getInt("tentative")==2){        
                        st.executeUpdate("UPDATE `utilisateur` SET `unlock_date`='"+newDate+"'  , `tentative`= 0 WHERE id = "+rs.getInt("id")+"");
                    }
                    else 
                        st.executeUpdate("UPDATE `utilisateur` SET `tentative`= `tentative`+1 WHERE id = "+rs.getInt("id")+"");
                    u.setMsg("Mot de passe incorrect, veuillez réessayer");
                    return u;
                }
                else{
                    Utilisateur u1 = new Utilisateur(rs.getInt("id"), rs.getString("login"), rs.getString("mdp"), rs.getDate("date_naissance"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("tentative"),rs.getDate("unlock_date"));
                    st.executeUpdate("UPDATE `utilisateur` SET `tentative`= 0");
                    u1.setMsg("Bienvenue " + u1.getNom()+ " " + u1.getPrenom());
                    return u1;
                }
               

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public Utilisateur retrieveUtilisateur(int id) {
        Utilisateur u = null;

        String req = "SELECT * FROM utilisateur WHERE id = "+id+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if
                    (rs.next()) {
                u = new Utilisateur(rs.getInt("id"), rs.getString("login"), rs.getString("mdp"), rs.getDate("date_naissance"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("tentative"),rs.getDate("unlock_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public boolean modifierMdpParMail(Utilisateur u) {
        String req = "UPDATE utilisateur SET `mdp`='" + u.getMdp() + "' WHERE email='" + u.getEmail() + "'";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierMdp(Utilisateur u) {
        String req = "UPDATE utilisateur SET `mdp`='" + u.getMdp() + "' WHERE id=" + u.getId() + "";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean banUser(LocalDate unlock_date,int id) {
        String req = "UPDATE utilisateur SET `unlock_date`='" + Date.valueOf(unlock_date) + "' WHERE id=" + id + "";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
            System.out.println("aaaa");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
