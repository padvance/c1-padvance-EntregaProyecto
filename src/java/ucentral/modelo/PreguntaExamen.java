/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucentral.modelo;

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
 * @author rm-rf
 */
@Entity
@Table(name = "examen_has_pregunta", catalog = "preguntas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaExamen.findAll", query = "SELECT p FROM PreguntaExamen p")})
public class PreguntaExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exampreg", nullable = false)
    private Integer idExampreg;
    @JoinColumn(name = "examen_idexamen", referencedColumnName = "idexamen", nullable = false)
    @ManyToOne(optional = false)
    private Examen examenIdexamen;
    @JoinColumn(name = "pregunta_idpregunta", referencedColumnName = "idpregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta preguntaIdpregunta;

    public PreguntaExamen() {
    }

    public PreguntaExamen(Integer idExampreg) {
        this.idExampreg = idExampreg;
    }

    public Integer getIdExampreg() {
        return idExampreg;
    }

    public void setIdExampreg(Integer idExampreg) {
        this.idExampreg = idExampreg;
    }

    public Examen getExamenIdexamen() {
        return examenIdexamen;
    }

    public void setExamenIdexamen(Examen examenIdexamen) {
        this.examenIdexamen = examenIdexamen;
    }

    public Pregunta getPreguntaIdpregunta() {
        return preguntaIdpregunta;
    }

    public void setPreguntaIdpregunta(Pregunta preguntaIdpregunta) {
        this.preguntaIdpregunta = preguntaIdpregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExampreg != null ? idExampreg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaExamen)) {
            return false;
        }
        PreguntaExamen other = (PreguntaExamen) object;
        if ((this.idExampreg == null && other.idExampreg != null) || (this.idExampreg != null && !this.idExampreg.equals(other.idExampreg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + idExampreg + " ]";
    }
    
}
