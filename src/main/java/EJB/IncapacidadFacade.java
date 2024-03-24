/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Model.Incapacidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author julia
 */
@Stateless
public class IncapacidadFacade extends AbstractFacade<Incapacidad> implements IncapacidadFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_OWL1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncapacidadFacade() {
        super(Incapacidad.class);
    }
    
}
