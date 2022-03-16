package com.cresb49.appcliente.analizadores.def.obj;

import java.util.ArrayList;

import com.cresb49.appcliente.analizadores.Token;

public class TablaEjecucion {

    private ArrayList<Token> ejecuciones;
    

    public TablaEjecucion() {
        ejecuciones = new ArrayList<>();
    }

    public ArrayList<Token> getFilas() {
        return ejecuciones;
    }

    public void resetTabla() {
        ejecuciones.clear();
    }

    public void imprimirTabla() {
        System.out.println("---------------TABLA DE EJECUCION----------------");
        for (Token ejecucion : ejecuciones) {
            System.out.println("Accion: " + this.accion(ejecucion.getAccion()) + " ,Valor: " + ejecucion.getValorToken() + " ,Token->val: " + ejecucion.getLexema());
        }
    }
    

    private String accion(int accion) {

        switch (accion) {
            case Token.VIEW:
                return "VIEW     ";
            case Token.PRINT:
                return "PRINT    ";
            case Token.CAMBIAR:
                return "CAMBIAR  ";
            case Token.CONSULTAR:
                return "CONSULTAR";
            case Token.BUCLE_INI:
                return "BUCLE_INI";
            case Token.BUCLE_FIN:
                return "BUCLE_FIN";
        }
        return "ERROR ACCION";
    }
}
