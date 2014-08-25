/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Citas;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jimmy
 */
@Local
public interface UsuarioHasCitasFacadeLocal {

    void create(UsuarioHasCitas usuarioHasCitas);

    void edit(UsuarioHasCitas usuarioHasCitas);

    void remove(UsuarioHasCitas usuarioHasCitas);

    UsuarioHasCitas find(Object id);

    List<UsuarioHasCitas> findAll();

    List<UsuarioHasCitas> findRange(int[] range);

    int count();
    
    UsuarioHasCitas getUsuarioByUsuarioCitas(Usuario usuario, Citas cita);
}
