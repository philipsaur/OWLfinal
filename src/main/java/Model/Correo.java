/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c"),
    @NamedQuery(name = "Correo.findByCorreo", query = "SELECT c FROM Correo c WHERE c.correo = :correo")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @JoinColumn(name = "inscripcion_Numero_documento", referencedColumnName = "Numero_documento")
    @ManyToOne(optional = false)
    private Inscripcion inscripcionNumerodocumento;
    @JoinColumn(name = "usuarios_N_documento", referencedColumnName = "N_documento")
    @ManyToOne(optional = false)
    private Usuarios usuariosNdocumento;

    public Correo() {
    }

    public Correo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Inscripcion getInscripcionNumerodocumento() {
        return inscripcionNumerodocumento;
    }

    public void setInscripcionNumerodocumento(Inscripcion inscripcionNumerodocumento) {
        this.inscripcionNumerodocumento = inscripcionNumerodocumento;
    }

    public Usuarios getUsuariosNdocumento() {
        return usuariosNdocumento;
    }

    public void setUsuariosNdocumento(Usuarios usuariosNdocumento) {
        this.usuariosNdocumento = usuariosNdocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correo != null ? correo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Correo[ correo=" + correo + " ]";
    }
    
}
