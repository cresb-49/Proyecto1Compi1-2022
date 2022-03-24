package com.cresb49.serverproyecto1.analizarjava;

import java.util.ArrayList;
import java.util.List;

public class SimbolosTerminalesJava {

    public static final String[] terminalNames = new String[] {
            "",
            "",
            "import",
            "public",
            "private",
            "protected",
            "final",
            "break",
            "return",
            "int",
            "boolean",
            "String",
            "char",
            "double",
            "Object",
            "valor char",
            "if",
            "else",
            "for",
            "do",
            "while",
            "switch",
            "case",
            "identificador",
            "decimal",
            "entero",
            "!=",
            "==",
            "<=",
            "this",
            ">=",
            "<",
            ">",
            "&&",
            "||",
            "!",
            "++",
            "--",
            "*",
            "/",
            "+",
            "-",
            "(",
            ")",
            "[",
            "]",
            "{",
            "}",
            " . ",
            " , ",
            " : ",
            " ; ",
            "cadena",
            "class",
            "=",
            "true",
            "false",
            "default",
            "static",
            "new"
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