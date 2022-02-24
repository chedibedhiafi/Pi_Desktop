/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import services.ServiceHistoriqueStock;
import services.ServiceStock;

/**
 *
 * @author 21694
 */
public class Stock {
    private Produit produit;
    private PointDeVente pointdevente;
    private int quantite;

    public Stock() {
    }

    public Stock(Produit produit, PointDeVente pointdevente, int quantite) {
        this.produit = produit;
        this.pointdevente = pointdevente;
        this.quantite = quantite;
    }

    public Stock(Produit produit, PointDeVente pointdevente) {
        this.produit = produit;
        this.pointdevente = pointdevente;
    }
    
    

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public PointDeVente getPointdevente() {
        return pointdevente;
    }

    public void setPointdevente(PointDeVente pointdevente) {
        this.pointdevente = pointdevente;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Stock{" + "produit=" + produit + ", pointdevente=" + pointdevente + ", quantite=" + quantite + '}';
    }

    
}
