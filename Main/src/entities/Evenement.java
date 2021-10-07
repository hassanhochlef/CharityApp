/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author SeifD
 */
public class Evenement {
    private int id;
    private String name;
    private String cause;
    private int num_participants;
    private float montant_collecte;
    private String description;

    public Evenement(){
        
    }
    
    public Evenement(String name, String cause, int num_participants, float montant_collecte, String description) {
        this.name = name;
        this.cause = cause;
        this.num_participants = num_participants;
        this.montant_collecte = montant_collecte;
        this.description = description;
    }
    
    public Evenement(int id, String name, String cause, int num_participants, float montant_collecte, String description) {
        this.id = id;
        this.name = name;
        this.cause = cause;
        this.num_participants = num_participants;
        this.montant_collecte = montant_collecte;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getNum_participants() {
        return num_participants;
    }

    public void setNum_participants(int num_participants) {
        this.num_participants = num_participants;
    }

    public float getMontant_collecte() {
        return montant_collecte;
    }

    public void setMontant_collecte(float montant_collecte) {
        this.montant_collecte = montant_collecte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", name=" + name + ", cause=" + cause + ", num_participants=" + num_participants + ", montant_collecte=" + montant_collecte + ", description=" + description + '}';
    }
    
    
    
    
    
}
