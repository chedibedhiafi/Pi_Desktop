/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import interfaces.IhistoriqueStock;
import interfaces.IpointDeVente;
import interfaces.Iproduits;
import interfaces.Istock;
import java.sql.Date;
import java.time.LocalDate;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
import services.ServiceHistoriqueStock;
import services.ServicePointDeVente;
import services.ServiceProduit;
import services.ServiceStock;


/**
 *
 * @author 21624
 */
public class Quantech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Iproduits serviceProduit = new ServiceProduit();
        IpointDeVente serviceDeVente = new ServicePointDeVente();
        Istock serviceStock = new ServiceStock();
        IhistoriqueStock serviceHistoriqueStock = new ServiceHistoriqueStock();
        
        Produit pc = serviceProduit.retriveproduit(2);
        Produit A51 = serviceProduit.retriveproduit(16);
        Produit xiaomi = serviceProduit.retriveproduit(17);
        System.out.println(xiaomi);
        
        PointDeVente point1 = new PointDeVente(5,"name", "proprietaire", "adresse", Date.valueOf("2022-04-04"));
        //serviceDeVente.ajouterPointDeVente(point1);
        point1 = serviceDeVente.retrievePointDeVente(4);
        System.out.println(serviceDeVente.retrievePointDeVente(4));
        
        Stock stock1 = new Stock(xiaomi, point1);
        //serviceStock.ajouterStock(stock1);
        HistoriqueStock historiqueStock = new HistoriqueStock(stock1, Date.valueOf(LocalDate.now()), -12, "restock");
        //serviceHistoriqueStock.ajouterHistoriqueStock(historiqueStock);
        //serviceHistoriqueStock.supprimerHistoriqueStock(historiqueStock);
        //serviceHistoriqueStock.modifierHistoriqueStock(historiqueStock);
        //System.out.println(serviceStock.findProduit(A51, 4));
       
        
        PointDeVente point2 = new PointDeVente("Point G", "Hassen", "Soukra, Ariana", Date.valueOf("2000-04-04"));
        //serviceDeVente.ajouterPointDeVente(point2);
        System.out.println(serviceDeVente.retrievePointDeVente(6));
        System.out.println(serviceDeVente.chercherPointDeVente(serviceDeVente.afficherPointDeVentes(), "point g"));
        System.out.println(serviceHistoriqueStock.insertInHistoriqueStock(historiqueStock));
        
    }
    
}
