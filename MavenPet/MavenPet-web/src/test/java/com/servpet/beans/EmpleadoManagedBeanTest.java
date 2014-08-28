/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Rol;
import Entities.Usuario;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author gianella
 */
public class EmpleadoManagedBeanTest {
    
    public EmpleadoManagedBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

  


    /**
     * Test of setMensaje method, of class EmpleadoManagedBean.
     */
    @Test
    public void testSetMensaje() {
        System.out.println("setMensaje");
        String mensaje = "hoolla";
        EmpleadoManagedBean instance = new EmpleadoManagedBean();
        instance.setMensaje(mensaje);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

  
    @Test
    public void testSetAsunto() {
        System.out.println("setAsunto");
        String asunto = "como esta";
        EmpleadoManagedBean instance = new EmpleadoManagedBean();
        instance.setAsunto(asunto);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of imp method, of class EmpleadoManagedBean.
     */
    @Test
    public void testImp() {
        System.out.println("imp");
        EmpleadoManagedBean instance = new EmpleadoManagedBean();
//        instance.imp();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
