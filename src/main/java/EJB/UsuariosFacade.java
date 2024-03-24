/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Model.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author julia
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_OWL1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    @Override
    public Usuarios acceder(Usuarios us){
        Usuarios usuarios =null;
        String consulta="";
        try {
            consulta="select u from Usuarios u where u.nombredeusuario=?1 and u.contraseña=?2";
            Query query=em.createQuery(consulta);
            query.setParameter(1, us.getNombredeusuario());
            query.setParameter(2, us.getContraseña());
            
            List<Usuarios> lista= query.getResultList();
            if(!lista.isEmpty()){
                usuarios = lista.get(0);
            }
        } catch (Exception e) {
            throw e;    
        }
        return usuarios;
    }
    
}
