/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icommande;
import interfaces.Ilivraison;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Livraison;
import utils.MaConnexion;

/**
 *
 * @author ASUS
 */

    public class ServiceLivraison implements Ilivraison{
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    Icommande sc = new ServiceCommande();

    @Override
    public boolean ajouterLivraison(Livraison l) {
       
        String request = "INSERT INTO `livraison`(`id`,`frais_livraison`, `etat_livraison`, `num_livreur`,`id_commande`) VALUES ("+l.getId()+","+l.getFrais_livraison()+",'"+l.getEtat_livraison()+"',"+l.getNum_livreur()+","+l.getC().getId()+")";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Livraison> afficherLivraison() {
      
        List<Livraison> livraison = new ArrayList<Livraison>();

        String req="SELECT * FROM livraison";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

           
            while(rs.next()){
                livraison.add(new Livraison(rs.getInt("id"),rs.getInt("frais_livraison"),rs.getInt("etat_livraison"),rs.getInt("num_livreur"),sc.retrieveCommande(rs.getInt("id_commande"))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return livraison;
    }

    @Override
    public boolean modifierLivraison(Livraison l) {
        String req = "UPDATE `livraison` SET `frais_livraison`="+l.getFrais_livraison()+",`etat_livraison`="+l.getEtat_livraison()+",`num_livreur`="+l.getNum_livreur()+" ,`id_commande`="+l.getC().getId()+" WHERE `id` ="+l.getId()+"";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
    }
      

   
    }
    public Livraison afficherLivClient(Livraison liv){
        
        String req="SELECT * FROM livraison where id="+liv.getId();
        Statement st = null;
        Livraison l=new Livraison();
        int somme=0;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

           
            while(rs.next()){
                l=new Livraison();
                l.setId(rs.getInt("id"));
                l.setFrais_livraison(rs.getInt("frais_livraison"));
                l.setEtat_livraison(rs.getInt("etat_livraison"));
                l.setNum_livreur(rs.getInt("num_livreur"));
                l.setC(sc.retrieveCommande(rs.getInt("id_commande")));
                String req1="SELECT * FROM produit_commande where id_commande="+l.getC().getId()+"";
                Statement st1 = null;
                 List<Integer> listid=new ArrayList<Integer>();
                 List<String> listnom=new ArrayList<String>();
                try{
                   
                    st1=cnx.createStatement();
                    ResultSet rs1=st1.executeQuery(req1);
                    while(rs1.next()){
                      
                        
                    listid.add(rs1.getInt(3));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                for (int i=0;i<listid.size();i++){
                String req2="SELECT * FROM produits where id="+listid.get(i)+"";
                    
                Statement st2 = null;
                try{
                    st2=cnx.createStatement();
                    ResultSet rs2=st2.executeQuery(req2);
                    while(rs2.next()){
                    String nom="Nom ="+rs2.getString("nom")+" prix ="+rs2.getInt("prix")+"dt";
                    listnom.add(nom);
                    somme+=rs2.getInt("prix");
                      
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }}
                System.out.println(listnom);
                l.setTva((19*(somme+l.getFrais_livraison()))/100);
                l.setSomme(somme+l.getFrais_livraison());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
    @Override
    public boolean supprimerLivraison(Livraison l) {
       String req = "DELETE FROM `livraison` WHERE `id` = "+l.getId()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
}
