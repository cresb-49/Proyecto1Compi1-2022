package com.cresb49.appcliente.analizadores.json.obj;

import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class Metodo implements Serializable{
    
    private static final String ERROR_TYPE_SEM = "Semantico";
    private String nombre;
    private String tipo;
    private Integer parametros;

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

    public ArrayList<ErrorAnalisis> validar(int linea, int columna) {
        ArrayList<ErrorAnalisis> errores = new ArrayList<>();
        if (this.nombre == null) {
            errores.add(new ErrorAnalisis(ERROR_TYPE_SEM, "Metodo", linea, columna,"No esta definido el parametro \"nombre\""));
        }
        if(this.tipo!=null){
            errores.add(new ErrorAnalisis(ERROR_TYPE_SEM, "Metodo", linea, columna,"No esta definido el parametro \"tipo\""));
        }
        if(this.parametros!=null){
            errores.add(new ErrorAnalisis(ERROR_TYPE_SEM, "Metodo", linea, columna,"No esta definido el parametro \"parametros\""));
        }
        return errores;
    }

    @Override
    public String toString() {
        return "Metodo{" + "nombre=" + nombre + ", tipo=" + tipo + ", parametros=" + parametros + '}';
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
}
