package com.cresb49.server.Objetos;

import java.io.Serializable;
import java.util.ArrayList;

import com.cresb49.server.AnalizadorJava.obj.resultados.*;

public class ConvertirJson implements Serializable{
    public ConvertirJson(){

    }
    public static String toJsonText(ReporteJson reporteJson){
        StringBuilder json = new StringBuilder();

        json.append("{"+"\n");
        json.append("Score: \""+reporteJson.getScore()+"\"\n");
        json.append("Clases: ["+"\n");
        for (Clase clase : reporteJson.getClases()) {
            json.append("     {Nombre: \""+clase.getNombre()+"\"}\n");
        }
        json.append("],"+"\n");
        json.append("Variables: ["+"\n");
        for (Variable variable : reporteJson.getVariables()) {
            json.append("     {Nombre: \""+variable.getNombre()+"\" Tipo: \""+variable.getTipo()+"\" Funcion: \""+variable.getFuncion()+"\"}\n");
        }
        json.append("],"+"\n");
        json.append("Metodos: ["+"\n");
        for (Metodo metodo : reporteJson.getMetodos()) {
            json.append("     {Nombre: \""+metodo.getNombre()+"\" Tipo: \""+metodo.getTipo()+"\" Parametros: \""+metodo.getParametros()+"\"}\n");
        }
        json.append("],"+"\n");
        json.append("Comentarios: ["+"\n");
        for (Comentario comentario : reporteJson.getComentarios()) {
            json.append("     {Texto: \""+comentario.getTexto()+"}\n");
        }
        json.append("]"+"\n");
        return json.toString();
    }
}
