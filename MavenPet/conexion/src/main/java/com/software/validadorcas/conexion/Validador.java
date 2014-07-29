/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.validadorcas.conexion;

import java.sql.ResultSet;
import java.sql.Statement;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
/**
 *
 * @author cesar20
 */
public class Validador extends AbstractUsernamePasswordAuthenticationHandler {
    public boolean authenticateUsernamePasswordInternal(UsernamePasswordCredentials credentials)  
      {  
        String username = credentials.getUsername();  
        String password = credentials.getPassword(); 
        boolean valid = false; 
        String statementPostgrasql = "select * from \"usuario\" where cedula = '"+username+"' and password = '"+password+"'";
            
        /*Connection con = null;  
        Statement sta = null;  
        ResultSet rs = null;  
          
          
        try {  
            //Establecemos la conexión con el datasource  
            Context initCtx = new InitialContext();  
            Context envCtx = (Context) initCtx.lookup("java:comp/env");  
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/democas");  
            con = dataSource.getConnection();  
            con.setAutoCommit(false);  
              
            //Instanciamos la sentencia  
            sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);  
              
            //Ejecutamos la query de validación  
            StringBuilder sql = new StringBuilder("SELECT USERNAME FROM USERS WHERE USERNAME = '").append(username).append("' AND PASSWORD ='").append(password).append("'");  
            rs = sta.executeQuery(sql.toString());  
              
            //Si el ResultSet tiene datos quiere decir que el usuario es válido  
            valid = rs.next();  
              
              
        } catch (ConfigurationException e) {  
            e.printStackTrace();  
        } catch (NamingException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                //Cerrramos la conexión  
                rs.close();  
                sta.close();  
                con.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  */
        try{
            ConexionPSql myDbTest = new ConexionPSql();
            Statement select = myDbTest.getConnection().createStatement();
            ResultSet result = select.executeQuery(statementPostgrasql);
            while (result.next()) {
                valid=true;
            }
        }
        catch(Exception Ex){
        }
        
          
        return valid;  
      }  
}
