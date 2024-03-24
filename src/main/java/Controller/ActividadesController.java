
package Controller;

import EJB.ActividadesFacadeLocal;
import Model.Actividades;
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
public class ActividadesController implements Serializable{
    
    @EJB
    private ActividadesFacadeLocal ejbActiviades;
    private Actividades activiades;
    private List<Actividades> listaActiviades;
    private String mensaje = "";


    public ActividadesFacadeLocal getEjbActiviades() {
        return ejbActiviades;
    }

    public void setEjbActiviades(ActividadesFacadeLocal ejbActiviades) {
        this.ejbActiviades = ejbActiviades;
    }

    public Actividades getActiviades() {
        return activiades;
    }

    public void setActiviades(Actividades activiades) {
        this.activiades = activiades;
    }

    public List<Actividades> getListaActiviades() {
        this.listaActiviades = this.ejbActiviades.findAll();
        return listaActiviades;
    }

    public void setListaActiviades(List<Actividades> listaActiviades) {
        this.listaActiviades = listaActiviades;
    }
    @PostConstruct
    public void init(){
        this.activiades = new Actividades();
    }
    public void guardar(){
        try {
            this.ejbActiviades.create(activiades);
            this.activiades = new Actividades();
            this.mensaje = "Almacenado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void actualizar(){
        try {
            this.ejbActiviades.edit(activiades);
            this.activiades = new Actividades();
            this.mensaje = "Actualizado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void eliminar(Actividades a){
        try {
            this.ejbActiviades.remove(activiades);
            this.mensaje = "Eliminado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void cargarID(Actividades a){
        this.activiades = a;
    }
    public void limpiar(){
        this.activiades = new Actividades();
    }
}
