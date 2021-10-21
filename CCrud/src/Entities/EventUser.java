/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "event_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventUser.findAll", query = "SELECT e FROM EventUser e")
    , @NamedQuery(name = "EventUser.findByEventId", query = "SELECT e FROM EventUser e WHERE e.eventUserPK.eventId = :eventId")
    , @NamedQuery(name = "EventUser.findByUserId", query = "SELECT e FROM EventUser e WHERE e.eventUserPK.userId = :userId")})
public class EventUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventUserPK eventUserPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<Don> donCollection;
    @JoinColumn(name = "eventId", referencedColumnName = "eventId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evenement evenement;
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public EventUser() {
    }

    public EventUser(EventUserPK eventUserPK) {
        this.eventUserPK = eventUserPK;
    }

    public EventUser(int eventId, int userId) {
        this.eventUserPK = new EventUserPK(eventId, userId);
    }

    public EventUserPK getEventUserPK() {
        return eventUserPK;
    }

    public void setEventUserPK(EventUserPK eventUserPK) {
        this.eventUserPK = eventUserPK;
    }

    @XmlTransient
    public Collection<Don> getDonCollection() {
        return donCollection;
    }

    public void setDonCollection(Collection<Don> donCollection) {
        this.donCollection = donCollection;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventUserPK != null ? eventUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventUser)) {
            return false;
        }
        EventUser other = (EventUser) object;
        if ((this.eventUserPK == null && other.eventUserPK != null) || (this.eventUserPK != null && !this.eventUserPK.equals(other.eventUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.EventUser[ eventUserPK=" + eventUserPK + " ]";
    }
    
}
