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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donaciones.findAll", query = "SELECT d FROM Donaciones d"),
    @NamedQuery(name = "Donaciones.findByIddonacion", query = "SELECT d FROM Donaciones d WHERE d.iddonacion = :iddonacion"),
    @NamedQuery(name = "Donaciones.findByFechadonacion", query = "SELECT d FROM Donaciones d WHERE d.fechadonacion = :fechadonacion"),
    @NamedQuery(name = "Donaciones.findByCantidad", query = "SELECT d FROM Donaciones d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Donaciones.findByTipodonacion", query = "SELECT d FROM Donaciones d WHERE d.tipodonacion = :tipodonacion")})
public class Donaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_donacion")
    private Integer iddonacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_donacion")
    @Temporal(TemporalType.DATE)
    private Date fechadonacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo_donacion")
    private int tipodonacion;
    @JoinColumn(name = "Id_donacion", referencedColumnName = "Id_inventarios", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Inventarios inventarios;

    public Donaciones() {
    }

    public Donaciones(Integer iddonacion) {
        this.iddonacion = iddonacion;
    }

    public Donaciones(Integer iddonacion, Date fechadonacion, int cantidad, int tipodonacion) {
        this.iddonacion = iddonacion;
        this.fechadonacion = fechadonacion;
        this.cantidad = cantidad;
        this.tipodonacion = tipodonacion;
    }

    public Integer getIddonacion() {
        return iddonacion;
    }

    public void setIddonacion(Integer iddonacion) {
        this.iddonacion = iddonacion;
    }

    public Date getFechadonacion() {
        return fechadonacion;
    }

    public void setFechadonacion(Date fechadonacion) {
        this.fechadonacion = fechadonacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipodonacion() {
        return tipodonacion;
    }

    public void setTipodonacion(int tipodonacion) {
        this.tipodonacion = tipodonacion;
    }

    public Inventarios getInventarios() {
        return inventarios;
    }

    public void setInventarios(Inventarios inventarios) {
        this.inventarios = inventarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddonacion != null ? iddonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donaciones)) {
            return false;
        }
        Donaciones other = (Donaciones) object;
        if ((this.iddonacion == null && other.iddonacion != null) || (this.iddonacion != null && !this.iddonacion.equals(other.iddonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Donaciones[ iddonacion=" + iddonacion + " ]";
    }
    
}
