package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.util.ArrayList;

public class CompararProyectos {
    private ResultadoAnalisis resultadoCarpeta1;
    private ResultadoAnalisis resultadoCarpeta2;
    /**
     * @param resultadoCarpeta1
     * @param resultadoCarpeta2
     */
    public CompararProyectos(ResultadoAnalisis resultadoCarpeta1, ResultadoAnalisis resultadoCarpeta2) {
        this.resultadoCarpeta1 = resultadoCarpeta1;
        this.resultadoCarpeta2 = resultadoCarpeta2;
    }
    /**
     * @return the resultadoCarpeta1
     */
    public ResultadoAnalisis getResultadoCarpeta1() {
        return resultadoCarpeta1;
    }
    /**
     * @param resultadoCarpeta1 the resultadoCarpeta1 to set
     */
    public void setResultadoCarpeta1(ResultadoAnalisis resultadoCarpeta1) {
        this.resultadoCarpeta1 = resultadoCarpeta1;
    }
    /**
     * @return the resultadoCarpeta2
     */
    public ResultadoAnalisis getResultadoCarpeta2() {
        return resultadoCarpeta2;
    }
    /**
     * @param resultadoCarpeta2 the resultadoCarpeta2 to set
     */
    public void setResultadoCarpeta2(ResultadoAnalisis resultadoCarpeta2) {
        this.resultadoCarpeta2 = resultadoCarpeta2;
    }

    public String resultadosJson(){
        String resultado = "";
        ReporteJson reporteJson = new ReporteJson();
        String score;
        ArrayList<Clase> clases=new ArrayList<>();
        ArrayList<Variable> variables = new ArrayList<>();
        ArrayList<Metodo> metodos = new ArrayList<>();
        ArrayList<Comentario> comentarios = new ArrayList<>();
        this.obtenerMetodosRepetidos(metodos);
        this.obtenerComentariosRepetidos(comentarios);
        this.obtenerClasesRepetidos(clases);
        this.obtenerVariablesRepetidas(variables);




        resultado = this.toJsonText(reporteJson);
        return resultado;
    }

    private String toJsonText(ReporteJson reporteJson){
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
    
    private void obtenerMetodosRepetidos(ArrayList<Metodo> metodos){
        for (Metodo metodo : resultadoCarpeta1.getMetodos()) {
            for (Metodo metodo2 : resultadoCarpeta2.getMetodos()) {
                if(metodo!=null && metodo2!=null){
                    if(metodo.equals(metodo2)){
                        metodos.add(metodo);
                    }
                }
            }
        }
    }
    private void obtenerComentariosRepetidos(ArrayList<Comentario> comentarios) {
        for (Comentario comentario : resultadoCarpeta1.getComentarios()) {
            for (Comentario comentario2 : resultadoCarpeta2.getComentarios()) {
                if(comentario!=null && comentario2!=null){
                    comentarios.add(comentario);
                }
            }
        }
    }
    private void obtenerClasesRepetidos(ArrayList<Clase> clases) {
        for (Clase clase : resultadoCarpeta1.getClases()) {
            for (Clase clase2 : resultadoCarpeta2.getClases()) {
                if(clase!=null && clase2!=null){
                    clases.add(clase);
                }
            }
        }
    }
    private void obtenerVariablesRepetidas(ArrayList<Variable> variables) {
        
    }
}
