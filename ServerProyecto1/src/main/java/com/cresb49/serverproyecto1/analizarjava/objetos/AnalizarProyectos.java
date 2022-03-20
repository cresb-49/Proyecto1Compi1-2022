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
    public String realizarAnalisis(Proyecto proyecto){
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
            analizarJava2.ejecutar(archivo.getText(), tablaSimbolos1, clases1, metodos1, comentarios1, proyecto.getNombreCarpeta1(), archivo.getName());
            //System.out.println(archivo.getText());
        }

        //CICLO PARA EL ANALISIS DE LOS ARCHIVOS DE LA CARPETA 2
        for (FileJava archivo : proyecto.getCarpeta2()) {
            consola.addLog("INICIO DE ANALISIS: "+proyecto.getNombreCarpeta2()+"/"+archivo.getName());
            analizarJava1.ejecutar(archivo.getText(), tablaSimbolos2, clases2, metodos2, comentarios2, proyecto.getNombreCarpeta2(), archivo.getName());
            //System.out.println(archivo.getText());
        }
        
        //CONTROL INTERNO DE LA RECUPERACION DE INFORMACION CARPETA 1
        int numeroVariables1 = tablaSimbolos1.numeroVariables();
        int numeroClases1 = clases1.size();
        int numeroMetodos1 = metodos1.size();
        int numeroComentarios1 = comentarios1.size();
        System.out.println("RESULTADO CARPETA 1");
        System.out.println("Numero Variables: "+numeroVariables1);
        System.out.println("Numero Clases: "+numeroClases1);
        System.out.println("Numero Metodos: "+numeroMetodos1);
        System.out.println("Numero Comentarios: "+numeroComentarios1);
        //CONTROL INTERNO DE LA RECUPERACION DE INFORMACION CARPETA 2
        int numeroVariables2 = tablaSimbolos2.numeroVariables();
        int numeroClases2 = clases2.size();
        int numeroMetodos2 = metodos2.size();
        int numeroComentarios2 = comentarios2.size();
        System.out.println("RESULTADO CARPETA 2");
        System.out.println("Numero Variables: "+numeroVariables2);
        System.out.println("Numero Clases: "+numeroClases2);
        System.out.println("Numero Metodos: "+numeroMetodos2);
        System.out.println("Numero Comentarios: "+numeroComentarios2);
        
        //PROCESADO DE LOS DATOS OBTNEIDOS EN EL ANALISIS
        ResultadoAnalisis analisis1 = new ResultadoAnalisis(clases1, metodos1, comentarios1, tablaSimbolos1);
        ResultadoAnalisis analisis2 = new ResultadoAnalisis(clases2, metodos2, comentarios2, tablaSimbolos2);
        CompararProyectos comparar = new CompararProyectos(analisis1, analisis2);
        String res = comparar.resultadosJson();
        System.out.println(res);
        return res;
    }
}