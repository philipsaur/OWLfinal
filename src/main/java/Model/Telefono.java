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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private Double telefono;
    @JoinColumn(name = "inscripcion_Numero_documento", referencedColumnName = "Numero_documento")
    @ManyToOne(optional = false)
    private Inscripcion inscripcionNumerodocumento;
    @JoinColumn(name = "usuarios_N_documento", referencedColumnName = "N_documento")
    @ManyToOne(optional = false)
    private Usuarios usuariosNdocumento;

    public Telefono() {
    }

    public Telefono(Double telefono) {
        this.telefono = telefono;
    }

    public Double getTelefono() {
        return telefono;
    }

    public void setTelefono(Double telefono) {
        this.telefono = telefono;
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
        hash += (telefono != null ? telefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefono == null && other.telefono != null) || (this.telefono != null && !this.telefono.equals(other.telefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Telefono[ telefono=" + telefono + " ]";
    }
    
}
