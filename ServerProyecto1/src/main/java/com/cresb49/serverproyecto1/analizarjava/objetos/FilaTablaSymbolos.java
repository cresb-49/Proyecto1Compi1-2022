package com.cresb49.serverproyecto1.analizarjava.objetos;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class FilaTablaSymbolos {
    private String nombre;
    private String tipo;
    private ArrayList<String> funciones;

    public FilaTablaSymbolos() {
    }

    public FilaTablaSymbolos(String nombre, String tipo,ArrayList<String> funciones) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.funciones = funciones;
    }

    public FilaTablaSymbolos(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public FilaTablaSymbolos(String nombre) {
        this.nombre = nombre;
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
        return funciones;
    }

    public void setFunciones(ArrayList<String> funciones) {
        this.funciones = funciones;
    }

    public void agregarFuncion(String nombreFuncion){
        if(this.funciones == null){
            this.funciones = new ArrayList<>();
        }
        boolean found = false;
        for (String nombre : this.funciones) {
            if(nombre.equals(nombreFuncion)){
                found = true;
                break;
            }
        }
        if(!found){
            this.funciones.add(nombreFuncion);
        }
    }

    public void mergueFuncions(ArrayList<String> nuevasFunciones){
        if(this.funciones == null){
            this.funciones = new ArrayList<>();
        }
        boolean found = false;
        for (String newfuncion : nuevasFunciones) {
            found = false;
            for (String string : this.funciones) {
                if(newfuncion!=null && string!=null){
                    if(newfuncion.equals(string)){
                        found = true;
                        break;
                    }
                }
            }
            if(found == false){
                this.agregarFuncion(newfuncion);
            }
        }
    }

    @Override
    public String toString() {
        return "FilaTabla{" + "nombre=" + nombre + ", tipo=" + tipo + ", funciones=" + funciones + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.funciones);
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
        final FilaTablaSymbolos other = (FilaTablaSymbolos) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.funciones, other.funciones)) {
            return false;
        }
        return true;
    }    
}