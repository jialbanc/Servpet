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
import static com.servpet.enums.Status.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Jimmy
 */
@ManagedBean(name = "citasDoctorManagedBean", eager = true)
@ViewScoped
public class CitasDoctorManagedBean {
    @EJB
    private Facades.UsuarioHasCitasFacadeLocal citas;
    private List<Entities.UsuarioHasCitas> ltCitasDoctor;
    @EJB
    private Facades.CitasFacadeLocal cita;
    private List<Entities.Citas> ltCitas;
    
    @EJB
    private Facades.UsuarioHasCitasFacadeLocal usuariocita;
    private List<Entities.Usuario> ltDoctores;
    
    @EJB
    private Facades.UsuarioFacadeLocal usuarioFacade;
    private List<Entities.Usuario> usuariosfiltrados;
    
    private String currentDoctor;
    private List<Entities.UsuarioHasCitas> ltUsuariosFromCita;
    
    private String selectedUserName;
    private String selectedUserCedula;
    private String selectedEmployeeName;

    
    private final int deltaMinutes=30;
    
    private ScheduleModel eventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        currentDoctor = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        eventModel = new DefaultScheduleModel();
        ltCitasDoctor = usuarioFacade.getUsuarioById(currentDoctor).getUsuarioHasCitasList();
        for (UsuarioHasCitas c : ltCitasDoctor){
            Citas cit=c.getIdcitas();
            if(cit.getEstado().equals(RESERVED.getReference()))
                eventModel.addEvent(new DefaultScheduleEvent(cit.getEstado(), getDateFromString(cit.getFecha(),cit.getHora()),getFinalDateFromString(cit.getFecha(),cit.getHora())));
        }
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

    public String getSelectedUserName() {
        return selectedUserName;
    }

    public void setSelectedUserName(String selectedUserName) {
        this.selectedUserName = selectedUserName;
    }

    public String getSelectedUserCedula() {
        return selectedUserCedula;
    }

    public void setSelectedUserCedula(String selectedUserCedula) {
        this.selectedUserCedula = selectedUserCedula;
    }

    public String getSelectedEmployeeName() {
        return selectedEmployeeName;
    }

    public void setSelectedEmployeeName(String selectedEmployeeName) {
        this.selectedEmployeeName = selectedEmployeeName;
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

    public void loadSchedule(){
        eventModel = new DefaultScheduleModel();
        ltCitasDoctor = usuarioFacade.getUsuarioById(currentDoctor).getUsuarioHasCitasList();
        for (UsuarioHasCitas c : ltCitasDoctor){
            Citas cit=c.getIdcitas();
            if(cit.getEstado().equals(RESERVED.getReference()))
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
     
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");
        String date = sdfDate.format(event.getEndDate());
        SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
        String hour = sdfHour.format(event.getStartDate());
        Entities.Citas c = cita.getUsuarioByHourDate(hour, date);
        ltUsuariosFromCita = c.getUsuarioHasCitasList();
        for(UsuarioHasCitas uc : ltUsuariosFromCita){
            Usuario u = uc.getIdusuario();
            if(isThisUser(u,CLIENT)){
                selectedUserName = u.getApellido()+' '+u.getNombre();
                selectedUserCedula = u.getCedula();
            }
            if(isThisUser(u, EMPLOYEE))
                selectedEmployeeName = u.getApellido()+' '+u.getNombre();
        }   
    }
    private boolean isThisUser(Usuario user, com.servpet.enums.Rol r){
        boolean state=false;
        if(user.getIdrol().getRol().equals(r.getReference()))
            state=true;
        return state;
    }
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
