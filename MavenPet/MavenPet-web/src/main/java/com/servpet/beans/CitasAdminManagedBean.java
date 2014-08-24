/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Citas;
import Entities.Rol;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import static com.servpet.enums.Rol.*;
import com.servpet.enums.Status;
import static com.servpet.enums.Status.*;
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
import javax.faces.bean.ViewScoped;
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
@ManagedBean(name = "citasAdminManagedBean", eager = true)
@ViewScoped
public class CitasAdminManagedBean implements Serializable {
    
    @EJB
    private Facades.UsuarioHasCitasFacadeLocal citas;
    private List<Entities.UsuarioHasCitas> ltCitasDoctor;
    @EJB
    private Facades.CitasFacadeLocal cita;
    private List<Entities.Citas> ltCitas;
    
    @EJB
    private Facades.RolFacadeLocal rol;
    private List<Entities.Rol> ltRoles;
    
    @EJB
    private Facades.UsuarioHasCitasFacadeLocal usuariocita;
    private List<Entities.Usuario> ltDoctores;
    
    private Entities.Usuario selectedUser;
    private List<Entities.Usuario> usuariosfiltrados;
    
    private final int deltaMinutes=30;
    
    private ScheduleModel eventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        
        ltRoles = rol.findAll();
        for (Rol r : ltRoles){
            if(r.getRol().equals(DOCTOR.getReference()))
                ltDoctores = r.getUsuarioList();
        }
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
            date.setTime(addDeltaMinutesToDate(sdf.parse(strdate+" "+strhour), deltaMinutes));
            return date.getTime();
        }
        catch(ParseException pe){
            pe.printStackTrace();
        }
        return null;
    }
    
    public Date addDeltaMinutesToDate(Date inDate, int delta){
        Calendar date = Calendar.getInstance();
        date.setTime(inDate);
        date.set(Calendar.MINUTE,date.get(Calendar.MINUTE)+delta);
        return date.getTime();
    }

    public int getDeltaMinutes() {
        return deltaMinutes;
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
        loadSchedule(selectedUser);
        this.selectedUser = selectedUser;
    }
    public void loadSchedule(Usuario selected){
        eventModel = new DefaultScheduleModel();
        ltCitasDoctor = selected.getUsuarioHasCitasList();
        for (UsuarioHasCitas c : ltCitasDoctor){
            Citas cit=c.getIdcitas();
            if(cit.getEstado().equals(AVAILABLE.getReference()))
                eventModel.addEvent(new DefaultScheduleEvent(cit.getEstado(), getDateFromString(cit.getFecha(),cit.getHora()),getFinalDateFromString(cit.getFecha(),cit.getHora())));
        }
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
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");
        String date = sdfDate.format(event.getEndDate());
        SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
        String hour = sdfHour.format(event.getStartDate());
        Entities.Citas c = new Citas(date,hour,event.getTitle());
        cita.create(c);
        Entities.UsuarioHasCitas uc = new UsuarioHasCitas(selectedUser,c);
        usuariocita.create(uc);
        event = new DefaultScheduleEvent();
        loadSchedule(selectedUser);
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent(AVAILABLE.getReference(), (Date) selectEvent.getObject(), addDeltaMinutesToDate((Date) selectEvent.getObject(),deltaMinutes));
    }
    
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
    
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
