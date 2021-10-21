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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hassan
 */
@Entity
@Table(name = "besoin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Besoin.findAll", query = "SELECT b FROM Besoin b")
    , @NamedQuery(name = "Besoin.findByIdBesoin", query = "SELECT b FROM Besoin b WHERE b.idBesoin = :idBesoin")
    , @NamedQuery(name = "Besoin.findByMontant", query = "SELECT b FROM Besoin b WHERE b.montant = :montant")
    , @NamedQuery(name = "Besoin.findByQuantite", query = "SELECT b FROM Besoin b WHERE b.quantite = :quantite")
    , @NamedQuery(name = "Besoin.findByCategorie", query = "SELECT b FROM Besoin b WHERE b.categorie = :categorie")
    , @NamedQuery(name = "Besoin.findByDescription", query = "SELECT b FROM Besoin b WHERE b.description = :description")})
public class Besoin implements Serializable {

    @Column(name = "montantactuel")
    private Float montantactuel;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBesoin")
    private Integer idBesoin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Float montant;
    @Column(name = "quantite")
    private Integer quantite;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "description")
    private String description;

    public Besoin() {
    }

    public Besoin(Integer idBesoin) {
        this.idBesoin = idBesoin;
    }

    public Besoin(Integer idBesoin, String description) {
        this.idBesoin = idBesoin;
        this.description = description;
    }
    public Besoin(Float montantactuel, String description) {
        this.montantactuel = montantactuel;
        this.description = description;
    }

    public Besoin(Integer idBesoin, Float montant, Integer quantite, String categorie, String description) {
        this.idBesoin = idBesoin;
        this.montant = montant;
        this.quantite = quantite;
        this.categorie = categorie;
        this.description = description;
    }

    

    public Integer getIdBesoin() {
        return idBesoin;
    }

    public void setIdBesoin(Integer idBesoin) {
        this.idBesoin = idBesoin;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBesoin != null ? idBesoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Besoin)) {
            return false;
        }
        Besoin other = (Besoin) object;
        if ((this.idBesoin == null && other.idBesoin != null) || (this.idBesoin != null && !this.idBesoin.equals(other.idBesoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Besoin[ idBesoin=" + idBesoin + " ]";
    }

    public Float getMontantactuel() {
        return montantactuel;
    }

    public void setMontantactuel(Float montantactuel) {
        this.montantactuel = montantactuel;
    }
    
}
