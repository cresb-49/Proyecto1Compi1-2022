package com.cresb49.server.AnalizadorJava.obj;

import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class TablaSimbolos {

    public static final String INT = "int";
    public static final String DOUBLE = "double";
    public static final String CHAR = "char";
    public static final String STRING = "String";
    public static final String BOOLEAN = "boolean";
    public static final String OBJECT = "Object";
    
    private ArrayList<FilaTablaSymbolos> filas;

    public TablaSimbolos() {
        this.filas = new ArrayList<>();
    }

    public FilaTablaSymbolos buscar(String nombre) {
        for (FilaTablaSymbolos fila : filas) {
            if (fila.getNombre().equals(nombre)) {
                return fila;
            }
        }
        return null;
    }

    public ArrayList<FilaTablaSymbolos> getFilas() {
        return filas;
    }
    
    public void resetTabla(){
        filas.clear();
    }
    
    public void imprimirTabla(){
        System.out.println("---------------TABLA DE SIMBOLOS----------------");
        for (FilaTablaSymbolos fila : filas) {
            System.out.println(fila.toString());
        }
        
    }
}
