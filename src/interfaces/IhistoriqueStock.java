/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.HistoriqueStock;

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

}
