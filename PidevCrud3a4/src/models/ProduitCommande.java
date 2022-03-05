/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS
 */
public class ProduitCommande {
    private int id;
    private int id_commande;
    private int id_produit;
    private int quantite;

    public ProduitCommande(int id, int id_commande, int id_produit, int quantite) {
        this.id = id;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.quantite = quantite;
    }

    public ProduitCommande() {
    }

    public ProduitCommande(int quantite) {
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public int getId_commande() {
        return id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

   
}
