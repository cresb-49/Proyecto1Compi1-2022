package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.ED.Pila;
import com.cresb49.appcliente.ED.Exceptions.NoDataException;
import com.cresb49.appcliente.analizadores.Token;

public class RenderizarHTML {

    private TablaSimbolos tablaSimbolos;
    private TablaEjecucion tablaEjecucion;

    private Pila<Integer> pila_bucle;
    private Pila<String> pila_var_bucle;

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
        Integer instruccion = 0;

        while (instruccion < tablaEjecucion.getFilas().size()) {
            System.out.println("Ejecutando la instruccion #" + instruccion);
            temp_ejecucion = tablaEjecucion.getFilas().get(instruccion);
            switch (temp_ejecucion.getAccion()) {
                case Token.PRINT:
                    if (this.modo_ejecucion) {
                        hmtl = hmtl + temp_ejecucion.getValorToken() + "\n";
                    }
                    break;
                case Token.BUCLE_INI:
                    int temp_instruccion = instruccion;
                    System.out.println("Ingreso a la pila_bucle la instruccion #" + instruccion);
                    pila_bucle.push(temp_instruccion);
                    if(this.modo_ejecucion){
                        instruccion++;
                        System.out.println("Ingreso a la pila_var_bucle la instruccion #" + instruccion);
                        pila_var_bucle.push(tablaEjecucion.getFilas().get(instruccion).getLexema());
                        if (!this.validarCiclo(tablaEjecucion.getFilas().get(instruccion),tablaEjecucion.getFilas().get(instruccion + 1))) {
                            this.aisg_modo_ejecucion(false);
                            try {
                                pila_bucle.pop();
                            } catch (NoDataException e) {
                                System.out.println("La pila_bucle estaba vacia -> BUCLE_IN");
                            }
                            try {
                                pila_var_bucle.pop();
                            } catch (NoDataException e) {
                                System.out.println("La pila_var_bucle estaba vacia -> BUCLE_IN");
                            }
                        }
                        instruccion++;
                    }
                    break;
                case Token.BUCLE_FIN:
                    if(pila_bucle.isEmpty()){
                        this.aisg_modo_ejecucion(true);
                    }else{
                        try {
                            int tmp = pila_bucle.pop();
                            instruccion = tmp - 1;
                        } catch (NoDataException e) {
                            System.out.println("La pila estaba vacia -> BUCLE_FIN");
                        }
                    }
                    break;
                case Token.CONSULTAR:
                    break;
                case Token.CAMBIAR:
                    break;
                default:
                    System.out.println("No efectuo accion -> " + temp_ejecucion.getLexema());
                    break;
            }
            instruccion++;
        }
        return hmtl;
    }

    private boolean validarCiclo(Token var, Token valMax) {
        FilaTabla variable = tablaSimbolos.buscar(var.getLexema());
        if (variable.getValor() == null) {
            System.out.println("La variable \"" + variable.getNombre() + "\" es nula");
        } else {
            FilaTabla var_max = tablaSimbolos.buscar(valMax.getLexema());
            if (var_max == null) {
                int valor_maximo = (int) valMax.getValorToken();
                int val_variable = (int) variable.getValor();
                return val_variable <= valor_maximo;
            } else {
                int valor_maximo = (int) var_max.getValor();
                int val_variable = (int) variable.getValor();
                return val_variable <= valor_maximo;
            }
        }
        return false;
    }

    public void aisg_modo_ejecucion(boolean estado) {
        this.modo_ejecucion = estado;
    }

}
