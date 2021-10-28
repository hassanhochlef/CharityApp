/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Entities.Product;
import Services.ProductService;
import Utils.MyConnection;
/**
 *
 * @author Asus
 */
public class test {
     public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        ProductService prod = new ProductService();
        Product p1 = new Product(2,"a",5,22);
        prod.ajouterProduit(p1);
        //System.out.println(prod.afficherProduit());
        //prod.ModifierProduit(1,"benfoulekkkn",8,6);
        //prod.SupprimerProduit(1); 
    }
}
