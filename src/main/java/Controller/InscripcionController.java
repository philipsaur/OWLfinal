
package Controller;

import EJB.InscripcionFacadeLocal;
import Model.Inscripcion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class InscripcionController implements Serializable{
    
    @EJB
    private InscripcionFacadeLocal ejbInscrip;
    private Inscripcion inscripcion;
    private List<Inscripcion> listaInscripcion;
    private String mensaje = "";


    
    
    public InscripcionFacadeLocal getEjbInscrip() {
        return ejbInscrip;
    }

    public void setEjbInscrip(InscripcionFacadeLocal ejbInscrip) {
        this.ejbInscrip = ejbInscrip;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Inscripcion> getListaInscripcion() {
        this.listaInscripcion = this.ejbInscrip.findAll();
        return listaInscripcion;
    }

    public void setListaInscripcion(List<Inscripcion> listaInscripcion) {
        this.listaInscripcion = listaInscripcion;
    }
    
    @PostConstruct
    public void init(){
        this.inscripcion = new Inscripcion();
        
    }
    public void guardar(){
        try {
            this.ejbInscrip.create(inscripcion);
            this.inscripcion = new Inscripcion();
            this.mensaje = "Almacenado con exito";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void actualizar(){
        try {
            this.ejbInscrip.edit(inscripcion);
            this.inscripcion = new Inscripcion();
            this.mensaje = "Actualizado con exito";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void eliminar(Inscripcion i){
        try {
            this.ejbInscrip.remove(inscripcion);
            this.inscripcion = new Inscripcion();
            this.mensaje = "Eliminado con exito";
            
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void cargarID(Inscripcion i){
        this.inscripcion = i;
    }
    public void limpiar(){
        this.inscripcion = new Inscripcion();
    }
}
