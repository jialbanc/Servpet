/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author gianella
 */
@ManagedBean(name = "car")
@ApplicationScoped

public class Car {
        private String id;
        private int year;
        private String manufacturer;
        private String color;
        private final static String[] brand;
        
     static {
        brand = new String[10];
        brand[0] = "BMW";
        brand[1] = "Mercedes";
        brand[2] = "Volvo";
        brand[3] = "Audi";
        brand[4] = "Renault";
        brand[5] = "Fiat";
        brand[6] = "Volkswagen";
        brand[7] = "Honda";
        brand[8] = "Jaguar";
        brand[9] = "Ford";
    }
        
        public Car(String id, int year, String manufacturer, String color) {
                this.id = id;
                this.year = year;
                this.manufacturer = manufacturer;
                this.color = color;
        }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

       

        public int getYear() {
                return year;
        }

        public void setYear(int year) {
                this.year = year;
        }

        public String getManufacturer() {
                return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
                this.manufacturer = manufacturer;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

    public static String[] getBrand() {
        return brand;
    }
       
    
}

