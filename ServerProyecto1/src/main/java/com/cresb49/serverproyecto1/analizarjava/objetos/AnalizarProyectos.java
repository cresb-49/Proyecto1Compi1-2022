package com.cresb49.serverproyecto1.analizarjava.objetos;
import java.io.File;
import com.cresb49.appcliente.Objetos.*;

public class AnalizarProyectos {

    
    public AnalizarProyectos(){

    }
    public void realizarAnalisis(Proyecto proyecto){

        for (FileJava archivo : proyecto.getCarpeta1()) {
            System.out.println("Archivo Proyecto 1 -> "+archivo.getName());
        }
        for (FileJava archivo : proyecto.getCarpeta2()) {
            System.out.println("Archivo Proyecto 2 -> "+archivo.getName());
        }
    }
}