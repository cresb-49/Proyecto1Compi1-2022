package com.cresb49.appcliente.proyecto;

import java.io.Serializable;

public class ProyectoCopy implements Serializable{
    
    private String pathCarpeta1="";
    private String pathCarpeta2="";
    
    private String pathArchivDef="";
    private String pathCarpetaProyecto="";
    private String pathArchivoJson="";

    public String getPathCarpeta1() {
        return pathCarpeta1;
    }

    public void setPathCarpeta1(String pathCarpeta1) {
        this.pathCarpeta1 = pathCarpeta1;
    }

    public String getPathCarpeta2() {
        return pathCarpeta2;
    }

    public void setPathCarpeta2(String pathCarpeta2) {
        this.pathCarpeta2 = pathCarpeta2;
    }

    public String getPathArchivDef() {
        return pathArchivDef;
    }

    public void setPathArchivDef(String pathArchivDef) {
        this.pathArchivDef = pathArchivDef;
    }

    public String getPathCarpetaProyecto() {
        return pathCarpetaProyecto;
    }

    public void setPathCarpetaProyecto(String pathCarpetaProyecto) {
        this.pathCarpetaProyecto = pathCarpetaProyecto;
    }

    public String getPathArchivoJson() {
        return pathArchivoJson;
    }

    public void setPathArchivoJson(String pathArchivoJson) {
        this.pathArchivoJson = pathArchivoJson;
    }   

    @Override
    public String toString() {
        return "ProyectoCopy{" + "pathCarpeta1=" + pathCarpeta1 + ", pathCarpeta2=" + pathCarpeta2 + ", pathArchivDef=" + pathArchivDef + ", pathCarpetaProyecto=" + pathCarpetaProyecto + ", pathArchivoJson=" + pathArchivoJson + '}';
    }
    
}
