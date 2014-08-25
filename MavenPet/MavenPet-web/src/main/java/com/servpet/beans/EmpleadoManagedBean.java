/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;



import Entities.Notificaciones;
import Entities.Rol;
import Entities.Usuario;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
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
import org.primefaces.model.UploadedFile;


/**
 *
 * @author gianella
 */

@ManagedBean(name = "empleadoManagedBean", eager = true)
@RequestScoped
public class EmpleadoManagedBean {

    /**
     * Creates a new instance of EmpleadoManagedBean
     */
    
    @EJB
    private Facades.RolFacadeLocal roles;
    @EJB
    private Facades.CitasFacadeLocal citas;
    @EJB
    private Facades.NotificacionesFacadeLocal notificaciones;
    private List<Entities.Rol> ltroles;
    private List<Entities.Usuario> ltEmpleados;
    private String SelectUsuario;
    private String asunto;
    private String mensaje;
    private UploadedFile fot;
    
    @PostConstruct
    public void init(){
        ltroles= roles.findAll();
        for (Rol r : ltroles){
            if(r.getRol().equals("ROLE_CLIENT"))
                ltEmpleados = r.getUsuarioList();
        }
    }
    public EmpleadoManagedBean() {
    }

    public UploadedFile getFot() {
        return fot;
    }

    public void setFot(UploadedFile fot) {
        this.fot = fot;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public List<Usuario> getLtEmpleados() {
        return ltEmpleados;
    }

    public void setLtEmpleados(List<Usuario> ltEmpleados) {
        this.ltEmpleados = ltEmpleados;
    }

    public String getSelectUsuario() {
        return SelectUsuario;
    }

    public void setSelectUsuario(String SelectUsuario) {
        this.SelectUsuario = SelectUsuario;
    }

    public List<Rol> getLtroles() {
        return ltroles;
    }

    public void setLtroles(List<Rol> ltroles) {
        this.ltroles = ltroles;
    }
    
    public void imp(){
        System.out.println(SelectUsuario+":"+asunto+"-"+mensaje+";"+fot.getFileName());
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
            Address[] toUser = InternetAddress.parse(SelectUsuario+", chiquita_gianella@hotmail.com, vanessarevelo@ymail.com");  
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/"+fot.getFileName())));
            adjunto.setFileName(fot.getFileName());
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(asunto);//Asunto
            message.setContent(multiParte);
            Transport.send(message);
            System.out.println("Mensaje Enviado!!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
         
           setAsunto("");
           setMensaje("");
           setSelectUsuario("");
           
            
    }
    
   
   
}

