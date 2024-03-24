/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "inventarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventarios.findAll", query = "SELECT i FROM Inventarios i"),
    @NamedQuery(name = "Inventarios.findByIdinventarios", query = "SELECT i FROM Inventarios i WHERE i.idinventarios = :idinventarios"),
    @NamedQuery(name = "Inventarios.findByFecharegistro", query = "SELECT i FROM Inventarios i WHERE i.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "Inventarios.findByCantidad", query = "SELECT i FROM Inventarios i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventarios.findByDescripcion", query = "SELECT i FROM Inventarios i WHERE i.descripcion = :descripcion")})
public class Inventarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_inventarios")
    private Integer idinventarios;
    @Column(name = "Fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    @Column(name = "Cantidad")
    private Short cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventarios")
    private Donaciones donaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventariosIdinventarios")
    private Collection<Usuarios> usuariosCollection;

    public Inventarios() {
    }

    public Inventarios(Integer idinventarios) {
        this.idinventarios = idinventarios;
    }

    public Inventarios(Integer idinventarios, String descripcion) {
        this.idinventarios = idinventarios;
        this.descripcion = descripcion;
    }

    public Integer getIdinventarios() {
        return idinventarios;
    }

    public void setIdinventarios(Integer idinventarios) {
        this.idinventarios = idinventarios;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Donaciones getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Donaciones donaciones) {
        this.donaciones = donaciones;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinventarios != null ? idinventarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventarios)) {
            return false;
        }
        Inventarios other = (Inventarios) object;
        if ((this.idinventarios == null && other.idinventarios != null) || (this.idinventarios != null && !this.idinventarios.equals(other.idinventarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Inventarios[ idinventarios=" + idinventarios + " ]";
    }

    public void setCantidad(int nuevaCantidadDisponible) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
