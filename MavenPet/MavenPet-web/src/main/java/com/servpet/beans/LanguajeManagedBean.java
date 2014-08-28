/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author gianella
 */
@Named(value = "languajeManagedBean")
@RequestScoped
public class LanguajeManagedBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
 
	private String localeCode;
 
	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("Español", Locale.ENGLISH); //label, value
		countries.put("Chinese", Locale.SIMPLIFIED_CHINESE);
	}
 
	public Map<String, Object> getCountriesInMap() {
		return countries;
	}
 
 
	public String getLocaleCode() {
		return localeCode;
	}
 
 
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
 
	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){
 
		String newLocaleValue = e.getNewValue().toString();
 
		//loop country map to compare the locale code
                for (Map.Entry<String, Object> entry : countries.entrySet()) {
 
        	   if(entry.getValue().toString().equals(newLocaleValue)){
 
        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());
 
        	  }
               }
	}
 
}
