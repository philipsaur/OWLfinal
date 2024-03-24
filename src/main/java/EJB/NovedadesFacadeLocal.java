/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Model.Novedades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface NovedadesFacadeLocal {

    void create(Novedades novedades);

    void edit(Novedades novedades);

    void remove(Novedades novedades);

    Novedades find(Object id);

    List<Novedades> findAll();

    List<Novedades> findRange(int[] range);

    int count();
    
}
