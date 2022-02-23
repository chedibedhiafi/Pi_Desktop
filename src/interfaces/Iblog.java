/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Haroun
 */
import java.util.List;
import models.Blog;

/**
 *
 * @author 21694
 */
public interface Iblog {
    
   //ajouter
    public boolean ajouterBlog(Blog b);
    
    //lister
    public List<Blog> afficherBlogs();
    
    public boolean modifierBlog(Blog b);
    
    public boolean supprimerBlog(Blog b);
    
    public Blog RetrieveBlog(int id);
    public List<Blog> TriBlogs();
    public List<Blog> SearchBlogs(String titre);
}

