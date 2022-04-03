package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.ED.Pila;
import com.cresb49.appcliente.ED.Exceptions.NoDataException;
import com.cresb49.appcliente.Objetos.ConsoleControl;
import com.cresb49.appcliente.analizadores.Token;
import com.cresb49.appcliente.analizadores.json.obj.*;
import java.util.ArrayList;

public class RenderizarHTML {

    private TablaSimbolos tablaSimbolos;
    private TablaEjecucion tablaEjecucion;

    private Pila<Integer> pila_bucle;
    private Pila<Integer> pila_intruccion_eje_false;
    private Pila<String> pila_var_bucle;

    private Pila<Object> pila_consulta;

    private ConsoleControl consola;

    private boolean modo_ejecucion;

    public RenderizarHTML() {
    }

    public RenderizarHTML(TablaSimbolos tablaSimbolos, TablaEjecucion tablaEjecucion, ConsoleControl consola) {
        this.tablaSimbolos = tablaSimbolos;
        this.tablaEjecucion = tablaEjecucion;
        this.consola = consola;
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
        pila_consulta = new Pila<>();

        String html = "";

        Token temp_ejecucion;
        Integer instruccion = 0;
        this.aisg_modo_ejecucion(true);

        while (instruccion < tablaEjecucion.getFilas().size()) {
            //System.out.println("Ejecutando la instruccion #" + instruccion);
            temp_ejecucion = tablaEjecucion.getFilas().get(instruccion);
            switch (temp_ejecucion.getAccion()) {
                case Token.PRINT:
                    if (this.modo_ejecucion) {
                        html = html + temp_ejecucion.getValorToken() + "\n";
                    }
                    break;
                case Token.BUCLE_INI:
                    //System.out.println("Inicio de BUCLE");
                    int temp_instruccion = instruccion;
                    //System.out.println("Ingreso a la pila_bucle la instruccion #" + instruccion);
                    pila_bucle.push(temp_instruccion);
                    if (this.modo_ejecucion) {
                        instruccion++;
                        //System.out.println("Ingreso a la pila_var_bucle la instruccion #" + instruccion);
                        pila_var_bucle.push(tablaEjecucion.getFilas().get(instruccion).getLexema());
                        if (!this.validarCiclo(tablaEjecucion.getFilas().get(instruccion),
                                tablaEjecucion.getFilas().get(instruccion + 1))) {
                            //System.out.println("Ciclo no valido Modo Ejecucion falso");
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
                    //System.out.println("Fin de BUCLE");
                    if (modo_ejecucion) {
                        try {
                            String nombre_var = pila_var_bucle.pop();
                            FilaTabla variable = tablaSimbolos.buscar(nombre_var);
                            Integer valor = (Integer) variable.getValor();
                            valor++;
                            variable.setValor(valor);
                            //System.out.println("Sume uno a la variable: " + variable.getNombre() + "=" + variable.getValor());
                        } catch (NoDataException e) {
                            //System.out.println("La pila_var_bucle estaba vacia -> BUCLE_FIN");
                        }
                        try {
                            Integer ints = pila_bucle.pop();
                            instruccion = ints - 1;
                            //System.out.println("Asigne la instruccion #" + (instruccion + 1));
                        } catch (NoDataException e) {
                            //System.out.println("La pila_bucle estaba vacia -> BUCLE_FIN");
                        }
                    } else {
                        try {
                            if (pila_intruccion_eje_false.isEmpty()) {
                                pila_bucle.pop();
                            } else {
                                if (pila_bucle.peek().equals(pila_intruccion_eje_false.peek())) {
                                    //System.out.println("Fin BUCLE Modo Ejecucion falso -> AHORA true");
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
                    if (this.modo_ejecucion) {
                        if (temp_ejecucion.getValorToken() instanceof AccesoVariables) {
                            AccesoVariables acc = (AccesoVariables) temp_ejecucion.getValorToken();
                            if (acc.getIndex() instanceof Integer) {
                                try {
                                    if (acc.getarreglo() instanceof ArrayList) {
                                        ArrayList<Object> lista = (ArrayList<Object>) acc.getarreglo();
                                        Object objetoList = lista.get((int) acc.getIndex());
                                        html = html + this.tipoVar(objetoList) + "\n";
                                    }
                                } catch (Exception ex) {
                                    System.out.println("El indice de acceso es mayor al tamaño del arreglo");
                                }
                            }
                            if (acc.getIndex() instanceof FilaTabla) {
                                FilaTabla indexVar = (FilaTabla) acc.getIndex();
                                try {
                                    if (acc.getarreglo() instanceof ArrayList) {
                                        ArrayList<Object> lista = (ArrayList<Object>) acc.getarreglo();
                                        Object objetoList = lista.get((Integer) indexVar.getValor());
                                        html = html + this.tipoVar(objetoList) + "\n";
                                    }
                                } catch (Exception ex) {
                                    System.out.println("El indice de acceso es mayor al tamaño del arreglo");
                                }
                            }
                        }
                    }
                    break;
                case Token.VAR_CONSULT:
                    if (this.modo_ejecucion) {
                        html = html + this.obtenerValor(temp_ejecucion) + "\n";
                    }
                    break;
                case Token.VIEW:
                    if (this.modo_ejecucion) {
                        if (temp_ejecucion.getValorToken() instanceof AccesoVariables) {
                            AccesoVariables acc = (AccesoVariables) temp_ejecucion.getValorToken();
                            if (acc.getIndex() instanceof Integer) {
                                try {
                                    if (acc.getarreglo() instanceof ArrayList) {
                                        ArrayList<Object> lista = (ArrayList<Object>) acc.getarreglo();
                                        Object objetoList = lista.get((int) acc.getIndex());
                                        pila_consulta.push(objetoList);
                                    }
                                } catch (Exception ex) {
                                    System.out.println("El indice de acceso es mayor al tamaño del arreglo");
                                }
                            }
                            if (acc.getIndex() instanceof FilaTabla) {
                                FilaTabla indexVar = (FilaTabla) acc.getIndex();
                                try {
                                    if (acc.getarreglo() instanceof ArrayList) {
                                        ArrayList<Object> lista = (ArrayList<Object>) acc.getarreglo();
                                        Object objetoList = lista.get((Integer) indexVar.getValor());
                                        pila_consulta.push(objetoList);
                                    }
                                } catch (Exception ex) {
                                    System.out.println("El indice de acceso es mayor al tamaño del arreglo");
                                }
                            }
                        }
                    }
                    break;
                default:
                    //System.out.println("Instruccion ignorada -> " + temp_ejecucion.getLexema());
                    break;
            }
            instruccion++;
        }
        System.out.println("Termino el renderizado del HTML");
        return html;
    }

    private String obtenerValor(Token parametroConsulta) {
        try {
            Object var = pila_consulta.pop();
            if (var instanceof Clase) {
                switch (parametroConsulta.getLexema()) {
                    case "Nombre":
                        return "" + ((Clase) var).getNombre();
                }
            } else if (var instanceof Variable) {
                switch (parametroConsulta.getLexema()) {
                    case "Nombre":
                        return "" + ((Variable) var).getNombre();
                    case "Tipo":
                        return "" + ((Variable) var).getTipo();
                    case "Funcion":
                        return "" + ((Variable) var).getFuncion();
                }
            } else if (var instanceof Comentario) {
                switch (parametroConsulta.getLexema()) {
                    case "Texto":
                        return "" + ((Comentario) var).getTexto();
                }
            } else if (var instanceof Metodo) {
                switch (parametroConsulta.getLexema()) {
                    case "Nombre":
                        return "" + ((Metodo) var).getNombre();
                    case "Tipo":
                        return "" + ((Metodo) var).getTipo();
                    case "Parametros":
                        return "" + ((Metodo) var).getParametros();
                }
            } else {
                return "";
            }
        } catch (NoDataException e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean validarCiclo(Token var, Token valMax) {
        FilaTabla variable = tablaSimbolos.buscar(var.getLexema());
        if (variable.getValor() == null) {
            System.out.println("La variable \"" + variable.getNombre() + "\" es nula");
        } else {
            if (valMax.getValorToken() instanceof Integer) {
                int valor_maximo = (int) valMax.getValorToken();
                int val_variable = (int) variable.getValor();
                //System.out.println(variable.getNombre() + "=" + val_variable + " <= " + valor_maximo);
                return val_variable <= valor_maximo;
            } else if (valMax.getValorToken() instanceof FilaTabla) {
                int valor_maximo = (int) ((FilaTabla) valMax.getValorToken()).getValor();
                int val_variable = (int) variable.getValor();
                //System.out.println(variable.getNombre() + "=" + val_variable + " <= " + valor_maximo);
                return val_variable <= valor_maximo;
            }
        }
        return false;
    }

    public void aisg_modo_ejecucion(boolean estado) {
        this.modo_ejecucion = estado;
    }

    private String tipoVar(Object objetoList) {
        if (objetoList instanceof Variable) {
            return "ObjetoVariable" + objetoList.hashCode();
        } else if (objetoList instanceof Clase) {
            return "ObjetoClase" + objetoList.hashCode();
        } else if (objetoList instanceof Metodo) {
            return "ObjetoMetodo" + objetoList.hashCode();
        } else if (objetoList instanceof Comentario) {
            return "ObjetoComentario" + objetoList.hashCode();
        } else {
            return "ObjetoGenerico";
        }
    }

}
