/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 21694
 */
public class Stock {
    private int id_produit;
    private int id_pointdevente;
    private int quantite;

    public Stock() {
    }

    public Stock(int id_produit, int id_pointdevente, int quantite) {
        this.id_produit = id_produit;
        this.id_pointdevente = id_pointdevente;
        this.quantite = quantite;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getId_pointdevente() {
        return id_pointdevente;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_pointdevente(int id_pointdevente) {
        this.id_pointdevente = id_pointdevente;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Stock{" + "id_produit=" + id_produit + ", id_pointdevente=" + id_pointdevente + ", quantite=" + quantite + '}';
    }
    
    
    
}
