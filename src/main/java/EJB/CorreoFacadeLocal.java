/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Model.Correo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface CorreoFacadeLocal {

    void create(Correo correo);

    void edit(Correo correo);

    void remove(Correo correo);

    Correo find(Object id);

    List<Correo> findAll();

    List<Correo> findRange(int[] range);

    int count();
    
}
