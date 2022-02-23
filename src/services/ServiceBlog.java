/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import interfaces.Iblog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import models.Blog;
import utils.MaConnexion;

/**
 *
 * @author Haroun
 */
public class ServiceBlog implements Iblog {
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterBlog(Blog b) {
        String request = "INSERT INTO `blog`(`titre`, `contenu`, `date`) VALUES ('"+b.getTitre()+"','"+b.getContenu()+"','"+b.getDate()+"')";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Blog> afficherBlogs() {
        List<Blog> blogs = new ArrayList<Blog>();

        String req="SELECT * FROM blog";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            // "yyyy-M-d"
            while(rs.next()){
                
              blogs.add(new Blog(rs.getInt("id"),rs.getString(2),rs.getString(3),rs.getDate(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return blogs;
    }

    @Override
    public boolean modifierBlog(Blog b) {
        String req = "UPDATE `blog` SET `titre`='"+b.getTitre()+"',`contenu`='"+b.getContenu()+"',`date`='"+b.getDate()+"' WHERE `id` = "+b.getId()+" ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerBlog(Blog b) {
        String req = "DELETE FROM `blog` WHERE `id` = "+b.getId()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Blog RetrieveBlog(int id) {
        Blog b = null;
                   String req="SELECT * FROM blog WHERE id="+id+" ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                b = new Blog(rs.getInt("id"),rs.getString("titre"),rs.getString("contenu"),rs.getDate("date"));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return b;
    }

    @Override
    public List<Blog> TriBlogs() {
         List<Blog> blogs = new ArrayList<Blog>();

        String req="SELECT * FROM blog ORDER BY date DESC";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            // "yyyy-M-d"
            while(rs.next()){
                
              blogs.add(new Blog(rs.getInt("id"),rs.getString(2),rs.getString(3),rs.getDate(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return blogs;
    }

    @Override
    public List<Blog> SearchBlogs(String titre) {
        List<Blog> blogs = new ArrayList<Blog>();

        String req="SELECT * FROM blog WHERE titre= '"+titre+"' ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){          
              blogs.add(new Blog(rs.getInt("id"),rs.getString(2),rs.getString(3),rs.getDate(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    
}
