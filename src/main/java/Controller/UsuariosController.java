package Controller;

import EJB.UsuariosFacadeLocal;
import Model.Roles;
import Model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuariosController implements Serializable {
    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private List<Usuarios> listaUsuarios;
    private Roles rol;
    private Usuarios usuarios;

    public List<Usuarios> getListaUsuarios() {
        this.listaUsuarios = this.usuariosFacade.findAll();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    @PostConstruct
    public void init(){
        this.usuarios = new Usuarios();
        this.rol = new Roles();
    }
    
    public String validar() {
        Usuarios us;
        String ruta = "";

        try {
            us = this.usuariosFacade.acceder(this.usuarios);
            if (us != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext externalContext = context.getExternalContext();
                String paginaDestino = "";

                switch (us.getRolesIdroles().getTipoRol()) {
                    case "administrador":
                        paginaDestino = "/views/OWLInicio.xhtml";
                        break;
                    case "secretaria":
                        paginaDestino = "/views/OWLInicioR.xhtml";
                        break;

                    default:
                        paginaDestino = "/views/Inicio.xhtml";
                        break;
                }

                externalContext.getSessionMap().put("usuarios", us);
                ruta = paginaDestino + "?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Admin"));
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return ruta;
    }
}