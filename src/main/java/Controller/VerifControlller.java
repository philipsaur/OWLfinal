


package Controller;

import Model.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named
@ViewScoped
public class VerifControlller implements Serializable{
    
    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuarios us = (Usuarios) context.getExternalContext().getSessionMap().get("usuarios");

            if (us == null) {
                context.getExternalContext().redirect("./index.xhtml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
