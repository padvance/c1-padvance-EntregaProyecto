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
 * @author wvelascot
 */
@Entity
@Table(name = "pregunta_has_respuesta", catalog = "preguntas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaRespuesta.findAll", query = "SELECT p FROM PreguntaRespuesta p")})
public class PreguntaRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pregrespueta", nullable = false)
    private Integer idPregrespueta;
    @JoinColumn(name = "pregunta_idpregunta", referencedColumnName = "idpregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta preguntaIdpregunta;
    @JoinColumn(name = "respuesta_idrespuesta", referencedColumnName = "idrespuesta", nullable = false)
    @ManyToOne(optional = false)
    private Respuesta respuestaIdrespuesta;

    public PreguntaRespuesta() {
    }

    public PreguntaRespuesta(Integer idPregrespueta) {
        this.idPregrespueta = idPregrespueta;
    }

    public Integer getIdPregrespueta() {
        return idPregrespueta;
    }

    public void setIdPregrespueta(Integer idPregrespueta) {
        this.idPregrespueta = idPregrespueta;
    }

    public Pregunta getPreguntaIdpregunta() {
        return preguntaIdpregunta;
    }

    public void setPreguntaIdpregunta(Pregunta preguntaIdpregunta) {
        this.preguntaIdpregunta = preguntaIdpregunta;
    }

    public Respuesta getRespuestaIdrespuesta() {
        return respuestaIdrespuesta;
    }

    public void setRespuestaIdrespuesta(Respuesta respuestaIdrespuesta) {
        this.respuestaIdrespuesta = respuestaIdrespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregrespueta != null ? idPregrespueta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaRespuesta)) {
            return false;
        }
        PreguntaRespuesta other = (PreguntaRespuesta) object;
        if ((this.idPregrespueta == null && other.idPregrespueta != null) || (this.idPregrespueta != null && !this.idPregrespueta.equals(other.idPregrespueta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + idPregrespueta + " ]";
    }
    
}
