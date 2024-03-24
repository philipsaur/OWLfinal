/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Model.Incapacidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface IncapacidadFacadeLocal {

    void create(Incapacidad incapacidad);

    void edit(Incapacidad incapacidad);

    void remove(Incapacidad incapacidad);

    Incapacidad find(Object id);

    List<Incapacidad> findAll();

    List<Incapacidad> findRange(int[] range);

    int count();
    
}
