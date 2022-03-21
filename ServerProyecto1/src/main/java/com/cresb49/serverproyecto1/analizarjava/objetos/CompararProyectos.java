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

    public String resultadosJson() {
        String resultado = "";
        String score;
        ArrayList<Clase> clases = new ArrayList<>();
        ArrayList<FilaTablaSymbolos> variables = new ArrayList<>();
        ArrayList<Variable> varFinal = new ArrayList<>();
        ArrayList<Metodo> metodos = new ArrayList<>();
        ArrayList<Comentario> comentarios = new ArrayList<>();
        this.obtenerMetodosRepetidos(metodos);
        this.obtenerComentariosRepetidos(comentarios);
        this.obtenerClasesRepetidos(clases);
        this.obtenerVariablesRepetidas(variables);
        this.convertirVariablesRepetidas(variables,varFinal);
        float scoreValue = ((comentarios.size()
                / (resultadoCarpeta1.getComentarios().size() + resultadoCarpeta2.getComentarios().size()))
                + (variables.size() / (resultadoCarpeta1.getTablaSimbolos().numeroVariables()
                        + resultadoCarpeta2.getTablaSimbolos().numeroVariables()))
                + (metodos.size() / (resultadoCarpeta1.getMetodos().size() + resultadoCarpeta2.getMetodos().size()))
                + (clases.size() / (resultadoCarpeta1.getClases().size() + resultadoCarpeta2.getClases().size())));
        score = String.valueOf(scoreValue);
        ReporteJson reporteJson = new ReporteJson(score, clases, varFinal, metodos, comentarios);
        resultado = this.toJsonText(reporteJson);
        return resultado;
    }

    private String toJsonText(ReporteJson reporteJson) {
        StringBuilder json = new StringBuilder();
        json.append("{" + "\n");
        json.append("Score: \"" + reporteJson.getScore() + "\",\n");
        json.append("Clases: [" + "\n");
        for (int i = 0; i < reporteJson.getClases().size(); i++) {
            json.append("\t{Nombre: \"" + reporteJson.getClases().get(i).getNombre() + "\"}");
            if (reporteJson.getClases().size() >= 2) {
                if (i < (reporteJson.getClases().size() - 1)) {
                    json.append(",\n");
                } else {
                    json.append("\n");
                }
            } else {
                json.append("\n");
            }
        }
        json.append("]," + "\n");
        json.append("Variables: [" + "\n");

        for (int i = 0; i < reporteJson.getVariables().size(); i++) {
            json.append("\t{Nombre: \"" + reporteJson.getVariables().get(i).getNombre() + "\", Tipo: \""
                    + reporteJson.getVariables().get(i).getTipo() + "\", Funcion: \""
                    + reporteJson.getVariables().get(i).getFuncion() + "\"}");
            if (reporteJson.getVariables().size() >= 2) {
                if (i < (reporteJson.getVariables().size() - 1)) {
                    json.append(",\n");
                } else {
                    json.append("\n");
                }
            } else {
                json.append("\n");
            }
        }
        json.append("]," + "\n");
        json.append("Metodos: [" + "\n");
        for (int i = 0; i < reporteJson.getMetodos().size(); i++) {
            json.append("\t{Nombre: \"" + reporteJson.getMetodos().get(i).getNombre() + "\", Tipo: \""
                    + reporteJson.getMetodos().get(i).getTipo() + "\", Parametros: "
                    + reporteJson.getMetodos().get(i).getParametros() + "}");
            if (reporteJson.getMetodos().size() >= 2) {
                if (i < (reporteJson.getMetodos().size() - 1)) {
                    json.append(",\n");
                } else {
                    json.append("\n");
                }
            } else {
                json.append("\n");
            }
        }
        json.append("]," + "\n");
        json.append("Comentarios: [" + "\n");
        for (int i = 0; i < reporteJson.getComentarios().size(); i++) {
            json.append("\t{Texto: \"" + reporteJson.getComentarios().get(i).getTexto() + "\"}");
            if (reporteJson.getComentarios().size() >= 2) {
                if (i < (reporteJson.getComentarios().size() - 1)) {
                    json.append(",\n");
                } else {
                    json.append("\n");
                }
            } else {
                json.append("\n");
            }
        }
        json.append("]" + "\n");
        json.append("}");
        return json.toString();
    }

    private void obtenerMetodosRepetidos(ArrayList<Metodo> metodos) {
        for (Metodo metodo : resultadoCarpeta1.getMetodos()) {
            if (metodo != null) {
                if(this.buscarListaMetodos(resultadoCarpeta2.getMetodos(), metodo)){
                    if(!this.buscarListaMetodos(metodos, metodo)){
                        metodos.add(metodo);
                    }
                }
            }
            /*for (Metodo metodo2 : resultadoCarpeta2.getMetodos()) {
            }*/
        }
    }

    private boolean buscarListaMetodos(ArrayList<Metodo> metodos,Metodo metodo){
        for (Metodo met : metodos) {
            if(met.equals(metodo)){
                return true;
            }
        }
        return false;
    }

    private void obtenerComentariosRepetidos(ArrayList<Comentario> comentarios) {
        for (Comentario comentario : resultadoCarpeta1.getComentarios()) {
            if (comentario != null) {
                if(this.buscarListaComentario(resultadoCarpeta2.getComentarios(), comentario)){
                    if(!this.buscarListaComentario(comentarios, comentario)){
                        comentarios.add(comentario);
                    }
                }
            }
            /*
            for (Comentario comentario2 : resultadoCarpeta2.getComentarios()) {
            }*/
        }
    }

    private boolean buscarListaComentario(ArrayList<Comentario> comentarios,Comentario comentario){
        for (Comentario comt : comentarios) {
            if(comt.equals(comentario)){
                return true;
            }
        }
        return false;
    }


    private void obtenerClasesRepetidos(ArrayList<Clase> clases) {
        for (Clase clase : resultadoCarpeta1.getClases()) {
            if (clase != null) {
                if(this.buscarListaClases(resultadoCarpeta2.getClases(), clase)){
                    if(!this.buscarListaClases(clases, clase)){
                        clases.add(clase);
                    }
                }
            }
            /*for (Clase clase2 : resultadoCarpeta2.getClases()) {
            }*/
        }
    }

    private boolean buscarListaClases(ArrayList<Clase> calses,Clase clase){
        for (Clase clas : calses) {
            if(clas.equals(clase)){
                return true;
            }
        }
        return false;
    }

    private void obtenerVariablesRepetidas(ArrayList<FilaTablaSymbolos> variables) {
        FilaTablaSymbolos filatemp;
        FilaTablaSymbolos filatemp2;
        FilaTablaSymbolos variableRepetida;
        for (FilaTablaSymbolos filaTabla : resultadoCarpeta1.getTablaSimbolos().getFilas()) {
            if(filaTabla!=null){
                filatemp = resultadoCarpeta2.getTablaSimbolos().buscarNombreTipo(filaTabla.getNombre(), filaTabla.getTipo());
                if(filatemp!=null){
                    filatemp2 =  this.recuperarVariable(filaTabla.getNombre(), filaTabla.getTipo(),variables);
                    if(filatemp2==null){
                        variableRepetida = new FilaTablaSymbolos(filaTabla.getNombre(), filaTabla.getTipo());
                        variableRepetida.setFunciones(this.mezaclarFunciones(filatemp.getFunciones(),filaTabla.getFunciones()));
                        variables.add(variableRepetida);
                    }else{
                        filatemp2.setFunciones(this.mezaclarFunciones(filaTabla.getFunciones(),this.mezaclarFunciones(filatemp.getFunciones(),filatemp2.getFunciones())));
                    }
                }
            }
        }
    }

    private FilaTablaSymbolos recuperarVariable(String nombre, String tipo, ArrayList<FilaTablaSymbolos> variables) {
        for (FilaTablaSymbolos filaTablaSymbolos : variables) {
            if(filaTablaSymbolos.getNombre().equals(nombre)&&filaTablaSymbolos.getTipo().equals(tipo)){
                return filaTablaSymbolos;
            }
        }
        return null;
    }

    private ArrayList<String> mezaclarFunciones(ArrayList<String> funciones, ArrayList<String> funciones2) {
        ArrayList<String> funcionesResult = new ArrayList<>();
        boolean found = false;
        for (String newfuncion : funciones) {
            found = false;
            for (String string : funciones2) {
                if(newfuncion!=null && string!=null){
                    if(newfuncion.equals(string)){
                        found = true;
                        break;
                    }
                }
            }
            if(found == false){
                funcionesResult.add(newfuncion);
            }
        }
        return funcionesResult;
    }

    private void convertirVariablesRepetidas(ArrayList<FilaTablaSymbolos> variables, ArrayList<Variable> varFinal) {
        for (FilaTablaSymbolos filaTablaSymbolos : variables) {
            if(filaTablaSymbolos!=null){
                varFinal.add(new Variable(filaTablaSymbolos.getNombre(), filaTablaSymbolos.getTipo(), this.obtenerFuncionesVariables(filaTablaSymbolos.getFunciones())));
            }
        }
    }

    private String obtenerFuncionesVariables(ArrayList<String> funciones) {
        String text="";
        if(funciones.isEmpty()){
            return "No-funciones";
        }
        for (int i = 0; i < funciones.size(); i++) {
            if(i==1){
                text = text + funciones.get(i);
            }else{
                text = text + ", "+funciones.get(i);
            }
        }
        return text;
    }
}
