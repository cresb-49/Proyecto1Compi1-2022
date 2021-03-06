package com.cresb49.serverproyecto1.analizarjava.objetos;

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
    public static final String VOID = "void";
    public static final String COMODIN = "comodin";
    public static final String VARIABLE = "variable";
    public static final String ERROR = "error";
    
    private ArrayList<FilaTablaSymbolos> filas;

    public TablaSimbolos() {
        this.filas = new ArrayList<>();
    }

    public ArrayList<FilaTablaSymbolos> buscarNombre(String nombre) {
        ArrayList<FilaTablaSymbolos> result = new ArrayList<>();
        for (FilaTablaSymbolos fila : filas) {
            if (fila.getNombre().equals(nombre)) {
                result.add(fila);
            }
        }
        return result;
    }

    public FilaTablaSymbolos buscarNombreTipo(String nombre,String tipo) {
        for (FilaTablaSymbolos fila : filas) {
            if (fila.getNombre().equals(nombre)) {
                if(fila.getTipo().equals(tipo)){
                    return fila;
                }
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

    public int numeroVariables(){
        return this.filas.size();
    }
}