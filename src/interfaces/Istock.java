/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Stock;

/**
 *
 * @author 21694
 */
public interface Istock {
    
     public boolean ajouterStock(Stock s);
    
    //lister
    public List<Stock> afficherStocks();
    
    public boolean modifierStock(Stock s);
    
    public boolean supprimerStock(Stock s);
    
}
