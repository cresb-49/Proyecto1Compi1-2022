package com.cresb49.serverproyecto1.analizarjava;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import com.cresb49.serverproyecto1.analizarjava.objetos.*;
import com.cresb49.serverproyecto1.consolecontrol.ConsoleControl;

public class AnalizarJava {
    private ArrayList<ErrorAnalisis> errores;
    private LexerJava lexerJava;
    private ParserJava parserJava;
    private ConsoleControl consola;
    
    public AnalizarJava(ConsoleControl consola) {
        this.consola = consola;
    }

    public void ejecutar(String texto,TablaSimbolos tablaSimbolos,ArrayList<Clase> clases,ArrayList<Metodo> metodos,ArrayList<Comentario>comentarios,String carpetaFuente,String archivoAnalizado){
        Reader reader = new StringReader(texto);    
        errores = new ArrayList<>();
        lexerJava = new LexerJava(reader,consola, comentarios, errores,carpetaFuente,archivoAnalizado);
        parserJava = new ParserJava(lexerJava,tablaSimbolos, clases, metodos);
        try {
            parserJava.parse();
        } catch (Exception e) {
            System.out.println("ERROR EN LA EJECUCION DEL ANALISIS DE ARCHIVO JAVA");
            e.printStackTrace();
        }
    }
    
    public ArrayList<ErrorAnalisis> getErrores() {
        return errores;
    }
}