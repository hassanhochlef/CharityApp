/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit1;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "recu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recu.findAll", query = "SELECT r FROM Recu r")
    , @NamedQuery(name = "Recu.findByRecuId", query = "SELECT r FROM Recu r WHERE r.recuId = :recuId")
    , @NamedQuery(name = "Recu.findByDatePayement", query = "SELECT r FROM Recu r WHERE r.datePayement = :datePayement")})
public class Recu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recuId")
    private Integer recuId;
    @Basic(optional = false)
    @Column(name = "datePayement")
    @Temporal(TemporalType.DATE)
    private Date datePayement;
    @JoinColumn(name = "donationId", referencedColumnName = "donId")
    @ManyToOne(optional = false)
    private Don donationId;

    public Recu() {
    }

    public Recu(Integer recuId) {
        this.recuId = recuId;
    }

    public Recu(Integer recuId, Date datePayement) {
        this.recuId = recuId;
        this.datePayement = datePayement;
    }

    public Integer getRecuId() {
        return recuId;
    }

    public void setRecuId(Integer recuId) {
        this.recuId = recuId;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public Don getDonationId() {
        return donationId;
    }

    public void setDonationId(Don donationId) {
        this.donationId = donationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recuId != null ? recuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recu)) {
            return false;
        }
        Recu other = (Recu) object;
        if ((this.recuId == null && other.recuId != null) || (this.recuId != null && !this.recuId.equals(other.recuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Recu[ recuId=" + recuId + " ]";
    }
    
}
