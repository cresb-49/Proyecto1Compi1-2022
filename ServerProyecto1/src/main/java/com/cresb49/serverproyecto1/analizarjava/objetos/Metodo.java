package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Benjamin
 */
public class Metodo implements Serializable{
    
    
    private String nombre;
    private String tipo;
    private Integer parametros;
    private int repeticiones;

    public Metodo() {
    }

    public Metodo(String nombre, String tipo, Integer parametros) {
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

    public Integer getParametros() {
        return parametros;
    }

    public void setParametros(Integer parametros) {
        this.parametros = parametros;
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
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + Objects.hashCode(this.parametros);
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Metodo [nombre=" + nombre + ", parametros=" + parametros + ", repeticiones=" + repeticiones + ", tipo="
                + tipo + "]";
    }
}