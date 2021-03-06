package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Clase implements Serializable{
    
    private String nombre;
    private ArrayList<String> funciones;
    private int repeticiones =1;
    
    public Clase() {
        this.funciones = new ArrayList<>();
    }

    public Clase(String nombre) {
        this.nombre = nombre;
        this.funciones = new ArrayList<>();
    }

    public Clase(String nombre, ArrayList<String> funciones) {
        this.nombre = nombre;
        this.funciones = funciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarRepeticion(){
        this.repeticiones++;
    }

    /**
     * @return the repeticiones
     */
    public int getRepeticiones() {
        return repeticiones;
    }

    /**
     * @param repeticiones the repeticiones to set
     */
    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    /**
     * Este metodo recive el numero de repeticiones y la suma a la cantidad ya existente en el objeto
     * @param repeticiones
     */
    public void mezclarRepeticiones(int repeticiones){
        this.repeticiones = this.repeticiones + repeticiones;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nombre);
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
        final Clase other = (Clase) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public boolean compararClases(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clase other = (Clase) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if(!(this.funciones.size()==other.funciones.size())){
            return false;
        }
        Collections.sort(funciones);
        Collections.sort(other.funciones);
        for (int i = 0; i < funciones.size(); i++) {
            if(!funciones.get(i).equals(other.funciones.get(i))){
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<String> funciones) {
        this.funciones = funciones;
    }

    @Override
    public String toString() {
        return "Clase{" + "nombre=" + nombre + ", repeticiones=" + repeticiones + ", funciones=" + funciones  + '}';
    }
    
    
    
}