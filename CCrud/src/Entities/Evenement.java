/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
@Table(name = "evenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e")
    , @NamedQuery(name = "Evenement.findByEventId", query = "SELECT e FROM Evenement e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Evenement.findByCause", query = "SELECT e FROM Evenement e WHERE e.cause = :cause")
    , @NamedQuery(name = "Evenement.findByNumParticipants", query = "SELECT e FROM Evenement e WHERE e.numParticipants = :numParticipants")
    , @NamedQuery(name = "Evenement.findByDateCreation", query = "SELECT e FROM Evenement e WHERE e.dateCreation = :dateCreation")
    , @NamedQuery(name = "Evenement.findByMontantCollecte", query = "SELECT e FROM Evenement e WHERE e.montantCollecte = :montantCollecte")
    , @NamedQuery(name = "Evenement.findByDescription", query = "SELECT e FROM Evenement e WHERE e.description = :description")})
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eventId")
    private Integer eventId;
    @Basic(optional = false)
    @Column(name = "cause")
    private String cause;
    @Basic(optional = false)
    @Column(name = "num_participants")
    private int numParticipants;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @Column(name = "montant_collecte")
    private float montantCollecte;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evenement")
    private Collection<EventUser> eventUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<Reclamation> reclamationCollection;

    public Evenement() {
    }

    public Evenement(Integer eventId) {
        this.eventId = eventId;
    }

    public Evenement(Integer eventId, String cause, int numParticipants, Date dateCreation, float montantCollecte, String description) {
        this.eventId = eventId;
        this.cause = cause;
        this.numParticipants = numParticipants;
        this.dateCreation = dateCreation;
        this.montantCollecte = montantCollecte;
        this.description = description;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public float getMontantCollecte() {
        return montantCollecte;
    }

    public void setMontantCollecte(float montantCollecte) {
        this.montantCollecte = montantCollecte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<EventUser> getEventUserCollection() {
        return eventUserCollection;
    }

    public void setEventUserCollection(Collection<EventUser> eventUserCollection) {
        this.eventUserCollection = eventUserCollection;
    }

    @XmlTransient
    public Collection<Reclamation> getReclamationCollection() {
        return reclamationCollection;
    }

    public void setReclamationCollection(Collection<Reclamation> reclamationCollection) {
        this.reclamationCollection = reclamationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Evenement[ eventId=" + eventId + " ]";
    }
    
}
