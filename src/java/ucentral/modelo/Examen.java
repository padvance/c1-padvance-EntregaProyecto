/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucentral.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author wvelascot
 */
@Entity
@Table(name = "examen", catalog = "preguntas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamen", nullable = false)
    private Integer idexamen;
    @Size(max = 45)
    @Column(name = "descri_examen", length = 45)
    private String descriExamen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenIdexamen")
    private List<PreguntaExamen> preguntaExamenList;

    public Examen() {
    }

    public Examen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public String getDescriExamen() {
        return descriExamen;
    }

    public void setDescriExamen(String descriExamen) {
        this.descriExamen = descriExamen;
    }

    @XmlTransient
    public List<PreguntaExamen> getPreguntaExamenList() {
        return preguntaExamenList;
    }

    public void setPreguntaExamenList(List<PreguntaExamen> preguntaExamenList) {
        this.preguntaExamenList = preguntaExamenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamen != null ? idexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idexamen == null && other.idexamen != null) || (this.idexamen != null && !this.idexamen.equals(other.idexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + idexamen + ", descripcion="+getDescriExamen()+" ]";
    }
    
    @XmlTransient
    public Memento guardar(){
        return new Memento(this);
    }
    
    public void volverUltimoEstado(Object obj){
        Memento m = (Memento) obj;
        this.descriExamen = m.getDescriExamen();
    }
    
}
