/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Citas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jimmy
 */
@Stateless
public class CitasFacade extends AbstractFacade<Citas> implements CitasFacadeLocal {
    @PersistenceContext(unitName = "com.servpet_MavenPet-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitasFacade() {
        super(Citas.class);
    }
    
    @Override
    public Citas getUsuarioByHourDate(String hora, String fecha){
        return (Citas)em.createNamedQuery("Citas.findByHoraFecha").setParameter("hora",hora).setParameter("fecha", fecha).getSingleResult();
    }
    
}
