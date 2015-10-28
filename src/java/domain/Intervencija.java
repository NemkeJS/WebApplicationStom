/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
 * @author Igor
 */
@Entity
@Table(name = "intervencija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervencija.findAll", query = "SELECT i FROM Intervencija i"),
    @NamedQuery(name = "Intervencija.findById", query = "SELECT i FROM Intervencija i WHERE i.id = :id"),
    @NamedQuery(name = "Intervencija.findByDatum", query = "SELECT i FROM Intervencija i WHERE i.datum = :datum")})
public class Intervencija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @JoinColumn(name = "radnik", referencedColumnName = "id")
    @ManyToOne
    private Radnik radnik;
    @JoinColumn(name = "usluga", referencedColumnName = "id")
    @ManyToOne
    private Usluga usluga;
    @JoinColumn(name = "lekar", referencedColumnName = "id")
    @ManyToOne
    private Lekar lekar;
    @JoinColumn(name = "pacijent", referencedColumnName = "id")
    @ManyToOne
    private Pacijent pacijent;

    public Intervencija() {
    }

    public Intervencija(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
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
        if (!(object instanceof Intervencija)) {
            return false;
        }
        Intervencija other = (Intervencija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Intervencija[ id=" + id + " ]";
    }
    
}
