/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.esprit.tests;

import Edu.esprit.entities.Produit;
import Edu.esprit.services.produitservice;
import Edu.esprit.tools.Myconnection;


public class ConnexionTest {
    public static void main(String[] args) {
        Myconnection mc= Myconnection.getInstance();
        produitservice prod = new produitservice();
        Produit p1 = new Produit("foulen","benfoulen");
        //prod.ajouterProduit(p1);
        //System.out.println(prod.afficherProduit());
        //prod.ModifierProduit("foulen","benfoulekkkn");
        prod.SupprimerProduit("1"); 
    }
    
}
