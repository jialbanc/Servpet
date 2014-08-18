/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Entities.Citas;
import Entities.Rol;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "citasManagedBean", eager = true)
@RequestScoped
public class CitasManagedBean implements Serializable {
    
    @EJB
    private Facades.UsuarioHasCitasFacadeLocal citas;
    private List<Entities.UsuarioHasCitas> ltCitasDoctor;
    @EJB
    private Facades.CitasFacadeLocal cita;
    private List<Entities.Citas> ltCitas;
    
    @EJB
    private Facades.RolFacadeLocal rol;
    private List<Entities.Rol> ltRoles;
    
    private List<Entities.Usuario> ltDoctores;
    
    
     private Entities.Citas selCita;
    private Entities.Usuario selectedUser;
    private List<Entities.Usuario> usuariosfiltrados;
    
    private ScheduleModel eventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        
        ltRoles = rol.findAll();
        for (Rol r : ltRoles){
            if(r.getRol().equals("ROLE_DOCTOR"))
                ltDoctores = r.getUsuarioList();
        }
        /*ltCitas = cita.findAll();
        for (Citas c : ltCitas){
            eventModel.addEvent(new DefaultScheduleEvent(c.getMedicinas(), getDateFromString(c.getFecha(),c.getHora()),getFinalDateFromString(c.getFecha(),c.getHora())));
            System.out.println("1");
        }*/
    }
    
    public void initCalendar(){
        
    }
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
    
    public Date getDateFromString(String strdate,String strhour){
        try{
            Calendar date = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            date.setTime(sdf.parse(strdate+" "+strhour));
            date.setTimeZone(TimeZone.getTimeZone("GMT-5"));
            System.out.println(date);
            return date.getTime();
        }
        catch(ParseException pe){
            pe.printStackTrace();
        }
        return null;
    }
    public Date getFinalDateFromString(String strdate,String strhour){
        try{
            Calendar date = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            date.setTime(sdf.parse(strdate+" "+strhour));
            date.set(Calendar.MINUTE,date.get(Calendar.MINUTE)+30);
            return date.getTime();
        }
        catch(ParseException pe){
            pe.printStackTrace();
        }
        return null;
    }

    public List<Citas> getLtCitas() {
        return ltCitas;
    }

    public void setLtCitas(List<Citas> ltCitas) {
        this.ltCitas = ltCitas;
    }

    public List<Usuario> getLtDoctores() {
        return ltDoctores;
    }

    public void setLtDoctores(List<Usuario> ltDoctores) {
        this.ltDoctores = ltDoctores;
    }

    public Usuario getSelectedUser() {
        
        return selectedUser;
    }

    public void setSelectedUser(Usuario selectedUser) {
        eventModel = new DefaultScheduleModel();
        ltCitasDoctor = selectedUser.getUsuarioHasCitasList();
        for (UsuarioHasCitas c : ltCitasDoctor){
            Citas cit=c.getIdcitas();
            eventModel.addEvent(new DefaultScheduleEvent(cit.getMedicinas(), getDateFromString(cit.getFecha(),cit.getHora()),getFinalDateFromString(cit.getFecha(),cit.getHora())));
        }
        this.selectedUser = selectedUser;
    }

    public Citas getSelCita() {
        return selCita;
    }

    public void setSelCita(Citas selCita) {
        this.selCita = selCita;
    }

    public List<Usuario> getUsuariosfiltrados() {
        return usuariosfiltrados;
    }

    public void setUsuariosfiltrados(List<Usuario> usuariosfiltrados) {
        this.usuariosfiltrados = usuariosfiltrados;
    }

    public List<UsuarioHasCitas> getLtCitasDoctor() {
        return ltCitasDoctor;
    }

    public void setLtCitasDoctor(List<UsuarioHasCitas> ltCitasDoctor) {
        this.ltCitasDoctor = ltCitasDoctor;
    }
    
    public ScheduleModel getEventModel() {
        
        return eventModel;
    }
 
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
