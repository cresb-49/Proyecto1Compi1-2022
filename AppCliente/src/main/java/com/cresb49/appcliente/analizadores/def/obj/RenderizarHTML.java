package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.ED.Pila;
import com.cresb49.appcliente.analizadores.Token;

public class RenderizarHTML {

    private TablaSimbolos tablaSimbolos;
    private TablaEjecucion tablaEjecucion;

    private Pila<Integer> pila_bucle;
    private Pila<String> var_bucle;

    public RenderizarHTML() {
    }

    public RenderizarHTML(TablaSimbolos tablaSimbolos, TablaEjecucion tablaEjecucion) {
        this.tablaSimbolos = tablaSimbolos;
        this.tablaEjecucion = tablaEjecucion;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public TablaEjecucion getTablaEjecucion() {
        return tablaEjecucion;
    }

    public void setTablaEjecucion(TablaEjecucion tablaEjecucion) {
        this.tablaEjecucion = tablaEjecucion;
    }

    public String HTML() {

        String hmtl = "";

        Token temp_ejecucion;
        for (Integer instruccion = 0; instruccion < tablaEjecucion.getFilas().size(); instruccion++) {
            temp_ejecucion = tablaEjecucion.getFilas().get(instruccion);

            switch (temp_ejecucion.getAccion()) {
                case Token.PRINT:
                    hmtl = hmtl + temp_ejecucion.getValorToken() + "\n";
                    break;
                case Token.BUCLE_INI:
                    break;
                case Token.BUCLE_FIN:
                    break;
                case Token.CONSULTAR:
                    break;
                case Token.CAMBIAR:
                    break;
                default:
                    System.out.println("No efectuo accion -> " + temp_ejecucion.getLexema());
                    break;
            }
        }
        return hmtl;
    }

}
