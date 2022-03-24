package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class Parametros implements Comparable{
    private String nombre;
    private String tipo;

    public Parametros(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.tipo);
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
        final Parametros other = (Parametros) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Parametros{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    } 

    @Override
    public int compareTo(Object o) {
        final Parametros other = (Parametros) o;
        return this.nombre.compareTo(other.getNombre());
    }
}
