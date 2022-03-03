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
        
        System.out.println(serviceHistoriqueStock.bestSellersThisMonth(Date.valueOf(LocalDate.now())));
        
    }
    
}
