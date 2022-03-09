/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.util.List;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;

/**
 *
 * @author 21624
 */
public interface IhistoriqueStock {
    public boolean ajouterHistoriqueStock(HistoriqueStock h);
    
    //lister
    public List<HistoriqueStock> afficherHistoriqueStocks();
    
    public boolean modifierHistoriqueStock(HistoriqueStock h);
    
    public boolean supprimerHistoriqueStock(HistoriqueStock h);
    
    public boolean insertInHistoriqueStock(HistoriqueStock h);
    
    public List<HistoriqueStock> getFromStock(Stock s);
    
    public List<Produit> bestSellersThisMonth(Date date);
    
    public List<HistoriqueStock> getHistoriquePt(PointDeVente pt, Date date);

}
