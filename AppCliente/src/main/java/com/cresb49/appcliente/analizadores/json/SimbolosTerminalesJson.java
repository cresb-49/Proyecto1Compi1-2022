/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.analizadores.json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class SimbolosTerminalesJson {

    public static final String[] terminalNames = new String[]{
        "",
        "",
        "[",
        "]",
        "{",
        "}",
        ",",
        ":",
        "cadena",
        "entero",
        "Score",
        "Clases",
        "Variables",
        "Nombre",
        "Tipo",
        "Funcion",
        "Metodos",
        "Comentarios",
        "Parametros",
        "Texto",
    };

    public SimbolosTerminalesJson() {

    }

    public List<String> obtenerSimbolos(List<Integer> expected_tokens) {
        List<String> resultados = new ArrayList<>();
        for (Integer entero : expected_tokens) {
            if (!(entero == 1 || entero == 0)) {
                resultados.add(terminalNames[entero]);
            }
        }
        return resultados;
    }
}
