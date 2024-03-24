package Model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByNdocumento", query = "SELECT u FROM Usuarios u WHERE u.ndocumento = :ndocumento"),
    @NamedQuery(name = "Usuarios.findByContrase\u00f1a", query = "SELECT u FROM Usuarios u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuarios.findByNombredeusuario", query = "SELECT u FROM Usuarios u WHERE u.nombredeusuario = :nombredeusuario"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellido", query = "SELECT u FROM Usuarios u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuarios.findByEdad", query = "SELECT u FROM Usuarios u WHERE u.edad = :edad")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_documento")
    private Integer ndocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Contrase\u00f1a")
    private int contraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre_de_usuario")
    private String nombredeusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Edad")
    private int edad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosNdocumento")
    private Collection<Correo> correoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosNdocumento")
    private Collection<Telefono> telefonoCollection;
    @JoinColumn(name = "inventarios_Id_inventarios", referencedColumnName = "Id_inventarios")
    @ManyToOne(optional = false)
    private Inventarios inventariosIdinventarios;
    @JoinColumn(name = "novedades_Id_empleado", referencedColumnName = "Id_empleado")
    @ManyToOne(optional = false)
    private Novedades novedadesIdempleado;
    @JoinColumn(name = "roles_Id_roles", referencedColumnName = "Id_roles")
    @ManyToOne(optional = false)
    private Roles rolesIdroles;

    public Usuarios() {
    }

    public Usuarios(Integer ndocumento) {
        this.ndocumento = ndocumento;
    }

    public Usuarios(Integer ndocumento, int contraseña, String nombredeusuario, String nombre, String apellido, int edad) {
        this.ndocumento = ndocumento;
        this.contraseña = contraseña;
        this.nombredeusuario = nombredeusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getNdocumento() {
        return ndocumento;
    }

    public void setNdocumento(Integer ndocumento) {
        this.ndocumento = ndocumento;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombredeusuario() {
        return nombredeusuario;
    }

    public void setNombredeusuario(String nombredeusuario) {
        this.nombredeusuario = nombredeusuario;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public Inventarios getInventariosIdinventarios() {
        return inventariosIdinventarios;
    }

    public void setInventariosIdinventarios(Inventarios inventariosIdinventarios) {
        this.inventariosIdinventarios = inventariosIdinventarios;
    }

    public Novedades getNovedadesIdempleado() {
        return novedadesIdempleado;
    }

    public void setNovedadesIdempleado(Novedades novedadesIdempleado) {
        this.novedadesIdempleado = novedadesIdempleado;
    }

    public Roles getRolesIdroles() {
        return rolesIdroles;
    }

    public void setRolesIdroles(Roles rolesIdroles) {
        this.rolesIdroles = rolesIdroles;
    }

    // Método para obtener el tipo de rol del usuario
    public String getTipoRol() {
        if (rolesIdroles != null) {
            return rolesIdroles.getTipoRol();
        } else {
            return "";
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ndocumento != null ? ndocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.ndocumento == null && other.ndocumento != null) || (this.ndocumento != null && !this.ndocumento.equals(other.ndocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usuarios[ ndocumento=" + ndocumento + " ]";
    }
}