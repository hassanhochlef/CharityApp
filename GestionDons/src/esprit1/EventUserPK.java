/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Hassan
 */
@Embeddable
public class EventUserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "eventId")
    private int eventId;
    @Basic(optional = false)
    @Column(name = "userId")
    private int userId;

    public EventUserPK() {
    }

    public EventUserPK(int eventId, int userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventUserPK)) {
            return false;
        }
        EventUserPK other = (EventUserPK) object;
        if (this.eventId != other.eventId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.EventUserPK[ eventId=" + eventId + ", userId=" + userId + " ]";
    }
    
}
