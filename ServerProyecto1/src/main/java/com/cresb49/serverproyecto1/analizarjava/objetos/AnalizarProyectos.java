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
        for (FileJava archivo : proyecto.getCarpeta2()) {
            System.out.println(proyecto.getNombreCarpeta2()+" -> "+archivo.getName());
            consola.addLog(proyecto.getNombreCarpeta2()+" -> "+archivo.getName());
            //System.out.println(archivo.getText());
        }
    }
}