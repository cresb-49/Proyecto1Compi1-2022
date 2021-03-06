package com.cresb49.appcliente.analizadores.filecopy.obj;

import java.io.Serializable;
import java.util.Objects;

/**
 * FileCopy
 */
public class FileCopy implements Serializable{
    
    private String pathProyecto1;
    private String pathProyecto2;
    private String pathFileDef;
    private String pathFileReporteJson;
    
    public FileCopy(){

    }

    public FileCopy(String pathProyecto1, String pathProyecto2, String pathFileDef, String pathFileReporteJson) {
        this.pathProyecto1 = pathProyecto1;
        this.pathProyecto2 = pathProyecto2;
        this.pathFileDef = pathFileDef;
        this.pathFileReporteJson = pathFileReporteJson;
    }

    public String getPathProyecto1() {
        return pathProyecto1;
    }

    public void setPathProyecto1(String pathProyecto1) {
        this.pathProyecto1 = pathProyecto1;
    }

    public String getPathProyecto2() {
        return pathProyecto2;
    }

    public void setPathProyecto2(String pathProyecto2) {
        this.pathProyecto2 = pathProyecto2;
    }

    public String getPathFileDef() {
        return pathFileDef;
    }

    public void setPathFileDef(String pathFileDer) {
        this.pathFileDef = pathFileDer;
    }

    public String getPathFileReporteJson() {
        return pathFileReporteJson;
    }

    public void setPathFileReporteJson(String pathFileReporteJson) {
        this.pathFileReporteJson = pathFileReporteJson;
    }

    @Override
    public String toString() {
        return "FileCopy{" + "pathProyecto1=" + pathProyecto1 + ", pathProyecto2=" + pathProyecto2 + ", pathFileDef=" + pathFileDef + ", pathFileReporteJson=" + pathFileReporteJson + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.pathProyecto1);
        hash = 71 * hash + Objects.hashCode(this.pathProyecto2);
        hash = 71 * hash + Objects.hashCode(this.pathFileDef);
        hash = 71 * hash + Objects.hashCode(this.pathFileReporteJson);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileCopy other = (FileCopy) obj;
        if (!Objects.equals(this.pathProyecto1, other.pathProyecto1)) {
            return false;
        }
        if (!Objects.equals(this.pathProyecto2, other.pathProyecto2)) {
            return false;
        }
        if (!Objects.equals(this.pathFileDef, other.pathFileDef)) {
            return false;
        }
        if (!Objects.equals(this.pathFileReporteJson, other.pathFileReporteJson)) {
            return false;
        }
        return true;
    }
}