package com.cresb49.serverproyecto1.analizarjava;

import java.util.ArrayList;
import java.util.List;

public class SimbolosTerminalesJava {

    public static final String[] terminalNames = new String[] {
            "EOF",
            "error",
            "IMPORT",
            "PUBLIC",
            "PRIVATE",
            "PROTECTED",
            "FINAL",
            "BREAK",
            "RETURN",
            "INT",
            "BOOL",
            "STR",
            "CHAR",
            "DOUBLE",
            "OBJ",
            "CHAR_VAL",
            "IF",
            "ELSE",
            "FOR",
            "DO",
            "WHILE",
            "SWITCH",
            "CASE",
            "ID",
            "DECIMAL",
            "ENTERO",
            "DIFERENTE",
            "IGUAL",
            "MENOR_IGUAL",
            "THIS",
            "MAYOR_IGUAL",
            "MENOR_QUE",
            "MAYOR_QUE",
            "AND",
            "OR",
            "NOT",
            "SUMAR",
            "RESTAR",
            "MUL",
            "DIV",
            "MAS",
            "MENOS",
            "PA_A",
            "PA_C",
            "CO_A",
            "CO_C",
            "LLA_A",
            "LLA_C",
            "PUNTO",
            "COMA",
            "DOSPUNTOS",
            "PUNTOCOMA",
            "STRING",
            "CLASS",
            "EQUAL",
            "TRUE",
            "FALSE",
            "DEFAULT",
            "STATIC",
            "NEW"
    };
    
    public SimbolosTerminalesJava() {

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