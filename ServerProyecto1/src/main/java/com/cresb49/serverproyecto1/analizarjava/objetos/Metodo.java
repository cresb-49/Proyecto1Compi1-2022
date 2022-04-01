package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


/**
 *
 * @author Benjamin
 */
public class Metodo implements Serializable{
    
    
    private String nombre;
    private String tipo;
    private ArrayList<Parametros> parametros;
    private int repeticiones =1;

    public Metodo() {
    }
    
    public Metodo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Metodo(String nombre, String tipo, ArrayList<Parametros> parametros) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.parametros = parametros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Parametros> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Parametros> parametros) {
        this.parametros = parametros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.parametros);
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
        final Metodo other = (Metodo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.parametros, other.parametros)) {
            return false;
        }
        return true;
    }
    
    /**
     * Realiza la comparacion de un metodo en base a sus propiedades
     * @param metodo
     * @return 
     */
    public boolean compararMetodos(Metodo metodo){
        if (!Objects.equals(this.nombre, metodo.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, metodo.tipo)) {
            return false;
        }
        Collections.sort(parametros);
        Collections.sort(metodo.getParametros());
        if(!(this.parametros.size() == metodo.getParametros().size())){
            return false;
        }
        for (int i = 0; i < parametros.size(); i++) {
            if(!(parametros.get(i).getNombre().equals(metodo.getParametros().get(i).getNombre()))){
                return false;
            }
            if(!(parametros.get(i).getTipo().equals(metodo.getParametros().get(i).getTipo()))){
                return false;
            }
        }
        return true;
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
    public String toString() {
        return "Metodo{" + "nombre=" + nombre + ", tipo=" + tipo + ", repeticiones=" + repeticiones + ", parametros=" + parametros  + '}';
    }
    
}