/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.Mascotas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gianella
 */
@Local
public interface MascotasFacadeLocal {

    void create(Mascotas mascotas);

    void edit(Mascotas mascotas);

    void remove(Mascotas mascotas);

    Mascotas find(Object id);

    List<Mascotas> findAll();

    List<Mascotas> findRange(int[] range);

    int count();
    
}
