/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author SOULAYMA
 */
public class Client {
    private int Client_Id;
    private String        Historique_Achat;
    private int Fk_Reserv;

    public Client(int Client_Id, String Historique_Achat, int Fk_Reserv) {
        this.Client_Id = Client_Id;
        this.Historique_Achat = Historique_Achat;
        this.Fk_Reserv = Fk_Reserv;
    }

    public Client(String Historique_Achat) {
        this.Historique_Achat = Historique_Achat;
    }

    public Client(int Client_Id, String Historique_Achat) {
        this.Client_Id = Client_Id;
        this.Historique_Achat = Historique_Achat;
    }

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int Client_Id) {
        this.Client_Id = Client_Id;
    }

    public String getHistorique_Achat() {
        return Historique_Achat;
    }

    public void setHistorique_Achat(String Historique_Achat) {
        this.Historique_Achat = Historique_Achat;
    }

    public int getFk_Reserv() {
        return Fk_Reserv;
    }

    public void setFk_Reserv(int Fk_Reserv) {
        this.Fk_Reserv = Fk_Reserv;
    }

    @Override
    public String toString() {
        return "Client{" + "Client_Id=" + Client_Id + ", Historique_Achat=" + Historique_Achat + ", Fk_Reserv=" + Fk_Reserv + '}';
    }
    
    
    
}
