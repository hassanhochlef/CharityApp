/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author 21654
 */
public class DoneService {
    private int IdDonneurS;
    private String TypeService;
    private String lieu;
    private String DateDisponibilité;

    public DoneService() {
    }

    public DoneService(int IdDonneurS, String TypeService, String lieu, String DateDisponibilité) {
        this.IdDonneurS = IdDonneurS;
        this.TypeService = TypeService;
        this.lieu = lieu;
        this.DateDisponibilité = DateDisponibilité;
    }

    public int getIdDonneurS() {
        return IdDonneurS;
    }

    public String getTypeService() {
        return TypeService;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDateDisponibilité() {
        return DateDisponibilité;
    }

    public void setIdDonneurS(int IdDonneurS) {
        this.IdDonneurS = IdDonneurS;
    }

    public void setTypeService(String TypeService) {
        this.TypeService = TypeService;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDateDisponibilité(String DateDisponibilité) {
        this.DateDisponibilité = DateDisponibilité;
    }

    @Override
    public String toString() {
        return "DonService{" + "IdDonneurS=" + IdDonneurS + ", TypeService=" + TypeService + ", lieu=" + lieu + ", DateDisponibilit\u00e9=" + DateDisponibilité + '}';
    }
    
    
    
    
}
