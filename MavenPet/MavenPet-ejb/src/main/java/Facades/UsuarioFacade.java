/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jimmy
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "com.servpet_MavenPet-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario getUsuarioById(String userId){
        return (Usuario)em.createNamedQuery("Usuario.findByCedula").setParameter("cedula",userId).getSingleResult();
    }
      
    public Usuario getUsuarioByIdRol(String idRol){
        return (Usuario) em.createNamedQuery("Usuario.").setParameter("idrol",idRol).getSingleResult();
    }
}
