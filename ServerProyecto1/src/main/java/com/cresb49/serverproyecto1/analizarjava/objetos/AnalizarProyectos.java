package com.cresb49.serverproyecto1.analizarjava.objetos;
import java.util.ArrayList;

import com.cresb49.appcliente.Objetos.*;
import com.cresb49.serverproyecto1.analizarjava.AnalizarJava;
import com.cresb49.serverproyecto1.consolecontrol.ConsoleControl;

public class AnalizarProyectos {
    private ConsoleControl consola;

    public AnalizarProyectos(ConsoleControl consola){
        this.consola = consola;
    }
    public void realizarAnalisis(Proyecto proyecto){
        //OBJETOS PERTENECIENTES AL ANALISIS DE LOS ARCHIVOS DE LA CARPETA 1
        AnalizarJava analizarJava1 = new AnalizarJava(consola);
        TablaSimbolos tablaSimbolos1 = new TablaSimbolos();
        ArrayList<Clase> clases1 = new ArrayList<>();
        ArrayList<Metodo> metodos1 = new ArrayList<>();
        ArrayList<Comentario> comentarios1 = new ArrayList<>();
        //OBJETOS PERTENECIENTES AL ANALISIS DE LOS ARCHIVOS DE LA CARPETA 2
        AnalizarJava analizarJava2 = new AnalizarJava(consola);
        TablaSimbolos tablaSimbolos2 = new TablaSimbolos();
        ArrayList<Clase> clases2 = new ArrayList<>();
        ArrayList<Metodo> metodos2 = new ArrayList<>();
        ArrayList<Comentario> comentarios2 = new ArrayList<>();

        //IMPRECION DE LOS ARCHIVOS RECIBIDOS EN LA CONSOLA DEL SERVIDOR
        for (FileJava archivo : proyecto.getCarpeta1()) {
            System.out.println(proyecto.getNombreCarpeta1()+" -> "+archivo.getName());
            consola.addLog(proyecto.getNombreCarpeta1()+" -> "+archivo.getName());
            //System.out.println(archivo.getText());
        }
        for (FileJava archivo : proyecto.getCarpeta2()) {
            System.out.println(proyecto.getNombreCarpeta2()+" -> "+archivo.getName());
            consola.addLog(proyecto.getNombreCarpeta2()+" -> "+archivo.getName());
            //System.out.println(archivo.getText());
        }
        //CICLO PARA EL ANALISIS DE LOS ARCHIVOS DE LA CARPETA 1
        for (FileJava archivo : proyecto.getCarpeta1()) {
            consola.addLog("INICIO DE ANALISIS: "+proyecto.getNombreCarpeta1()+"/"+archivo.getName());
            analizarJava1.ejecutar(archivo.getText(), tablaSimbolos1, clases1, metodos1, comentarios1, proyecto.getNombreCarpeta1(), archivo.getName());
            //System.out.println(archivo.getText());
        }

        tablaSimbolos1.imprimirTabla();
        System.err.println("----------------IMPRECION CLASE-------------------");
        for (Clase clase : clases1) {
            System.out.println(clase.toString());
        }
        System.err.println("----------------IMPRECION METODO-------------------");
        for (Metodo metodo : metodos1) {
            System.out.println(metodo.toString());
        }
        System.err.println("----------------IMPRECION COMENTARIOS-------------------");
        for (Comentario comentario : comentarios1) {
            System.out.println(comentario.toString());
        }        
    }
}