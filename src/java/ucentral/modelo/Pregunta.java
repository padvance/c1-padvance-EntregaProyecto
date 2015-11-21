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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "pregunta", catalog = "preguntas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")})
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpregunta", nullable = false)
    private Integer idpregunta;
    @Size(max = 45)
    @Column(name = "descri_pregunta", length = 45)
    private String descriPregunta;
    @Size(max = 45)
    @Column(name = "tipo_pregunta", length = 45)
    private String tipoPregunta;
    @Size(max = 45)
    @Column(name = "dificultad_pregunta", length = 45)
    private String dificultadPregunta;
    @Column(name = "peso_pregunta")
    private Integer pesoPregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntaIdpregunta")
    private List<PreguntaRespuesta> preguntaRespuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntaIdpregunta")
    private List<PreguntaExamen> preguntaExamenList;
    @JoinColumn(name = "materia_idmateria", referencedColumnName = "idmateria", nullable = false)
    @ManyToOne(optional = false)
    private Materia materiaIdmateria;
    @JoinColumn(name = "respuesta_idrespuesta", referencedColumnName = "idrespuesta", nullable = false)
    @ManyToOne(optional = false)
    private Respuesta respuestaIdrespuesta;

    public Pregunta() {
    }

    public Pregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public Integer getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public String getDescriPregunta() {
        return descriPregunta;
    }

    public void setDescriPregunta(String descriPregunta) {
        this.descriPregunta = descriPregunta;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getDificultadPregunta() {
        return dificultadPregunta;
    }

    public void setDificultadPregunta(String dificultadPregunta) {
        this.dificultadPregunta = dificultadPregunta;
    }

    public Integer getPesoPregunta() {
        return pesoPregunta;
    }

    public void setPesoPregunta(Integer pesoPregunta) {
        this.pesoPregunta = pesoPregunta;
    }

    @XmlTransient
    public List<PreguntaRespuesta> getPreguntaRespuestaList() {
        return preguntaRespuestaList;
    }

    public void setPreguntaRespuestaList(List<PreguntaRespuesta> preguntaRespuestaList) {
        this.preguntaRespuestaList = preguntaRespuestaList;
    }

    @XmlTransient
    public List<PreguntaExamen> getPreguntaExamenList() {
        return preguntaExamenList;
    }

    public void setPreguntaExamenList(List<PreguntaExamen> preguntaExamenList) {
        this.preguntaExamenList = preguntaExamenList;
    }

    public Materia getMateriaIdmateria() {
        return materiaIdmateria;
    }

    public void setMateriaIdmateria(Materia materiaIdmateria) {
        this.materiaIdmateria = materiaIdmateria;
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
        hash += (idpregunta != null ? idpregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idpregunta == null && other.idpregunta != null) || (this.idpregunta != null && !this.idpregunta.equals(other.idpregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + idpregunta + ", descripcion="+getDescriPregunta()+" ]";
    }
    
}
