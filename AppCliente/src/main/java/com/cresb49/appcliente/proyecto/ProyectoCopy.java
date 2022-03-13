package com.cresb49.appcliente.proyecto;

import java.io.File;
import java.io.Serializable;

public class ProyectoCopy implements Serializable{
    private File carpeta1;
    private File carpeta2;

    private File archivDef;
    private File archivoJson;

    public ProyectoCopy(){

    }
    
    public ProyectoCopy(File carpeta1,File carpeta2){
        this.carpeta1 = carpeta1;
        this.carpeta2 = carpeta2;
    }

    /**
     * @return the archivDef
     */
    public File getArchivDef() {
        return archivDef;
    }
    /**
     * @return the archivoJson
     */
    public File getArchivoJson() {
        return archivoJson;
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
     * @param archivDef the archivDef to set
     */
    public void setArchivDef(File archivDef) {
        this.archivDef = archivDef;
    }
    /**
     * @param archivoJson the archivoJson to set
     */
    public void setArchivoJson(File archivoJson) {
        this.archivoJson = archivoJson;
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
