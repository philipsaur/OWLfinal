
package Controller;

import EJB.IncapacidadFacadeLocal;
import Model.Incapacidad;
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
public class IncapacidadController implements Serializable{
    
    @EJB
    private IncapacidadFacadeLocal EJBincapacidad;
    private Incapacidad incapacidad;
    private List<Incapacidad> listaincapacidad;
    String mensaje = "";

    public IncapacidadFacadeLocal getEJBincapacidad() {
        return EJBincapacidad;
    }

    public void setEJBincapacidad(IncapacidadFacadeLocal EJBincapacidad) {
        this.EJBincapacidad = EJBincapacidad;
    }

    public Incapacidad getIncapacidad() {
        return incapacidad;
    }

    public void setIncapacidad(Incapacidad incapacidad) {
        this.incapacidad = incapacidad;
    }

    public List<Incapacidad> getListaincapacidad() {
        this.listaincapacidad = this.EJBincapacidad.findAll();
        return listaincapacidad;
    }

    public void setListaincapacidad(List<Incapacidad> listaincapacidad) {
        this.listaincapacidad = listaincapacidad;
    }
    
    @PostConstruct
    public void init(){
        this.incapacidad = new Incapacidad();
    }
    
    public void guardar(){
        try {
            this.EJBincapacidad.create(incapacidad);
            this.incapacidad = new Incapacidad();
            this.mensaje = "Almacenado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error :" +e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void actualizar(){
        try {
            this.EJBincapacidad.edit(incapacidad);
            this.incapacidad = new Incapacidad();
            this.mensaje = "Actualizado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error :" +e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Incapacidad i){
        try {
            this.EJBincapacidad.remove(incapacidad);
            this.incapacidad = new Incapacidad();
            this.mensaje = "Eliminado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error :" +e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Incapacidad i){
        this.incapacidad = i;
    }
    public void limpiar(){
        this.incapacidad = new Incapacidad();
    }
}
