/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobrain.trips.core.backing;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author vsankara
 */
@Named(value = "backingHomePage")
@SessionScoped
public class BackingHomePage extends AbstractBackingMenuNavigation implements Serializable {

    /**
     * Creates a new instance of BackingHomePage
     */
    public BackingHomePage() {
    }
    
}
