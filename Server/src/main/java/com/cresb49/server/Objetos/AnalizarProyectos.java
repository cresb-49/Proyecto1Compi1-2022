package com.cresb49.server.Objetos;

import java.io.File;

public class AnalizarProyectos {
    public AnalizarProyectos(){

    }
    public void realizarAnalisis(CompararProyectos compararProyectos){
        for (File archivo : compararProyectos.getCarpeta1().listFiles()) {
            System.out.println("Archivo Proyecto 1 -> "+archivo.getName());
        }
        for (File archivo : compararProyectos.getCarpeta2().listFiles()) {
            System.out.println("Archivo Proyecto 2 -> "+archivo.getName());
        }
    }
}
