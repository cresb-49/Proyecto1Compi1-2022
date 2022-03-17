package com.cresb49.appcliente.Objetos;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class CompararProyectos implements Serializable{
    File carpeta1;
    File carpeta2;
    public CompararProyectos(){
    }
    public CompararProyectos(File carpeta1,File carpeta2){
        this.carpeta1 = carpeta1;
        this.carpeta2 = carpeta2;
    }
    /**
     * @return the carpeta1
     */
    public File getCarpeta1() {
        return carpeta1;
    }
    /**
     * @return the carpeta2
     */
    public File getCarpeta2() {
        return carpeta2;
    }
    /**
     * @param carpeta1 the carpeta1 to set
     */
    public void setCarpeta1(File carpeta1) {
        this.carpeta1 = carpeta1;
    }
    /**
     * @param carpeta2 the carpeta2 to set
     */
    public void setCarpeta2(File carpeta2) {
        this.carpeta2 = carpeta2;
    }
}
