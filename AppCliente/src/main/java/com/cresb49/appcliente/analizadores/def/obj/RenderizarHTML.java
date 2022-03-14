package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.analizadores.Token;

public class RenderizarHTML {
    private TablaSimbolos tablaSimbolos;
    private TablaEjecucion tablaEjecucion;
    
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
    
    public String HTML(){
        String hmtl = "";
        for (Token token : tablaEjecucion.getFilas()) {
            if(token.getAccion()==Token.PRINT){
                hmtl = hmtl + token.getValorToken()+"\n";
            }
        }   
        return hmtl;
    }
    
}
