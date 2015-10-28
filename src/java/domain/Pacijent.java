/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "pacijent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacijent.findAll", query = "SELECT p FROM Pacijent p"),
    @NamedQuery(name = "Pacijent.findById", query = "SELECT p FROM Pacijent p WHERE p.id = :id"),
    @NamedQuery(name = "Pacijent.findByIme", query = "SELECT p FROM Pacijent p WHERE p.ime = :ime"),
    @NamedQuery(name = "Pacijent.findByPrezime", query = "SELECT p FROM Pacijent p WHERE p.prezime = :prezime"),
    @NamedQuery(name = "Pacijent.findByDatumRodjenja", query = "SELECT p FROM Pacijent p WHERE p.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Pacijent.findByRadniStatus", query = "SELECT p FROM Pacijent p WHERE p.radniStatus = :radniStatus"),
    @NamedQuery(name = "Pacijent.findByJmbg", query = "SELECT p FROM Pacijent p WHERE p.jmbg = :jmbg")})
public class Pacijent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "ime")
    private String ime;
    @Size(max = 30)
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "datum_rodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @Size(max = 50)
    @Column(name = "radni_status")
    private String radniStatus;
    @Size(max = 13)
    @Column(name = "jmbg")
    private String jmbg;
    @JoinColumn(name = "mesto", referencedColumnName = "id")
    @ManyToOne
    private Mesto mesto;
    @OneToMany(mappedBy = "pacijent")
    private List<Intervencija> intervencijaList;

    public Pacijent() {
    }

    public Pacijent(Integer id) {
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

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getRadniStatus() {
        return radniStatus;
    }

    public void setRadniStatus(String radniStatus) {
        this.radniStatus = radniStatus;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
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
        if (!(object instanceof Pacijent)) {
            return false;
        }
        Pacijent other = (Pacijent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Pacijent[ id=" + id + " ]";
    }
    
}
