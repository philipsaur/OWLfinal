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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
    @NamedQuery(name = "Inscripcion.findByNumerodocumento", query = "SELECT i FROM Inscripcion i WHERE i.numerodocumento = :numerodocumento"),
    @NamedQuery(name = "Inscripcion.findByNombre", query = "SELECT i FROM Inscripcion i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Inscripcion.findByApellido", query = "SELECT i FROM Inscripcion i WHERE i.apellido = :apellido"),
    @NamedQuery(name = "Inscripcion.findByNacionalidad", query = "SELECT i FROM Inscripcion i WHERE i.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Inscripcion.findByFechanacimiento", query = "SELECT i FROM Inscripcion i WHERE i.fechanacimiento = :fechanacimiento")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_documento")
    private Integer numerodocumento;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "Nacionalidad")
    private String nacionalidad;
    @Column(name = "Fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @JoinColumn(name = "novedades_Id_empleado", referencedColumnName = "Id_empleado")
    @ManyToOne(optional = false)
    private Novedades novedadesIdempleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionNumerodocumento")
    private Collection<Correo> correoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionNumerodocumento")
    private Collection<Telefono> telefonoCollection;

    public Inscripcion() {
    }

    public Inscripcion(Integer numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Integer getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(Integer numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Novedades getNovedadesIdempleado() {
        return novedadesIdempleado;
    }

    public void setNovedadesIdempleado(Novedades novedadesIdempleado) {
        this.novedadesIdempleado = novedadesIdempleado;
    }

    @XmlTransient
    public Collection<Correo> getCorreoCollection() {
        return correoCollection;
    }

    public void setCorreoCollection(Collection<Correo> correoCollection) {
        this.correoCollection = correoCollection;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerodocumento != null ? numerodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.numerodocumento == null && other.numerodocumento != null) || (this.numerodocumento != null && !this.numerodocumento.equals(other.numerodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Inscripcion[ numerodocumento=" + numerodocumento + " ]";
    }
    
}
