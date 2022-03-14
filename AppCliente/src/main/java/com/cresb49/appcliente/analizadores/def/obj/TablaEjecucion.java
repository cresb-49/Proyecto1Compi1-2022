package com.cresb49.appcliente.analizadores.def.obj;

import java.util.ArrayList;

import com.cresb49.appcliente.analizadores.Token;

public class TablaEjecucion {

    ArrayList<Token> ejecuciones;

    public TablaEjecucion(){
        ejecuciones = new ArrayList<>();
    }

    public void imprimirTabla(){
        System.out.println("---------------TABLA DE EJECUCION----------------");
        for (Token ejecucion : ejecuciones) {
            System.out.println(ejecucion.toString());
        }
        
    }
}
