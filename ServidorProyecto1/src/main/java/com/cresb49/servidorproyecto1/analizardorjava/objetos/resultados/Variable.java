package com.cresb49.servidorproyecto1.analizardorjava.objetos.resultados;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class Variable implements Serializable{
    
    private String nombre;
    private String tipo;
    private String funcion;

    public Variable() {
    }

    public Variable(String nombre, String tipo, String funcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.funcion = funcion;
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

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "Variable{" + "nombre=" + nombre + ", tipo=" + tipo + ", funcion=" + funcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.tipo);
        hash = 13 * hash + Objects.hashCode(this.funcion);
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
        final Variable other = (Variable) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.funcion, other.funcion)) {
            return false;
        }
        return true;
    }
}
