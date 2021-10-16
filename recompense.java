/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;





public class recompense {
    
    private int recompenseId ;
   
    private int donorId ;
    private int nbrePoints ;
    private String daterecompense;

    public recompense() {
    }

    public recompense(int donorId, int nbrePoints, String daterecompense) {
        this.donorId = donorId;
        this.nbrePoints = nbrePoints;
        this.daterecompense = daterecompense;
    }

    public recompense(int recompenseId, int donorId, int nbrePoints, String daterecompense) {
        this.recompenseId = recompenseId;
        this.donorId = donorId;
        this.nbrePoints = nbrePoints;
        this.daterecompense = daterecompense;
    }

    
    
    public String getDaterecompense() {
        return daterecompense;
    }

    public void setDaterecompense(String daterecompense) {
        this.daterecompense = daterecompense;
    }

    
    public int getRecompenseId() {
        return recompenseId;
    }

    public void setRecompenseId(int recompenseId) {
        this.recompenseId = recompenseId;
    }

    public int getNbrePoints() {
        return nbrePoints;
    }

    public void setNbrePoints(int nbrePoints) {
        this.nbrePoints = nbrePoints;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    @Override
    public String toString() {
        return "recompense{" + "recompenseId=" + recompenseId + ", nbrePoints=" + nbrePoints + ", donorId=" + donorId + ", daterecompense=" + daterecompense + '}';
    }

    
    }

    


