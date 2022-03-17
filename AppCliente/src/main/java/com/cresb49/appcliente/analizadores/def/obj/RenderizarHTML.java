package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.ED.Pila;
import com.cresb49.appcliente.ED.Exceptions.NoDataException;
import com.cresb49.appcliente.analizadores.Token;
import java.util.ArrayList;
import java.util.Objects;

public class RenderizarHTML {

    private TablaSimbolos tablaSimbolos;
    private TablaEjecucion tablaEjecucion;

    private Pila<Integer> pila_bucle;
    private Pila<Integer> pila_intruccion_eje_false;
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
        pila_bucle = new Pila<>();
        pila_intruccion_eje_false = new Pila<>();
        pila_var_bucle = new Pila<>();

        String html = "";

        Token temp_ejecucion;
        Integer instruccion = 0;
        this.aisg_modo_ejecucion(true);

        while (instruccion < tablaEjecucion.getFilas().size()) {
            System.out.println("Ejecutando la instruccion #" + instruccion);
            temp_ejecucion = tablaEjecucion.getFilas().get(instruccion);
            switch (temp_ejecucion.getAccion()) {
                case Token.PRINT:
                    if (this.modo_ejecucion) {
                        html = html + temp_ejecucion.getValorToken() + "\n";
                    }
                    break;
                case Token.BUCLE_INI:
                    System.out.println("Inicio de BUCLE");
                    int temp_instruccion = instruccion;
                    System.out.println("Ingreso a la pila_bucle la instruccion #" + instruccion);
                    pila_bucle.push(temp_instruccion);
                    if (this.modo_ejecucion) {
                        instruccion++;
                        System.out.println("Ingreso a la pila_var_bucle la instruccion #" + instruccion);
                        pila_var_bucle.push(tablaEjecucion.getFilas().get(instruccion).getLexema());
                        if (!this.validarCiclo(tablaEjecucion.getFilas().get(instruccion),tablaEjecucion.getFilas().get(instruccion + 1))) {
                            System.out.println("Ciclo no valido Modo Ejecucion falso");
                            this.aisg_modo_ejecucion(false);
                            pila_intruccion_eje_false.push(temp_instruccion);
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
                    System.out.println("Fin de BUCLE");
                    if (modo_ejecucion) {
                        try {
                            String nombre_var = pila_var_bucle.pop();
                            FilaTabla variable = tablaSimbolos.buscar(nombre_var);
                            Integer valor = (Integer) variable.getValor();
                            valor++;
                            variable.setValor(valor);
                            System.out.println("Sume uno a la variable: " + variable.getNombre() + "=" + variable.getValor());
                        } catch (NoDataException e) {
                            System.out.println("La pila_var_bucle estaba vacia -> BUCLE_FIN");
                        }
                        try {
                            Integer ints = pila_bucle.pop();
                            instruccion = ints - 1;
                            System.out.println("Asigne la instruccion #" + (instruccion + 1));
                        } catch (NoDataException e) {
                            System.out.println("La pila_bucle estaba vacia -> BUCLE_FIN");
                        }
                    } else {
                        try {
                            if (pila_intruccion_eje_false.isEmpty()) {
                                pila_bucle.pop();
                            } else {
                                if (pila_bucle.peek().equals(pila_intruccion_eje_false.peek())) {
                                    System.out.println("Fin BUCLE Modo Ejecucion falso -> AHORA true");
                                    this.aisg_modo_ejecucion(true);
                                    pila_bucle.pop();
                                    pila_intruccion_eje_false.pop();
                                } else {
                                    pila_bucle.pop();
                                }
                            }
                        } catch (NoDataException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case Token.CONSULTAR:
                    if (this.modo_ejecucion) {
                        html = html + tablaSimbolos.buscar(temp_ejecucion.getLexema()).getValor() + "\n";
                    }
                    break;
                case Token.CAMBIAR:
                    if(this.modo_ejecucion){
                        if(temp_ejecucion.getValorToken() instanceof AccesoVariables){
                            AccesoVariables acc = (AccesoVariables) temp_ejecucion.getValorToken();
                            if (acc.getIndex() instanceof Integer){
                                try{
                                    if(acc.getarreglo() instanceof ArrayList){
                                        html = html + ((ArrayList<Object>)acc.getarreglo()).get((Integer)acc.getIndex()) + "\n";
                                    }
                                }catch(Exception ex){
                                    System.out.println("El indice de acceso es mayor al tamaño del arreglo");
                                }
                            }
                            if(acc.getIndex() instanceof FilaTabla){
                                FilaTabla indexVar = (FilaTabla) acc.getIndex();
                                try{
                                    if(acc.getarreglo() instanceof ArrayList){
                                        html = html + ((ArrayList<Object>)acc.getarreglo()).get((Integer)indexVar.getValor()) + "\n";
                                    }
                                }catch(Exception ex){
                                    System.out.println("El indice de acceso es mayor al tamaño del arreglo");
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("No efectuo accion -> " + temp_ejecucion.getLexema());
                    break;
            }
            instruccion++;
        }
        System.out.println("Termino el renderizado del HTML");
        return html;
    }

    private boolean validarCiclo(Token var, Token valMax) {
        FilaTabla variable = tablaSimbolos.buscar(var.getLexema());
        if (variable.getValor() == null) {
            System.out.println("La variable \"" + variable.getNombre() + "\" es nula");
        } else {
            if (valMax.getValorToken() instanceof Integer) {
                int valor_maximo = (int) valMax.getValorToken();
                int val_variable = (int) variable.getValor();
                System.out.println(variable.getNombre() + "=" + val_variable + " <= " + valor_maximo);
                return val_variable <= valor_maximo;
            } else if (valMax.getValorToken() instanceof FilaTabla) {
                int valor_maximo = (int) ((FilaTabla) valMax.getValorToken()).getValor();
                int val_variable = (int) variable.getValor();
                System.out.println(variable.getNombre() + "=" + val_variable + " <= " + valor_maximo);
                return val_variable <= valor_maximo;
            }
        }
        return false;
    }

    public void aisg_modo_ejecucion(boolean estado) {
        this.modo_ejecucion = estado;
    }

}
