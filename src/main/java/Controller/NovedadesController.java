package Controller;

import EJB.NovedadesFacadeLocal;
import Model.Novedades;
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
public class NovedadesController implements Serializable{
    
    @EJB
    private NovedadesFacadeLocal EJBnovedades; 
    private Novedades novedades;
    private List<Novedades> listanovedad;
    String mensaje = "";


    public Novedades getNovedades() {
        return novedades;
    }

    public void setNovedades(Novedades novedades) {
        this.novedades = novedades;
    }

    public List<Novedades> getListanovedad() {
        this.listanovedad = this.EJBnovedades.findAll();
        return listanovedad;
    }

    public void setListanovedad(List<Novedades> listanovedad) {
        this.listanovedad = listanovedad;
    }

    public NovedadesFacadeLocal getEJBnovedades() {
        return EJBnovedades;
    }

    public void setEJBnovedades(NovedadesFacadeLocal EJBnovedades) {
        this.EJBnovedades = EJBnovedades;
    }
    
    @PostConstruct
    public void init(){
        this.novedades = new Novedades();
    }
    public void guardar(){
        try {
            this.EJBnovedades.create(novedades);
            this.novedades = new Novedades();
            this.mensaje = "Almacenado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error :" +e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void actualizar(){
        try {
            this.EJBnovedades.edit(novedades);
            this.novedades = new Novedades();
            this.mensaje = "Actualizado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error :" +e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Novedades n){
        try {
            this.EJBnovedades.remove(n);
            this.novedades = new Novedades();
            this.mensaje = "Eliminado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error :" +e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Novedades n){
        this.novedades = n;
    }
    public void limpiar(){
        this.novedades = new Novedades();
    }
}
