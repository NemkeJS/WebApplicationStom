/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "usluga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usluga.findAll", query = "SELECT u FROM Usluga u"),
    @NamedQuery(name = "Usluga.findById", query = "SELECT u FROM Usluga u WHERE u.id = :id"),
    @NamedQuery(name = "Usluga.findByIme", query = "SELECT u FROM Usluga u WHERE u.ime = :ime"),
    @NamedQuery(name = "Usluga.findByOpis", query = "SELECT u FROM Usluga u WHERE u.opis = :opis"),
    @NamedQuery(name = "Usluga.findByCena", query = "SELECT u FROM Usluga u WHERE u.cena = :cena"),
    @NamedQuery(name = "Usluga.findByTrajanje", query = "SELECT u FROM Usluga u WHERE u.trajanje = :trajanje")})
public class Usluga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "ime")
    private String ime;
    @Size(max = 100)
    @Column(name = "opis")
    private String opis;
    @Column(name = "cena")
    private BigInteger cena;
    @Column(name = "trajanje")
    private Integer trajanje;
    @OneToMany(mappedBy = "usluga")
    private List<Intervencija> intervencijaList;

    public Usluga() {
    }

    public Usluga(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigInteger getCena() {
        return cena;
    }

    public void setCena(BigInteger cena) {
        this.cena = cena;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    @XmlTransient
    public List<Intervencija> getIntervencijaList() {
        return intervencijaList;
    }

    public void setIntervencijaList(List<Intervencija> intervencijaList) {
        this.intervencijaList = intervencijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usluga)) {
            return false;
        }
        Usluga other = (Usluga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Usluga[ id=" + id + " ]";
    }
    
}
