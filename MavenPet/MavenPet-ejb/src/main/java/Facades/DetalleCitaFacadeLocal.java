/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facades;

import Entities.DetalleCita;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gianella
 */
@Local
public interface DetalleCitaFacadeLocal {

    void create(DetalleCita detalleCita);

    void edit(DetalleCita detalleCita);

    void remove(DetalleCita detalleCita);

    DetalleCita find(Object id);

    List<DetalleCita> findAll();

    List<DetalleCita> findRange(int[] range);

    int count();
    
}
