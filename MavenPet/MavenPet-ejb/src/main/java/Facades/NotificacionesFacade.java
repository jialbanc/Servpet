/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Notificaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gianella
 */
@Stateless
public class NotificacionesFacade extends AbstractFacade<Notificaciones> implements NotificacionesFacadeLocal {
    @PersistenceContext(unitName = "com.servpet_MavenPet-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificacionesFacade() {
        super(Notificaciones.class);
    }
    
}
