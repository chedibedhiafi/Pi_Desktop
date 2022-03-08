/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Promotion;

/**
 *
 * @author chedi
 */
public interface Ipromotion {
    
     public Promotion retrivepromotion(int id);
    
    public Promotion retrievePromotionBypercentage(int percentage);

    
    
}
