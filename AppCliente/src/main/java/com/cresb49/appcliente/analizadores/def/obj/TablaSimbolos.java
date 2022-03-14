package com.cresb49.appcliente.analizadores.def.obj;

import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class TablaSimbolos {

    public static final String INT = "Integer";
    public static final String STRING = "String";
    public static final String MAS = "+";
    public static final String MENOS = "-";
    public static final String MUL = "*";
    public static final String DIV = "/";
    
    private ArrayList<FilaTabla> filas;

    public TablaSimbolos() {
        this.filas = new ArrayList<>();
    }

    public FilaTabla buscar(String nombre) {
        for (FilaTabla fila : filas) {
            if (fila.getNombre().equals(nombre)) {
                return fila;
            }
        }
        return null;
    }

    public ArrayList<FilaTabla> getFilas() {
        return filas;
    }
    
    public void resetTabla(){
        filas.clear();
    }
    
    public void imprimirTabla(){
        System.out.println("---------------TABLA DE SIMBOLOS----------------");
        for (FilaTabla fila : filas) {

            System.out.println(fila.toString());
        }
        
    }
}
