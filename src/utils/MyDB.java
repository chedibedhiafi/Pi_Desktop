/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author SOULAYMA
 */
public class MyDB {
   
    final String URL="jdbc:mysql://127.0.0.1:3306/pidev";
    final String USERNAME="root";
    final String PWD="";
    
    private Connection cnx;
    //1
    static MyDB instance = null;
    
    //constructeur
    //2
    private MyDB() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    //3
    public static MyDB getInstance() {
        
        if(instance == null){
            instance = new MyDB();
        }
        return instance;
    }
                
            
}
