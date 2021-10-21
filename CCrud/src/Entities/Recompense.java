/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "recompense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recompense.findAll", query = "SELECT r FROM Recompense r")
    , @NamedQuery(name = "Recompense.findByRecompenseId", query = "SELECT r FROM Recompense r WHERE r.recompenseId = :recompenseId")
    , @NamedQuery(name = "Recompense.findByNbrePoints", query = "SELECT r FROM Recompense r WHERE r.nbrePoints = :nbrePoints")})
public class Recompense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recompenseId")
    private Integer recompenseId;
    @Basic(optional = false)
    @Column(name = "nbrePoints")
    private int nbrePoints;
    @JoinColumn(name = "donorId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User donorId;

    public Recompense() {
    }

    public Recompense(Integer recompenseId) {
        this.recompenseId = recompenseId;
    }

    public Recompense(Integer recompenseId, int nbrePoints) {
        this.recompenseId = recompenseId;
        this.nbrePoints = nbrePoints;
    }

    public Integer getRecompenseId() {
        return recompenseId;
    }

    public void setRecompenseId(Integer recompenseId) {
        this.recompenseId = recompenseId;
    }

    public int getNbrePoints() {
        return nbrePoints;
    }

    public void setNbrePoints(int nbrePoints) {
        this.nbrePoints = nbrePoints;
    }

    public User getDonorId() {
        return donorId;
    }

    public void setDonorId(User donorId) {
        this.donorId = donorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recompenseId != null ? recompenseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recompense)) {
            return false;
        }
        Recompense other = (Recompense) object;
        if ((this.recompenseId == null && other.recompenseId != null) || (this.recompenseId != null && !this.recompenseId.equals(other.recompenseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Recompense[ recompenseId=" + recompenseId + " ]";
    }
    
}
