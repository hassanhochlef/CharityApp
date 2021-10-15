/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;


/**
 *
 * @author khoubaib
 */

public class Don {
    private int serviceId;
    private int donorId; 
    private String TypeService;
    private String lieu;
    private  String DateDisponibilité ;

    public Don() {
    }

    public Don(int serviceId, int donorId, String TypeService, String lieu, String DateDisponibilité) {
        this.serviceId = serviceId;
        this.donorId = donorId;
        this.TypeService = TypeService;
        this.lieu = lieu;
        this.DateDisponibilité = DateDisponibilité;
    }

    public Don(int donorId, String TypeService, String lieu, String DateDisponibilité) {
        this.donorId = donorId;
        this.TypeService = TypeService;
        this.lieu = lieu;
        this.DateDisponibilité = DateDisponibilité;
    }
 
    public int getDonorId() {
        return donorId;
    }

    public int getServiceId() {
        return serviceId;
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

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
        return "DoneService{" + "donorId=" + donorId + ", serviceId=" + serviceId + ", TypeService=" + TypeService + ", lieu=" + lieu + ", DateDisponibilit\u00e9=" + DateDisponibilité + '}';
    }

    
}