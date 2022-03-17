package com.cresb49.server.AnalizadorJava;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import com.cresb49.server.AnalizadorJava.obj.TablaSimbolos;

public class AnalizarJava {
    private ArrayList<ErrorAnalisis> errores;
    private LexerJava lexerJava;
    private ParserJava parserJava;

    public AnalizarJava() {
    }

    public void ejecutar(String texto){
        Reader reader = new StringReader(texto);    
        errores = new ArrayList<>();
        lexerJava = new LexerJava(reader);
        lexerJava.setErrors(errores);
        parserJava = new ParserJava(lexerJava);
        TablaSimbolos tablaSimbolos = new TablaSimbolos();
        parserJava.setTablasimbolos(tablaSimbolos);
        try {
            parserJava.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("----------------IMPRECION DE ERRORES-------------------");
        for (ErrorAnalisis errore : errores) {
            System.out.println(errore.toString());
        }
        //System.err.println("----------------VALORES RECUPERADOS-------------------");
        parserJava.getTablaSimbolos().imprimirTabla();
    }
    
    public ArrayList<ErrorAnalisis> getErrores() {
        return errores;
    }
}
