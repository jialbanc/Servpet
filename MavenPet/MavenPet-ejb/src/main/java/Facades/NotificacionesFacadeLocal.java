/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Notificaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jimmy
 */
@Local
public interface NotificacionesFacadeLocal {

    void create(Notificaciones notificaciones);

    void edit(Notificaciones notificaciones);

    void remove(Notificaciones notificaciones);

    Notificaciones find(Object id);

    List<Notificaciones> findAll();

    List<Notificaciones> findRange(int[] range);

    int count();
    
}
