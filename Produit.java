/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.esprit.entities;


public class Produit {
    private String id_prod;
    private String nom_prod;
    
    public Produit (){}
    public Produit(String id_prod,String nom_prod){
    this.id_prod=id_prod;
    this.nom_prod=nom_prod;
    }

    public String getId_prod() {
        return id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    
   @Override
    public String toString() {
       return "produit{"+ "id_prod=" + id_prod + ", nom_prod=" + nom_prod + '}';
    }
    
}
