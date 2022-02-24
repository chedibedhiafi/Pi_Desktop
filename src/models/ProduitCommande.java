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
    private Commande c;
    private Produit p;
    private int quantite;

        public ProduitCommande(int id, Commande c, Produit p, int quantite) {
        this.id = id;
        this.c =c;
        this.p= p;
        this.quantite = quantite;
    }

    public ProduitCommande() {
    }

    public ProduitCommande(Commande c, Produit p, int quantite) {
        this.c = c;
        this.p = p;
        this.quantite = quantite;
    }

    

    public int getId() {
        return id;
    }

    public Commande getC() {
        return c;
    }

    public void setC(Commande c) {
        this.c = c;
    }

    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    

    public int getQuantite() {
        return quantite;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "ProduitCommande{" + "id=" + id + ", c=" + c + ", p=" + p + ", quantite=" + quantite + '}';
    }

   
}
