package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.ED.Pila;
import com.cresb49.appcliente.analizadores.Token;

public class RenderizarHTML {

    private TablaSimbolos tablaSimbolos;
    private TablaEjecucion tablaEjecucion;

    private Pila<Integer> pila_bucle;
    private Pila<String> var_bucle;

    private boolean modo_ejecucion;

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
            System.out.println("Ejecutando la instruccion #"+instruccion);
            temp_ejecucion = tablaEjecucion.getFilas().get(instruccion);

            switch (temp_ejecucion.getAccion()) {
                case Token.PRINT:
                    hmtl = hmtl + temp_ejecucion.getValorToken() + "\n";
                    break;
                case Token.BUCLE_INI:
                    int temp_instruccion = instruccion;
                    pila_bucle.push(temp_instruccion);
                    instruccion++;
                    if(!this.validarCiclo(tablaEjecucion.getFilas().get(instruccion),tablaEjecucion.getFilas().get(instruccion+1))){
                        this.aisg_modo_ejecucion(false);
                    }
                    instruccion++;
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

    private boolean validarCiclo(Token var, Token valMax) {
        FilaTabla variable = tablaSimbolos.buscar(var.getLexema());
        if(variable.getValor()==null){
            System.out.println("La variable \""+variable.getNombre()+"\" es nula");
        }else{
            FilaTabla var_max = tablaSimbolos.buscar(valMax.getLexema());
            if(var_max == null){
                int valor_maximo = (int) valMax.getValorToken();
                int val_variable = (int) variable.getValor();
                return val_variable <= valor_maximo;
            }else{
                int valor_maximo = (int) var_max.getValor();
                int val_variable = (int) variable.getValor();
                return val_variable <= valor_maximo;
            }
        }
        return false;
    }

    public void aisg_modo_ejecucion(boolean estado){
        this.modo_ejecucion = estado;
    }

    

}
