/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Entities.Usuario;
import Facades.UsuarioFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jimmy
 */
@ManagedBean(name = "registroManagedBean", eager = true)
@ViewScoped
public class RegistroManagedBean {
    @EJB
    private Facades.UsuarioFacadeLocal usuarioFacade;    
    private List<Entities.Usuario> ltUsuarios ;
    /**
     * Creates a new instance of RegistroManagedBean
     */
    public RegistroManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        ltUsuarios = usuarioFacade.findAll();
    }
    
    public List<Usuario> getLtUsuarios() {
        return ltUsuarios;
    }

    public void setLtUsuarios(List<Usuario> ltUsuarios) {
        
        this.ltUsuarios = ltUsuarios;
    }
    
}
