package Controller;

import EJB.InventariosFacadeLocal;
import Model.Inventarios;
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
public class InventarioController implements Serializable {
    
    @EJB
    private InventariosFacadeLocal ejbInventarios; 
    private Inventarios inventario;
    private List<Inventarios> listaInventarios;
    private String mensaje = "";

    public Inventarios getInventario() {
        return inventario;
    }

    public void setInventario(Inventarios inventario) {
        this.inventario = inventario;
    }

    public List<Inventarios> getListaInventarios() {
        this.listaInventarios = this.ejbInventarios.findAll();
        return listaInventarios;
    }

    public void setListaInventarios(List<Inventarios> listaInventarios) {
        this.listaInventarios = listaInventarios;
    }

    public InventariosFacadeLocal getEjbInventarios() {
        return ejbInventarios;
    }

    public void setEjbInventarios(InventariosFacadeLocal ejbInventarios) {
        this.ejbInventarios = ejbInventarios;
    }
    
    @PostConstruct
    public void init(){
        this.inventario = new Inventarios();
    }
    
    public void guardar(){
        try {
            this.ejbInventarios.create(inventario);
            this.inventario = new Inventarios();
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
            this.ejbInventarios.edit(inventario);
            this.inventario = new Inventarios();
            this.mensaje = "Actualizado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void eliminar(Inventarios i){
        try {
            this.ejbInventarios.remove(i);
            this.inventario = new Inventarios();
            this.mensaje = "Eliminado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error: " + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void cargarID(Inventarios i){
        this.inventario = i;
    }
    
    public void limpiar(){
        this.inventario = new Inventarios();
    }
}
