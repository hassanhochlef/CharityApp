/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Connection.MyConnection;

import esprit1.*;
import Service.DonationCrud;
import java.util.List;
import java.util.Date;
/**
 *
 * @author Hassan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyConnection mc = MyConnection.getInstance();
        DonationCrud dc = new DonationCrud();
        Donation p1 = new Donation("185","Hassan",2025,"31/07/1998");
        Donation p2 = new Donation("175","Aymen",25,"30/08/1851");
        //dc.AjouterDons(p1);
        //dc.AjouterDons(p2);
        dc.ModifierDons();
        dc.SupprimerDons();
        dc.afficherDons();
    }
    
}
