/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "incapacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incapacidad.findAll", query = "SELECT i FROM Incapacidad i"),
    @NamedQuery(name = "Incapacidad.findByNoradicado", query = "SELECT i FROM Incapacidad i WHERE i.noradicado = :noradicado"),
    @NamedQuery(name = "Incapacidad.findByFechaincapacidad", query = "SELECT i FROM Incapacidad i WHERE i.fechaincapacidad = :fechaincapacidad"),
    @NamedQuery(name = "Incapacidad.findByTipoexcusa", query = "SELECT i FROM Incapacidad i WHERE i.tipoexcusa = :tipoexcusa"),
    @NamedQuery(name = "Incapacidad.findByNocontacto", query = "SELECT i FROM Incapacidad i WHERE i.nocontacto = :nocontacto")})
public class Incapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "No_radicado")
    private Integer noradicado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_incapacidad")
    @Temporal(TemporalType.DATE)
    private Date fechaincapacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo_excusa")
    private String tipoexcusa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "No_contacto")
    private Double nocontacto;
    @JoinColumn(name = "novedades_Id_empleado", referencedColumnName = "Id_empleado")
    @ManyToOne(optional = false)
    private Novedades novedadesIdempleado;

    public Incapacidad() {
    }

    public Incapacidad(Integer noradicado) {
        this.noradicado = noradicado;
    }

    public Incapacidad(Integer noradicado, Date fechaincapacidad, String tipoexcusa) {
        this.noradicado = noradicado;
        this.fechaincapacidad = fechaincapacidad;
        this.tipoexcusa = tipoexcusa;
    }

    public Integer getNoradicado() {
        return noradicado;
    }

    public void setNoradicado(Integer noradicado) {
        this.noradicado = noradicado;
    }

    public Date getFechaincapacidad() {
        return fechaincapacidad;
    }

    public void setFechaincapacidad(Date fechaincapacidad) {
        this.fechaincapacidad = fechaincapacidad;
    }

    public String getTipoexcusa() {
        return tipoexcusa;
    }

    public void setTipoexcusa(String tipoexcusa) {
        this.tipoexcusa = tipoexcusa;
    }

    public Double getNocontacto() {
        return nocontacto;
    }

    public void setNocontacto(Double nocontacto) {
        this.nocontacto = nocontacto;
    }

    public Novedades getNovedadesIdempleado() {
        return novedadesIdempleado;
    }

    public void setNovedadesIdempleado(Novedades novedadesIdempleado) {
        this.novedadesIdempleado = novedadesIdempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noradicado != null ? noradicado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incapacidad)) {
            return false;
        }
        Incapacidad other = (Incapacidad) object;
        if ((this.noradicado == null && other.noradicado != null) || (this.noradicado != null && !this.noradicado.equals(other.noradicado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Incapacidad[ noradicado=" + noradicado + " ]";
    }
    
}
