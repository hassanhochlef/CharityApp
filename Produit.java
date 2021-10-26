/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.esprit.entities;


public class Produit {
    private int productId;
    private int donorId;
    private String name;
    private int quantite;
    private int prix_approx;
    
    public Produit (){}
    public Produit(int donorId,String name,int quantite,int prix_approx){
    
    this.donorId=donorId;
    this.name=name;
    this.quantite=quantite;
    this.prix_approx=prix_approx;
    
    }

   

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix_approx() {
        return prix_approx;
    }

    public void setPrix_approx(int prix_approx) {
        this.prix_approx = prix_approx;
    }

 

    
   @Override
    public String toString() {
       return "produit{"+ "productId=" + productId + ", donorId=" + donorId + ",name=" + name + ",quantite=" + quantite + ", prix_approx" + prix_approx +'}';
    }
    
}

