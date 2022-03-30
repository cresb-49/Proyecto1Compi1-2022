package com.cresb49.serverproyecto1.analizarjava;

public class Asignacion {
    private String tipo;
    private String clase;
    private Object valor;
    private boolean constante;

    public Asignacion(String tipo,String clase,Object valor){
        this.tipo=tipo;
        this.clase=clase;
        this.valor=valor;
    }

    public Asignacion(String tipo,String clase,boolean constante){
        this.tipo=tipo;
        this.clase=clase;
        this.constante = constante;
    }

    public Asignacion(String tipo,String clase){
        this.tipo=tipo;
        this.clase=clase;
    }
    
    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getClase(){
        return this.clase;
    }

    public void setClase(String clase){
        this.clase = clase;
    }

    public Object getValor(){
        return this.valor;
    }

    public void setValor(Object valor){
        this.valor = valor;
    }
    
    public boolean isConstante() {
        return constante;
    }

    public void setConstante(boolean constante) {
        this.constante = constante;
    }
}
