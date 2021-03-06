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
    
    public AnalizarJava(ConsoleControl consola,ArrayList<ErrorAnalisis> errores) {
        this.consola = consola;
        this.errores = errores;
    }

    public void ejecutar(String texto,TablaSimbolos tablaSimbolos,ArrayList<Clase> clases,ArrayList<Metodo> metodos,ArrayList<Comentario>comentarios,String carpetaFuente,String archivoAnalizado){
        Reader reader = new StringReader(texto);
        lexerJava = new LexerJava(reader,consola, comentarios, errores,carpetaFuente,archivoAnalizado);
        parserJava = new ParserJava(lexerJava,tablaSimbolos, clases, metodos);
        try {
            parserJava.parse();
        } catch (Exception e) {
            System.out.println("ERROR EN LA EJECUCION DEL ANALISIS DE ARCHIVO JAVA");
            consola.addLog("ERROR EN LA EJECUCION DEL ANALISIS DE ARCHIVO JAVA");
            consola.addLog(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public ArrayList<ErrorAnalisis> getErrores() {
        return errores;
    }
}