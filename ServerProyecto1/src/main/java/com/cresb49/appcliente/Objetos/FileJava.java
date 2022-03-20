package com.cresb49.appcliente.Objetos;

import java.io.Serializable;

public class FileJava implements Serializable{
    private String code;
    private String name;
    private String extencion;

    public FileJava() {
    }

    public FileJava(String code, String name, String extencion) {
        this.code = code;
        this.name = name;
        this.extencion = extencion;
    }

    public String getText() {
        return code;
    }

    public void setText(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtencion() {
        return extencion;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }
    
    public void printCode(){
        System.out.println(code);
    }
    
}
