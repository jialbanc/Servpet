/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Jimmy
 */
@Named(value = "imagesView")
@Dependent
public class ImagesView {

    /**
     * Creates a new instance of ImagesView
     */
     private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("nature" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
}
