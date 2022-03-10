/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;



/**
 *
 * @author 21694
 */
public class Utilisateur {
    protected int id;
    protected String login;
    protected String mdp;
    protected Date date_naissance;
    protected String nom;
    protected String prenom;
    protected String email;
    protected int tentative;
    protected Date unlock_date;
    protected String msg;
    protected String etat;
    

    public Utilisateur() {
    }
    
    public Utilisateur(int id,String email, String mdp) {
        this.email = email;
        this.mdp = encrypt(mdp);
    }
    
    public Utilisateur(String mdp,int id) {
        this.id = id;
        this.mdp = encrypt(mdp);
    }

    public Utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = encrypt(mdp);
    }
    
    public Utilisateur(String login, String mdp, Date date_naissance, String nom, String prenom, String email, int tentative, Date unlock_date) {
        this.login = login;
        this.mdp = mdp;
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tentative = tentative;
        this.unlock_date = unlock_date;
    }
    
    public Utilisateur(int id, String login, String mdp, Date date_naissance, String nom, String prenom, String email, int tentative, Date unlock_date) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tentative = tentative;
        this.unlock_date = unlock_date;
    }
    
    public Utilisateur(String login, String mdp, Date date_naissance, String nom, String prenom, String email) {
        this.login = login;
        this.mdp = encrypt(mdp);
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tentative = 0;
        this.unlock_date = Date.valueOf("2000-01-01");
    }
    
    public Utilisateur(int id,String login, String mdp, Date date_naissance, String nom, String prenom, String email) {
        this.id=id;
        this.login = login;
        this.mdp = mdp;
        this.date_naissance = date_naissance;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getTentative() {
        return tentative;
    }

    public void setTentative(int tentative) {
        this.tentative = tentative;
    }

    public Date getUnlock_date() {
        return unlock_date;
    }

    public void setUnlock_date(Date unlock_date) {
        this.unlock_date = unlock_date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", login=" + login + ", mdp=" + mdp + ", date_naissance=" + date_naissance + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tentative=" + tentative + ", unlock_date=" + unlock_date + '}';
    }
    
    public String encrypt(String password){
        String Newstr="";  

        for (int i=0;i<password.length();i++)  
        {  
            char ch=Character.toLowerCase(password.charAt(i));  
            switch (ch)  
            {  
                case 'a':  
                    Newstr=Newstr+"{";  
                    break;  
                case 'b':  
                    Newstr=Newstr+"}";  
                    break;  
                case 'c':  
                    Newstr=Newstr+"#";  
                    break;  
                case 'd':  
                    Newstr=Newstr+"~";  
                    break;  
                case 'e':  
                    Newstr=Newstr+"+";  
                    break;  
                case 'f':  
                    Newstr=Newstr+"-";  
                    break;  
                case 'g':  
                    Newstr=Newstr+"*";  
                    break;  
                case 'h':  
                    Newstr=Newstr+"@";  
                    break;  
                case 'i':  
                    Newstr=Newstr+"/";  
                    break;  
                case 'j':  
                    Newstr=Newstr+"\\";  
                    break;  
                case 'k':  
                    Newstr=Newstr+"?";  
                    break;  
                case 'l':  
                    Newstr=Newstr+"$";  
                    break;  
                case 'm':  
                    Newstr=Newstr+"!";  
                    break;  
                case 'n':  
                    Newstr=Newstr+"^";  
                    break;  
                case 'o':  
                    Newstr=Newstr+"(";  
                    break;  
                case 'p':  
                    Newstr=Newstr+")";  
                    break;  
                case 'q':  
                    Newstr=Newstr+"<";  
                    break;  
                case 'r':  
                    Newstr=Newstr+">";  
                    break;  
                case 's' :  
                    Newstr=Newstr+"=";  
                    break;  
                case 't':  
                    Newstr=Newstr+";";  
                    break;  
                case 'u':  
                    Newstr=Newstr+",";  
                    break;  
                case 'v' :  
                    Newstr=Newstr+"_";  
                    break;  
                case 'w':  
                    Newstr=Newstr+"[";  
                    break;  
                case 'x' :  
                    Newstr=Newstr+"]";  
                    break;  
                case 'y':  
                    Newstr=Newstr+":";  
                    break;  
                case 'z' :  
                    Newstr=Newstr+"\"";  
                    break;  
                case ' ' :  
                    Newstr=Newstr+" ";  
                    break;  
                case '.':  
                    Newstr=Newstr+'3';  
                    break;  
                case ',':  
                    Newstr=Newstr+"1";  
                    break;  
                case '(':  
                    Newstr=Newstr+'4';  
                    break;  
                case '\"':  
                    Newstr=Newstr+'5';  
                    break;  
                case ')' :  
                    Newstr=Newstr+"7";  
                    break;  
                case '?' :  
                    Newstr= Newstr+"2";  
                    break;  
                case '!':  
                    Newstr= Newstr+"8";  
                    break;  
                case '-' :  
                    Newstr= Newstr+"6";  
                    break;  
                case '%' :  
                    Newstr = Newstr+"9";  
                    break;  
                case '1':  
                    Newstr=Newstr+"r";  
                    break;  
                case '2':  
                    Newstr=Newstr+"k";  
                    break;  
                case '3':  
                    Newstr=Newstr+"b";  
                    break;  
                case '4':  
                    Newstr = Newstr+"e";  
                    break;  
                case '5':  
                    Newstr = Newstr+"q";  
                    break;  
                case '6':  
                    Newstr = Newstr+"h";  
                    break;  
                case '7':  
                    Newstr = Newstr+"u";  
                    break;  
                case '8' :  
                    Newstr= Newstr+"y";  
                    break;  
                case '9':  
                    Newstr = Newstr+"w";  
                    break;  
                case '0':  
                    Newstr = Newstr+"z";  
                    break;  
                 default:  
                    Newstr=Newstr+"0";  
                    break;  
            }  
        }  
        
        
        return Newstr;
    }
    
    
}
