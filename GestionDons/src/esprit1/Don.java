/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "don")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Don.findAll", query = "SELECT d FROM Don d")
    , @NamedQuery(name = "Don.findByDonId", query = "SELECT d FROM Don d WHERE d.donId = :donId")
    , @NamedQuery(name = "Don.findByDonationDate", query = "SELECT d FROM Don d WHERE d.donationDate = :donationDate")
    , @NamedQuery(name = "Don.findByMontant", query = "SELECT d FROM Don d WHERE d.montant = :montant")
    , @NamedQuery(name = "Don.findByCategorie", query = "SELECT d FROM Don d WHERE d.categorie = :categorie")})
public class Don implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "donId")
    private Integer donId;
    @Basic(optional = false)
    @Column(name = "donationDate")
    @Temporal(TemporalType.DATE)
    private Date donationDate;
    @Basic(optional = false)
    @Column(name = "montant")
    private float montant;
    @Basic(optional = false)
    @Column(name = "Categorie")
    private String categorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donationId")
    private Collection<Recu> recuCollection;
    @JoinColumn(name = "donorId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User donorId;
    @JoinColumn(name = "eventId", referencedColumnName = "eventId")
    @ManyToOne(optional = false)
    private EventUser eventId;

    public Don() {
    }

    public Don(Integer donId) {
        this.donId = donId;
    }

    public Don(Integer donId, Date donationDate, float montant, String categorie) {
        this.donId = donId;
        this.donationDate = donationDate;
        this.montant = montant;
        this.categorie = categorie;
    }

    public Integer getDonId() {
        return donId;
    }

    public void setDonId(Integer donId) {
        this.donId = donId;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @XmlTransient
    public Collection<Recu> getRecuCollection() {
        return recuCollection;
    }

    public void setRecuCollection(Collection<Recu> recuCollection) {
        this.recuCollection = recuCollection;
    }

    public User getDonorId() {
        return donorId;
    }

    public void setDonorId(User donorId) {
        this.donorId = donorId;
    }

    public EventUser getEventId() {
        return eventId;
    }

    public void setEventId(EventUser eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donId != null ? donId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Don)) {
            return false;
        }
        Don other = (Don) object;
        if ((this.donId == null && other.donId != null) || (this.donId != null && !this.donId.equals(other.donId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Don[ donId=" + donId + " ]";
    }
    
}
