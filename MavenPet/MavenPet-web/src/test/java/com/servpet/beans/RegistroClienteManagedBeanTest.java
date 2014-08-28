/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Rol;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gianella
 */
public class RegistroClienteManagedBeanTest {
    
    public RegistroClienteManagedBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of init method, of class RegistroClienteManagedBean.
     */
  

 
    /**
     * Test of setRolcliente method, of class RegistroClienteManagedBean.
     */
    @org.junit.Test
    public void testSetRolcliente() {
        System.out.println("setRolcliente");
        Rol rolcliente = null;
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setRolcliente(rolcliente);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   
    /**
     * Test of setNombre method, of class RegistroClienteManagedBean.
     */
    @org.junit.Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "carol";
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class RegistroClienteManagedBean.
     */
 
    @org.junit.Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "revelo";
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getCedula method, of class RegistroClienteManagedBean.
     */
   
    /**
     * Test of setCedula method, of class RegistroClienteManagedBean.
     */
    @org.junit.Test
    public void testSetCedula() {
        System.out.println("setCedula");
        String cedula = "091228881";
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setCedula(cedula);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class RegistroClienteManagedBean.
     */
    
    /**
     * Test of setPassword method, of class RegistroClienteManagedBean.
     */
    @org.junit.Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "hola";
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    /**
     * Test of setEmail method, of class RegistroClienteManagedBean.
     */
    @org.junit.Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "vanessa@gmail.com";
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class RegistroClienteManagedBean.
     */
   
    /**
     * Test of setDireccion method, of class RegistroClienteManagedBean.
     */
    @org.junit.Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "sauces7";
        RegistroClienteManagedBean instance = new RegistroClienteManagedBean();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
