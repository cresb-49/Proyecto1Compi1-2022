package com.cresb49.appcliente.analizadores.def.obj;

import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class TablaSimbolos {
    
    private ArrayList<FilaTabla> filas;
    
    public TablaSimbolos(){
        this.filas = new ArrayList<>();
    }
    
    public FilaTabla buscar(String nombre){
        for (FilaTabla fila : filas) {
            if(fila.getNombre().equals(nombre)){
                return fila;
            }
        }
        return null;
    }
    
}
