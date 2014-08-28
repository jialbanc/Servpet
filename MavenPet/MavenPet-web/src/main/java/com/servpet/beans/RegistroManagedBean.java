/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Rol;
import Entities.Usuario;
import static com.servpet.enums.Rol.*;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author gianella
 */
@ManagedBean(name = "registroManagedBean", eager = true)
@RequestScoped
public class RegistroManagedBean {

    /**
     * Creates a new instance of RegistroManagedBean
     */
    @EJB
    private Facades.RolFacadeLocal rolFacade;
    @EJB
    private Facades.UsuarioFacadeLocal usuario;
    
    private Entities.Rol rolDoctor;
    private Entities.Rol rolEmpleado;
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String password;
    private String email;
    private String direccion;
    private Integer idrol;
    
    @PostConstruct
    public void init(){
        for(Rol r : rolFacade.findAll()){
            if(r.getRol().equals(DOCTOR.getReference()))
                rolDoctor = r;
            if(r.getRol().equals(EMPLOYEE.getReference()))
                rolEmpleado = r;
        }
    }
    
    public RegistroManagedBean() {
    }

    public Rol getRolDoctor() {
        return rolDoctor;
    }

    public void setRolDoctor(Rol rolDoctor) {
        this.rolDoctor = rolDoctor;
    }

    public Rol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Rol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public void nuevoE(){
       password=(String.valueOf(apellido.hashCode()));     
       System.out.println(nombre);
       System.out.println(apellido+":"+cedula+":"+direccion+":"+email+":"+idrol);
       usuario.create(new Usuario(cedula, nombre, apellido, email, password, direccion, (rolFacade.getRolByIdRol(idrol))));
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Registro Exitoso", "De: "+apellido ) );
        envio(password, email);
       setApellido("");
       setCedula("");
       setDireccion("");
       setEmail("");
       setIdrol(0);
       setPassword("");
       setNombre("");
    }
    public void envio(String password, String email){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication("vanessagia91@gmail.com", "Sirenita0915");
            }
        });
        session.setDebug(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje Enviado", "Su SMensaje ha sido Enviado"));
       // notificaciones.create(new Notificaciones("125",citas.getIdByIdCitas("1"), "10:40","10/20/12", fot.getFileName(), mensaje, asunto));
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vanessagia91@gmail.com")); //Remetente
            Address[] toUser = InternetAddress.parse(email+", chiquita_gianella@hotmail.com, vanessarevelo@ymail.com");  
            BodyPart texto = new MimeBodyPart();
            texto.setText("Su Password es:"+password);
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Indicacion de Password para el Sistema");//Asunto
            message.setContent(multiParte);
            Transport.send(message);
            System.out.println("Mensaje Enviado!!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        
    
    }
    
}
