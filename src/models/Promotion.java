/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author chedi
 */
public class Promotion {
    
    private int id;
    private int percentage;

    public Promotion() {
    }

    public Promotion(int id, int percentage) {
        this.id = id;
        this.percentage = percentage;
    }

    public Promotion(int percentage) {
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", percentage=" + percentage + '}';
    }
    
    
    
}
