/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.analizadores.def.obj;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class FilaTabla {
    private String nombre;
    private String tipo;
    private ArrayList<String> Funciones;
    private Object valor;

    public FilaTabla() {
    }

    public FilaTabla(String nombre, String tipo, ArrayList<String> Funciones, Object valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Funciones = Funciones;
        this.valor = valor;
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

    public ArrayList<String> getFunciones() {
        return Funciones;
    }

    public void setFunciones(ArrayList<String> Funciones) {
        this.Funciones = Funciones;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "FilaTabla{" + "nombre=" + nombre + ", tipo=" + tipo + ", Funciones=" + Funciones + ", valor=" + valor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.Funciones);
        hash = 61 * hash + Objects.hashCode(this.valor);
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
        final FilaTabla other = (FilaTabla) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.Funciones, other.Funciones)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }    
}
