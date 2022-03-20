package com.cresb49.appcliente.Objetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{
    
    private String nombreCarpeta1;
    ArrayList<FileJava> carpeta1;
    private String nombreCarpeta2;
    ArrayList<FileJava> carpeta2;
    /**
     * @param carpeta1
     * @param carpeta2
     */
    public Proyecto(ArrayList<FileJava> carpeta1, ArrayList<FileJava> carpeta2) {
        this.carpeta1 = carpeta1;
        this.carpeta2 = carpeta2;
    }
    public Proyecto() {
    }
    /**
     * @return the carpeta1
     */
    public ArrayList<FileJava> getCarpeta1() {
        return carpeta1;
    }
    /**
     * @param carpeta1 the carpeta1 to set
     */
    public void setCarpeta1(ArrayList<FileJava> carpeta1) {
        this.carpeta1 = carpeta1;
    }
    /**
     * @return the carpeta2
     */
    public ArrayList<FileJava> getCarpeta2() {
        return carpeta2;
    }
    /**
     * @param carpeta2 the carpeta2 to set
     */
    public void setCarpeta2(ArrayList<FileJava> carpeta2) {
        this.carpeta2 = carpeta2;
    }
    /**
     * @return the nombreCarpeta1
     */
    public String getNombreCarpeta1() {
        return nombreCarpeta1;
    }
    /**
     * @param nombreCarpeta1 the nombreCarpeta1 to set
     */
    public void setNombreCarpeta1(String nombreCarpeta1) {
        this.nombreCarpeta1 = nombreCarpeta1;
    }
    /**
     * @return the nombreCarpeta2
     */
    public String getNombreCarpeta2() {
        return nombreCarpeta2;
    }
    /**
     * @param nombreCarpeta2 the nombreCarpeta2 to set
     */
    public void setNombreCarpeta2(String nombreCarpeta2) {
        this.nombreCarpeta2 = nombreCarpeta2;
    }
    
}
