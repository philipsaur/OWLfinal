/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Model.Donaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface DonacionesFacadeLocal {

    void create(Donaciones donaciones);

    void edit(Donaciones donaciones);

    void remove(Donaciones donaciones);

    Donaciones find(Object id);

    List<Donaciones> findAll();

    List<Donaciones> findRange(int[] range);

    int count();
    
}
