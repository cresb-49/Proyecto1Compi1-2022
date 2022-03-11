/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.analizadores.filecopy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class SimbolosTerminalesFileCopy {

    public static final String[] terminalNames = new String[]{
        "",
        "",
        "{",
        "}",
        ",",
        ":",
        "cadena",
        "Proyecto1",
        "Proyecto2",
        "FileDef",
        "ReporteJson"
    };
    
    public SimbolosTerminalesFileCopy() {

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
