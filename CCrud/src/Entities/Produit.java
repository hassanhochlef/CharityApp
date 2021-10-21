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
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
    , @NamedQuery(name = "Produit.findByProductId", query = "SELECT p FROM Produit p WHERE p.productId = :productId")
    , @NamedQuery(name = "Produit.findByName", query = "SELECT p FROM Produit p WHERE p.name = :name")
    , @NamedQuery(name = "Produit.findByQuantite", query = "SELECT p FROM Produit p WHERE p.quantite = :quantite")
    , @NamedQuery(name = "Produit.findByPrixApprox", query = "SELECT p FROM Produit p WHERE p.prixApprox = :prixApprox")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productId")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "quantite")
    private int quantite;
    @Basic(optional = false)
    @Column(name = "prix_approx")
    private float prixApprox;
    @JoinColumn(name = "donorId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User donorId;

    public Produit() {
    }

    public Produit(Integer productId) {
        this.productId = productId;
    }

    public Produit(Integer productId, String name, int quantite, float prixApprox) {
        this.productId = productId;
        this.name = name;
        this.quantite = quantite;
        this.prixApprox = prixApprox;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixApprox() {
        return prixApprox;
    }

    public void setPrixApprox(float prixApprox) {
        this.prixApprox = prixApprox;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit1.Produit[ productId=" + productId + " ]";
    }
    
}
