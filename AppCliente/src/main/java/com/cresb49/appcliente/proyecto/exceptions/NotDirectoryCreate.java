/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.proyecto.exceptions;

/**
 *
 * @author Benjamin
 */
public class NotDirectoryCreate extends Exception{

    public NotDirectoryCreate() {
    }
    
    public NotDirectoryCreate(String mensaje) {
        super(mensaje);
    }
}
