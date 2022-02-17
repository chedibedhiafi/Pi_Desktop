/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import models.HistoriqueStock;
import models.PointDeVente;
import models.Stock;
import services.ServiceHistoriqueStock;
import services.ServicePointDeVente;
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
        
        //var
        PointDeVente p1 = new PointDeVente("theName", "proprio", "adresse", "2022-12-02","yyyy-M-d");
        ServicePointDeVente sp = new ServicePointDeVente();
        PointDeVente p2 = new PointDeVente(1,"name", "proprio", "adresse", "2022-12-02","yyyy-M-d");
        
        //sp.ajouterPointDeVente(p1);
        sp.modifierPointDeVente(p2);
        System.out.println(sp.afficherPointDeVentes());
        
        Stock s1 = new Stock(1, 2, 100);
        ServiceStock ss = new ServiceStock();
        Stock s2 = new Stock(1, 2, 120);
        
        //ss.ajouterStock(s1);
        //System.out.println(ss.afficherStocks());
        //ss.modifierStock(s2);
        //ss.supprimerStock(s2);
        
        HistoriqueStock hs = new HistoriqueStock(1,2,3,"2022-02-14",120,"yyyy-M-d");
        ServiceHistoriqueStock shs = new ServiceHistoriqueStock();
        HistoriqueStock hs1 = new HistoriqueStock(1,1,2,3,"2022-02-14",100,"yyyy-M-d");
        
        //shs.ajouterHistoriqueStock(hs);
        //System.out.println(shs.afficherHistoriqueStocks());
        //shs.modifierHistoriqueStock(hs1);
        //shs.supprimerHistoriqueStock(hs1.getReference());
    }
    
}
