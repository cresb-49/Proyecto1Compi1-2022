package com.cresb49.serverproyecto1.analizarjava.objetos;
import com.cresb49.appcliente.Objetos.*;
import com.cresb49.serverproyecto1.consolecontrol.ConsoleControl;

public class AnalizarProyectos {
    private ConsoleControl consola;

    public AnalizarProyectos(ConsoleControl consola){
        this.consola = consola;
    }
    public void realizarAnalisis(Proyecto proyecto){

        for (FileJava archivo : proyecto.getCarpeta1()) {
            System.out.println(proyecto.getNombreCarpeta1()+" -> "+archivo.getName());
            consola.addLog(proyecto.getNombreCarpeta1()+" -> "+archivo.getName());
            //System.out.println(archivo.getText());
        }

        /*
        tablaSimbolos.imprimirTabla();
        System.err.println("----------------IMPRECION CLASE-------------------");
        for (Clase clase : clases) {
            System.out.println(clase.toString());
        }
        System.err.println("----------------IMPRECION METODO-------------------");
        for (Metodo metodo : metodos) {
            System.out.println(metodo.toString());
            
        }
        System.err.println("----------------IMPRECION COMENTARIOS-------------------");
        for (Comentario comentario : comentarios) {
            System.out.println(comentario.toString());
        }
        */


        for (FileJava archivo : proyecto.getCarpeta2()) {
            System.out.println(proyecto.getNombreCarpeta2()+" -> "+archivo.getName());
            consola.addLog(proyecto.getNombreCarpeta2()+" -> "+archivo.getName());
            //System.out.println(archivo.getText());
        }
    }
}