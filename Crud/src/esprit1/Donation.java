/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit1;

/**
 *
 * @author Hassan
 */
public class Donation {
    int ID;
    String num_recu;
    String user ;
    float montant;
    String Date;
    

    @Override
    public String toString() {
        return "Donation{" + "ID=" + ID + ", num_recu=" + num_recu + ", user=" + user + ", montant=" + montant + '}';
    }

   

    public Donation(String num_recu, String user,float montant,String date) {
        this.num_recu = num_recu;
        this.user = user;
        this.montant = montant;
        this.Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Donation() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNum_recu() {
        return num_recu;
    }

    public void setNum_recu(String num_recu) {
        this.num_recu = num_recu;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
    
    
}
