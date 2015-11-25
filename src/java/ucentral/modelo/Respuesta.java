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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wvelascot
 */
@Entity
@Table(name = "respuesta", catalog = "preguntas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")})
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrespuesta", nullable = false)
    private Integer idrespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descri_respuesta", nullable = false, length = 45)
    private String descriRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "veracidad_respuesta", nullable = false, length = 6)
    private String veracidadRespuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuestaIdrespuesta")
    private List<PreguntaRespuesta> preguntaRespuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuestaIdrespuesta")
    private List<Pregunta> preguntaList;

    public Respuesta() {
    }

    public Respuesta(Integer idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public Respuesta(Integer idrespuesta, String descriRespuesta, String veracidadRespuesta) {
        this.idrespuesta = idrespuesta;
        this.descriRespuesta = descriRespuesta;
        this.veracidadRespuesta = veracidadRespuesta;
    }

    public Integer getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(Integer idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public String getDescriRespuesta() {
        return descriRespuesta;
    }

    public void setDescriRespuesta(String descriRespuesta) {
        this.descriRespuesta = descriRespuesta;
    }

    public String getVeracidadRespuesta() {
        return veracidadRespuesta;
    }

    public void setVeracidadRespuesta(String veracidadRespuesta) {
        this.veracidadRespuesta = veracidadRespuesta;
    }

    @XmlTransient
    public List<PreguntaRespuesta> getPreguntaRespuestaList() {
        return preguntaRespuestaList;
    }

    public void setPreguntaRespuestaList(List<PreguntaRespuesta> preguntaRespuestaList) {
        this.preguntaRespuestaList = preguntaRespuestaList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrespuesta != null ? idrespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idrespuesta == null && other.idrespuesta != null) || (this.idrespuesta != null && !this.idrespuesta.equals(other.idrespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + idrespuesta + ", Descripcion="+getDescriRespuesta()+" ]";
    }
    
}
