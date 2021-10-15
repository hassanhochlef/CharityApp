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
@Table(name = "reclamation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamation.findAll", query = "SELECT r FROM Reclamation r")
    , @NamedQuery(name = "Reclamation.findByReclamationId", query = "SELECT r FROM Reclamation r WHERE r.reclamationId = :reclamationId")
    , @NamedQuery(name = "Reclamation.findByDateReclamation", query = "SELECT r FROM Reclamation r WHERE r.dateReclamation = :dateReclamation")
    , @NamedQuery(name = "Reclamation.findByContenu", query = "SELECT r FROM Reclamation r WHERE r.contenu = :contenu")})
public class Reclamation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reclamationId")
    private Integer reclamationId;
    @Basic(optional = false)
    @Column(name = "dateReclamation")
    @Temporal(TemporalType.DATE)
    private Date dateReclamation;
    @Basic(optional = false)
    @Column(name = "contenu")
    private String contenu;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "eventId", referencedColumnName = "eventId")
    @ManyToOne(optional = false)
    private Evenement eventId;

    public Reclamation() {
    }

    public Reclamation(Integer reclamationId) {
        this.reclamationId = reclamationId;
    }

    public Reclamation(Integer reclamationId, Date dateReclamation, String contenu) {
        this.reclamationId = reclamationId;
        this.dateReclamation = dateReclamation;
        this.contenu = contenu;
    }

    public Integer getReclamationId() {
        return reclamationId;
    }

    public void setReclamationId(Integer reclamationId) {
        this.reclamationId = reclamationId;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Evenement getEventId() {
        return eventId;
    }

    public void setEventId(Evenement eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reclamationId != null ? reclamationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.reclamationId == null && other.reclamationId != null) || (this.reclamationId != null && !this.reclamationId.equals(other.reclamationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Reclamation[ reclamationId=" + reclamationId + " ]";
    }
    
}
