package com.cresb49.server.Objetos;

import java.io.Serializable;

import com.cresb49.server.AnalizadorJava.obj.resultados.*;

public class ConvertirJson implements Serializable{
    public ConvertirJson(){

    }
    public static String toJsonText(ReporteJson reporteJson){
        StringBuilder json = new StringBuilder();

        json.append("{"+"\n");
        json.append("Score: \""+reporteJson.getScore()+"\"\n");
        json.append("Clases: ["+"\n");
        for (int i = 0; i < reporteJson.getClases().size(); i++) {
            json.append("     {Nombre: \""+reporteJson.getClases().get(i).getNombre()+"\"}");
            if(reporteJson.getClases().size()>=2){
                if(i < (reporteJson.getClases().size()-1)){
                    json.append(",\n");
                }else{
                    json.append("\n");
                }
            }else{
                json.append("\n");
            }
        }
        json.append("],"+"\n");
        json.append("Variables: ["+"\n");

        for (int i = 0; i < reporteJson.getVariables().size(); i++) {
            json.append("     {Nombre: \""+reporteJson.getVariables().get(i).getNombre()+"\" Tipo: \""+reporteJson.getVariables().get(i).getTipo()+"\" Funcion: \""+reporteJson.getVariables().get(i).getFuncion()+"\"}\n");
            if(reporteJson.getVariables().size()>=2){
                if(i < (reporteJson.getVariables().size()-1)){
                    json.append(",\n");
                }else{
                    json.append("\n");
                }
            }else{
                json.append("\n");
            }
        }

        json.append("],"+"\n");
        json.append("Metodos: ["+"\n");

        for (int i = 0; i < reporteJson.getMetodos().size(); i++) {
            json.append("     {Nombre: \""+reporteJson.getMetodos().get(i).getNombre()+"\" Tipo: \""+reporteJson.getMetodos().get(i).getTipo()+"\" Parametros: \""+reporteJson.getMetodos().get(i).getParametros()+"\"}\n");
            if(reporteJson.getMetodos().size()>=2){
                if(i < (reporteJson.getMetodos().size()-1)){
                    json.append(",\n");
                }else{
                    json.append("\n");
                }
            }else{
                json.append("\n");
            }
        }

        json.append("],"+"\n");
        json.append("Comentarios: ["+"\n");

        for (int i = 0; i < reporteJson.getComentarios().size(); i++) {
            json.append("     {Texto: \""+reporteJson.getComentarios().get(i).getTexto()+"}\n");
            if(reporteJson.getComentarios().size()>=2){
                if(i < (reporteJson.getComentarios().size()-1)){
                    json.append(",\n");
                }else{
                    json.append("\n");
                }
            }else{
                json.append("\n");
            }
        }
        json.append("]"+"\n");
        return json.toString();
    }
}
