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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a"),
    @NamedQuery(name = "Actividades.findByIdactividades", query = "SELECT a FROM Actividades a WHERE a.idactividades = :idactividades"),
    @NamedQuery(name = "Actividades.findByNombreinstructor", query = "SELECT a FROM Actividades a WHERE a.nombreinstructor = :nombreinstructor"),
    @NamedQuery(name = "Actividades.findByFechaactividad", query = "SELECT a FROM Actividades a WHERE a.fechaactividad = :fechaactividad"),
    @NamedQuery(name = "Actividades.findByNombreactividad", query = "SELECT a FROM Actividades a WHERE a.nombreactividad = :nombreactividad")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_actividades")
    private Integer idactividades;
    @Size(max = 45)
    @Column(name = "Nombre_instructor")
    private String nombreinstructor;
    @Column(name = "Fecha_actividad")
    @Temporal(TemporalType.DATE)
    private Date fechaactividad;
    @Size(max = 45)
    @Column(name = "Nombre_actividad")
    private String nombreactividad;
    @JoinColumn(name = "novedades_Id_empleado", referencedColumnName = "Id_empleado")
    @ManyToOne(optional = false)
    private Novedades novedadesIdempleado;

    public Actividades() {
    }

    public Actividades(Integer idactividades) {
        this.idactividades = idactividades;
    }

    public Integer getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(Integer idactividades) {
        this.idactividades = idactividades;
    }

    public String getNombreinstructor() {
        return nombreinstructor;
    }

    public void setNombreinstructor(String nombreinstructor) {
        this.nombreinstructor = nombreinstructor;
    }

    public Date getFechaactividad() {
        return fechaactividad;
    }

    public void setFechaactividad(Date fechaactividad) {
        this.fechaactividad = fechaactividad;
    }

    public String getNombreactividad() {
        return nombreactividad;
    }

    public void setNombreactividad(String nombreactividad) {
        this.nombreactividad = nombreactividad;
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
        hash += (idactividades != null ? idactividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.idactividades == null && other.idactividades != null) || (this.idactividades != null && !this.idactividades.equals(other.idactividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Actividades[ idactividades=" + idactividades + " ]";
    }
    
}
