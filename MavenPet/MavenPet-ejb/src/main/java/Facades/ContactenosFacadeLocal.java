/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Contactenos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gianella
 */
@Local
public interface ContactenosFacadeLocal {

    void create(Contactenos contactenos);

    void edit(Contactenos contactenos);

    void remove(Contactenos contactenos);

    Contactenos find(Object id);

    List<Contactenos> findAll();

    List<Contactenos> findRange(int[] range);

    int count();
    
}
