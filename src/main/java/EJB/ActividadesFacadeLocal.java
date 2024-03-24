/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Model.Actividades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface ActividadesFacadeLocal {

    void create(Actividades actividades);

    void edit(Actividades actividades);

    void remove(Actividades actividades);

    Actividades find(Object id);

    List<Actividades> findAll();

    List<Actividades> findRange(int[] range);

    int count();
    
}
