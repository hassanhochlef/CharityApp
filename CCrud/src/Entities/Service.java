/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findByServiceId", query = "SELECT s FROM Service s WHERE s.serviceId = :serviceId")
    , @NamedQuery(name = "Service.findByTypeService", query = "SELECT s FROM Service s WHERE s.typeService = :typeService")
    , @NamedQuery(name = "Service.findByLieu", query = "SELECT s FROM Service s WHERE s.lieu = :lieu")
    , @NamedQuery(name = "Service.findByDateDisponibilite", query = "SELECT s FROM Service s WHERE s.dateDisponibilite = :dateDisponibilite")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceId")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "typeService")
    private String typeService;
    @Basic(optional = false)
    @Column(name = "Lieu")
    private String lieu;
    @Basic(optional = false)
    @Column(name = "dateDisponibilite")
    @Temporal(TemporalType.DATE)
    private Date dateDisponibilite;
    @JoinColumn(name = "donorId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User donorId;

    public Service() {
    }

    public Service(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Service(Integer serviceId, String typeService, String lieu, Date dateDisponibilite) {
        this.serviceId = serviceId;
        this.typeService = typeService;
        this.lieu = lieu;
        this.dateDisponibilite = dateDisponibilite;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDateDisponibilite() {
        return dateDisponibilite;
    }

    public void setDateDisponibilite(Date dateDisponibilite) {
        this.dateDisponibilite = dateDisponibilite;
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
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Service[ serviceId=" + serviceId + " ]";
    }
    
}
