/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
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
@Table(name = "lekar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lekar.findAll", query = "SELECT l FROM Lekar l"),
    @NamedQuery(name = "Lekar.findById", query = "SELECT l FROM Lekar l WHERE l.id = :id"),
    @NamedQuery(name = "Lekar.findByIme", query = "SELECT l FROM Lekar l WHERE l.ime = :ime"),
    @NamedQuery(name = "Lekar.findByPrezime", query = "SELECT l FROM Lekar l WHERE l.prezime = :prezime"),
    @NamedQuery(name = "Lekar.findBySpecijalnost", query = "SELECT l FROM Lekar l WHERE l.specijalnost = :specijalnost"),
    @NamedQuery(name = "Lekar.findByGodineStaza", query = "SELECT l FROM Lekar l WHERE l.godineStaza = :godineStaza")})
public class Lekar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "ime")
    private String ime;
    @Size(max = 30)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 50)
    @Column(name = "specijalnost")
    private String specijalnost;
    @Column(name = "godine_staza")
    private Integer godineStaza;
    @OneToMany(mappedBy = "lekar")
    private List<Intervencija> intervencijaList;

    public Lekar() {
    }

    public Lekar(Integer id) {
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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }

    public Integer getGodineStaza() {
        return godineStaza;
    }

    public void setGodineStaza(Integer godineStaza) {
        this.godineStaza = godineStaza;
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
        if (!(object instanceof Lekar)) {
            return false;
        }
        Lekar other = (Lekar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Lekar[ id=" + id + " ]";
    }
    
}
