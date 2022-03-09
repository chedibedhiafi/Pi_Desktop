/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Promotion;

/**
 *
 * @author chedi
 */
public interface Ipromotion {
    
     public Promotion retrivepromotion(int id);
    
    public Promotion retrievePromotionBypercentage(int percentage);

    public List<Promotion> afficherPromotion();
     public boolean ajouterPromotion(Promotion p);
    
    
}
