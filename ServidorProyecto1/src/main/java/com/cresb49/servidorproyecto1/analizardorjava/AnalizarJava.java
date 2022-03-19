package com.cresb49.servidorproyecto1.analizardorjava;

import com.cresb49.servidorproyecto1.analizardorjava.objetos.TablaSimbolos;
import com.cresb49.servidorproyecto1.analizardorjava.objetos.resultados.*;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

public class AnalizarJava {
    private ArrayList<ErrorAnalisis> errores;
    private LexerJava lexerJava;
    private ParserJava parserJava;
    
    public AnalizarJava() {
    }

    public void ejecutar(String texto,TablaSimbolos tablaSimbolos,ArrayList<Clase> clases,ArrayList<Metodo> metodos,ArrayList<Comentario>comentarios ){
        Reader reader = new StringReader(texto);    
        errores = new ArrayList<>();
        lexerJava = new LexerJava(reader);
        lexerJava.setErrors(errores);
        lexerJava.setComentarios(comentarios);
        parserJava = new ParserJava(lexerJava);
        parserJava.setClases(clases);
        parserJava.setMetodos(metodos);
        parserJava.setTablasimbolos(tablaSimbolos);
        try {
            parserJava.parse();
        } catch (Exception e) {
            System.out.println("ERROR EN LA EJECUCION DEL ANALISIS DE ARCHIVO JAVA");
            e.printStackTrace();
        }
        System.err.println("----------------IMPRECION DE ERRORES-------------------");
        for (ErrorAnalisis errore : errores) {
            System.out.println(errore.toString());
        }
        tablaSimbolos.imprimirTabla();
    }
    
    public ArrayList<ErrorAnalisis> getErrores() {
        return errores;
    }
}
