package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        ArrayList<Clase> clases = new ArrayList<>();
        ArrayList<FilaTablaSymbolos> variables = new ArrayList<>();
        ArrayList<Variable> varFinal = new ArrayList<>();
        ArrayList<Metodo> metodos = new ArrayList<>();
        ArrayList<Comentario> comentarios = new ArrayList<>();
        this.obtenerComentariosRepetidos(comentarios);
        this.obtenerClasesRepetidos(clases);
        this.obtenerVariablesRepetidas(variables);
        this.convertirVariablesRepetidas(variables, varFinal);
        int totalVariables = this.resultadoCarpeta1.numeroDeVariables() + this.resultadoCarpeta2.numeroDeVariables();
        ArrayList<FilaTablaSymbolos> repitencia1 = this.repitenciaAmbosProyectos(resultadoCarpeta1.getTablaSimbolos().getFilas(),resultadoCarpeta2.getTablaSimbolos().getFilas());
        ArrayList<FilaTablaSymbolos> repitencia2 = this.repitenciaTablaFinal(variables);
        //for (FilaTablaSymbolos filaTablaSymbolos : repitencia1) {System.out.println(filaTablaSymbolos);}
        //System.out.println("------------------------------------------------------------------");
        //for (FilaTablaSymbolos filaTablaSymbolos : repitencia2) {System.out.println(filaTablaSymbolos);}
        int varsRepetidas = this.contarVariablesFinal(repitencia1,repitencia2);
        int totalMetodos = this.resultadoCarpeta1.numeroMetodos()+this.resultadoCarpeta2.numeroMetodos();
        this.obtenerMetodosRepetidos(metodos);
        ArrayList<Metodo> repitenciaMetodo1 = this.repitenciaMetodosProyectos(resultadoCarpeta1.getMetodos(),resultadoCarpeta2.getMetodos());
        //for (Metodo metodo : repitenciaMetodo1) {System.out.println(metodo.toString());}
        //System.out.println("------------------------------------------------------------------");
        ArrayList<Metodo> repitenciaMetodo2 = this.repitenciaMetodosProyectos(metodos);
        //for (Metodo metodo : repitenciaMetodo2) {System.out.println(metodo.toString());}
        int metodosRepetidos = this.contarMetodosRepetidos(repitenciaMetodo1,repitenciaMetodo2);
        //System.out.println("------------------------------------------------------------------");
        int totalClases = this.resultadoCarpeta1.numeroClases()+this.resultadoCarpeta2.numeroClases();
        ArrayList<Clase> repitenciaClase1 = this.repitenciaClasesProyecto(resultadoCarpeta1.getClases(),resultadoCarpeta2.getClases());
        ArrayList<Clase> repitenciaClase2 = this.repitenciaClasesProyecto(clases);
        //for (Clase clase : repitenciaClase1) {System.out.println(clase.toString());}
        //System.out.println("------------------------------------------------------------------");
        //for (Clase clase : repitenciaClase2) {System.out.println(clase.toString());}
        int clasesRepetidas = this.contarClasesRepetidas(repitenciaClase1,repitenciaClase2);
        //System.out.println("------------------------------------------------------------------");
        int totalComen = this.resultadoCarpeta1.numeroComentarios()+this.resultadoCarpeta2.numeroComentarios();
        ArrayList<Comentario> repitenciaComentarios1 = this.repitenciaComentariosProyectos(resultadoCarpeta1.getComentarios(),resultadoCarpeta2.getComentarios());
        ArrayList<Comentario> repitenciaComentarios2 = this.repitenciaComentariosProyectos(comentarios);
        //for (Comentario clase : repitenciaComentarios1) {System.out.println(clase.toString());}
        //System.out.println("------------------------------------------------------------------");
        //for (Comentario clase : repitenciaComentarios2) {System.out.println(clase.toString());}
        int comenrepetidos = this.contarComentariosRepetidos(repitenciaComentarios1,repitenciaComentarios2);
        //System.out.println("------------------------------------------------------------------");
        System.out.println("clasesTotales: " + totalClases);
        System.out.println("clasesRepetidas: " + clasesRepetidas);
        System.out.println("varsTotales: " + totalVariables);
        System.out.println("varsRepetidas: " + varsRepetidas);
        System.out.println("metodosTotales: " + totalMetodos);
        System.out.println("metodosRepetidos: " + metodosRepetidos);
        System.out.println("comenTotales: " + totalComen);
        System.out.println("comenrepetidos: " + comenrepetidos);
        String score = this.carlcularScore(totalVariables, varsRepetidas, totalMetodos, metodosRepetidos, totalClases,
                clasesRepetidas, totalComen, comenrepetidos);
        ReporteJson reporteJson = new ReporteJson(score, clases, varFinal, metodos, comentarios);
        resultado = this.toJsonText(reporteJson);
        return resultado;
    }

    

    private String carlcularScore(int totalVariables, int varsRepetidas, int totalMetodos, int metodosRepetidos,
            int totalClases, int clasesRepetidas, int totalComen, int comenrepetidos) {
        System.out.println("Score:");
        if(totalVariables==0){
            totalVariables=1;
        }if(totalMetodos==0){
            totalMetodos=1;
        }if(totalClases==0){
            totalClases=1;
        }if(totalComen==0){
            totalComen=1;
        }
        BigDecimal termV1 = BigDecimal.valueOf(varsRepetidas);
        BigDecimal termV2 = BigDecimal.valueOf(totalVariables);
        BigDecimal resultVars = termV1.divide(termV2, 4, RoundingMode.CEILING);
        BigDecimal termM1 = BigDecimal.valueOf(metodosRepetidos);
        BigDecimal termM2 = BigDecimal.valueOf(totalMetodos);
        BigDecimal resultMetodos = termM1.divide(termM2, 4, RoundingMode.CEILING);
        BigDecimal termC1 = BigDecimal.valueOf(clasesRepetidas);
        BigDecimal termC2 = BigDecimal.valueOf(totalClases);
        BigDecimal resultClases = termC1.divide(termC2, 4, RoundingMode.CEILING);
        BigDecimal termCo1 = BigDecimal.valueOf(comenrepetidos);
        BigDecimal termCo2 = BigDecimal.valueOf(totalComen);
        BigDecimal resultComen = termCo1.divide(termCo2, 4, RoundingMode.CEILING);
        BigDecimal finalResult = resultVars.add(resultMetodos.add(resultClases).add(resultComen));
        finalResult = finalResult.multiply(BigDecimal.valueOf(0.25));
        System.out.println(finalResult);
        return String.format("%.4f",finalResult.doubleValue());
    }
    /*
    private int contarVariablesFinal(ArrayList<FilaTablaSymbolos> variables) {
        int result = 0;
        for (FilaTablaSymbolos filaTablaSymbolos : variables) {
            if (filaTablaSymbolos != null) {
                result = result + filaTablaSymbolos.getRepeticiones();
            }
        }
        return result;
    }
    */
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
                    + reporteJson.getMetodos().get(i).getParametros().size() + "}");
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
        
        Metodo metodoRepetido = null;
        boolean bandera = false;
        for (Metodo metodo : resultadoCarpeta1.getMetodos()) {
            bandera = false;
            metodoRepetido = new Metodo(metodo.getNombre(), metodo.getTipo());
            metodoRepetido.setParametros(metodo.getParametros());
            for (Metodo metodo1 : resultadoCarpeta2.getMetodos()) {
                if(metodo.compararMetodos(metodo1)){
                    bandera = true;
                    metodoRepetido.agregarRepeticion();
                }
            }
            if(bandera){
                metodos.add(metodoRepetido);
            }
        }        
        /*
        Metodo tmp1 = null;
        Metodo tmp2 = null;
        Metodo newtmp = null;
        for (Metodo metodo : resultadoCarpeta1.getMetodos()) {
            if (metodo != null) {
                tmp1 = buscarListaMetodos(resultadoCarpeta2.getMetodos(), metodo);
                if (tmp1!=null) {
                    tmp2 = buscarListaMetodos(metodos, metodo);
                    if (tmp2==null) {
                        newtmp = new Metodo(metodo.getNombre(),metodo.getTipo(),metodo.getParametros());
                        newtmp.setRepeticiones(metodo.getRepeticiones()+tmp1.getRepeticiones());
                        metodos.add(newtmp);
                    }else{
                        tmp2.mezclarRepeticiones(metodo.getRepeticiones());
                    }
                }
            }
        }*/
    }

    private Metodo buscarListaMetodos(ArrayList<Metodo> metodos, Metodo metodo) {
        for (Metodo met : metodos) {
            if (met.compararMetodos(metodo)) {
                return met;
            }
        }
        return null;
    }

    private void obtenerComentariosRepetidos(ArrayList<Comentario> comentarios) {
        Comentario comentarioRepetido = null;
        boolean bandera = false;
        for (Comentario comentario : resultadoCarpeta1.getComentarios()) {
            bandera = false;
            comentarioRepetido = new Comentario(comentario.getTexto());
            for (Comentario metodo1 : resultadoCarpeta2.getComentarios()) {
                if(comentario.equals(metodo1)){
                    bandera = true;
                    comentarioRepetido.agregarRepeticion();
                }
            }
            if(bandera){
                comentarios.add(comentarioRepetido);
            }
        } 
        
        /*
        Comentario tmp1 = null;
        Comentario tmp2 = null;
        Comentario newtmp = null;
        for (Comentario comentario : resultadoCarpeta1.getComentarios()) {
            if (comentario != null) {
                tmp1 = buscarListaComentario(resultadoCarpeta2.getComentarios(), comentario);
                if (tmp1!=null) {
                    tmp2 =buscarListaComentario(comentarios, comentario);
                    if (tmp2==null) {
                        newtmp = new Comentario(comentario.getTexto());
                        newtmp.setRepeticiones(comentario.getRepeticiones()+tmp1.getRepeticiones());
                        comentarios.add(newtmp);
                    }else{
                        tmp2.mezclarRepeticiones(comentario.getRepeticiones());
                    }
                }
            }
        }
        */
    }

    private Comentario buscarListaComentario(ArrayList<Comentario> comentarios, Comentario comentario) {
        for (Comentario comt : comentarios) {
            if (comt.equals(comentario)) {
                return comt;
            }
        }
        return null;
    }

    private void obtenerClasesRepetidos(ArrayList<Clase> clases) {
        Clase claseRepetido = null;
        Clase claseR = null;
        boolean bandera = false;
        for (Clase comentario : resultadoCarpeta1.getClases()) {
            bandera = false;
            claseRepetido = new Clase(comentario.getNombre(),comentario.getFunciones());
            for (Clase metodo1 : resultadoCarpeta2.getClases()) {
                if(comentario.compararClases(metodo1)){
                    bandera = true;
                    claseRepetido.agregarRepeticion();
                }
            }
            if(bandera){
                clases.add(claseRepetido);
            }
        }
        /*
        Clase tmp1 = null;
        Clase tmp2 = null;
        Clase newtmp = null;
        for (Clase clase : resultadoCarpeta1.getClases()) {
            if (clase != null) {
                tmp1 = buscarListaClases(resultadoCarpeta2.getClases(), clase);
                if (tmp1!=null) {
                    tmp2 = buscarListaClases(clases, clase);
                    if (tmp2==null) {
                        newtmp = new Clase(clase.getNombre());
                        newtmp.setRepeticiones(clase.getRepeticiones()+tmp1.getRepeticiones());
                        clases.add(newtmp);
                    }else{
                        tmp2.mezclarRepeticiones(clase.getRepeticiones());
                    }
                }
            }
        }
        */
    }

    private Clase buscarListaClases(ArrayList<Clase> calses, Clase clase) {
        for (Clase clas : calses) {
            if (clas.compararClases(clase)) {
                return clas;
            }
        }
        return null;
    }

    private void obtenerVariablesRepetidas(ArrayList<FilaTablaSymbolos> variables) {
        FilaTablaSymbolos filatemp;
        FilaTablaSymbolos filatemp2;
        FilaTablaSymbolos variableRepetida=null;
        boolean bandera = false;
        for (FilaTablaSymbolos varProyecto1 : resultadoCarpeta1.getTablaSimbolos().getFilas()) {
            bandera = false;
            variableRepetida = new FilaTablaSymbolos(varProyecto1.getNombre(), varProyecto1.getTipo());
            for (String funcione : varProyecto1.getFunciones()) {
                variableRepetida.agregarFuncion(funcione);
            }
            for (FilaTablaSymbolos varProyecto2 : resultadoCarpeta2.getTablaSimbolos().getFilas()) {
                if(varProyecto2.igualdadTipoNombre(varProyecto1)){
                    bandera = true;
                    for (String funcione : varProyecto2.getFunciones()) {
                        variableRepetida.agregarFuncion(funcione);
                    }
                }
            }
            if(bandera){
                if(variableRepetida!=null){
                    variables.add(variableRepetida);
                }
            }
        }
        /*
        for (FilaTablaSymbolos filaTabla : resultadoCarpeta1.getTablaSimbolos().getFilas()) {
            if (filaTabla != null) {
                filatemp = resultadoCarpeta2.getTablaSimbolos().buscarNombreTipo(filaTabla.getNombre(),
                        filaTabla.getTipo());
                if (filatemp != null) {
                    filatemp2 = this.recuperarVariable(filaTabla.getNombre(), filaTabla.getTipo(), variables);
                    if (filatemp2 == null) {
                        variableRepetida = new FilaTablaSymbolos(filaTabla.getNombre(), filaTabla.getTipo());
                        variableRepetida.setFunciones(
                                this.mezaclarFunciones(filatemp.getFunciones(), filaTabla.getFunciones()));
                        variables.add(variableRepetida);
                        variableRepetida.setRepeticiones(filaTabla.getRepeticiones() + filatemp.getRepeticiones());

                    } else {
                        filatemp2.setFunciones(this.mezaclarFunciones(filaTabla.getFunciones(),
                                this.mezaclarFunciones(filatemp.getFunciones(), filatemp2.getFunciones())));
                        filatemp2.mezaclarRepeteciones(filatemp.getRepeticiones());
                    }
                }
            }
        }*/
    }

    private void convertirVariablesRepetidas(ArrayList<FilaTablaSymbolos> variables, ArrayList<Variable> varFinal) {
        variables.stream().filter(filaTablaSymbolos -> (filaTablaSymbolos != null)).forEachOrdered(filaTablaSymbolos -> {
            varFinal.add(new Variable(filaTablaSymbolos.getNombre(), filaTablaSymbolos.getTipo(),
                    this.obtenerFuncionesVariables(filaTablaSymbolos.getFunciones())));
        });
    }

    private String obtenerFuncionesVariables(ArrayList<String> funciones) {
        String text = "";
        if (funciones.isEmpty()) {
            return "No-funciones";
        }
        for (int i = 0; i < funciones.size(); i++) {
            if (i == 0) {
                text = text + funciones.get(i);
            } else {
                text = text + ", " + funciones.get(i);
            }
        }
        return text;
    }

    private ArrayList<FilaTablaSymbolos> repitenciaAmbosProyectos(ArrayList<FilaTablaSymbolos> filas, ArrayList<FilaTablaSymbolos> filas0) {
        ArrayList<FilaTablaSymbolos> tmp = new ArrayList<>();
        ArrayList<FilaTablaSymbolos> resultfinal = new ArrayList<>();
        FilaTablaSymbolos filatmp = null;
        tmp.addAll(filas);
        tmp.addAll(filas0);
        for (FilaTablaSymbolos tmp1 : tmp) {
            filatmp = this.buscarVariable(tmp1.getNombre(),tmp1.getTipo(),resultfinal);
            if(filatmp!=null){
                filatmp.agregarRepeticion();
            }else{
                resultfinal.add(new FilaTablaSymbolos(tmp1.getNombre(), tmp1.getTipo()));
            }
        }
        return resultfinal;
    }

    private ArrayList<FilaTablaSymbolos> repitenciaTablaFinal(ArrayList<FilaTablaSymbolos> variables) {
        ArrayList<FilaTablaSymbolos> resultfinal = new ArrayList<>();
        FilaTablaSymbolos filatmp = null;
        for (FilaTablaSymbolos tmp1 : variables) {
            filatmp = this.buscarVariable(tmp1.getNombre(),tmp1.getTipo(),resultfinal);
            if(filatmp==null){
                resultfinal.add(new FilaTablaSymbolos(tmp1.getNombre(), tmp1.getTipo()));
            }
        }
        return resultfinal;
    }

    private FilaTablaSymbolos buscarVariable(String nombre, String tipo, ArrayList<FilaTablaSymbolos> resultfinal) {
        for (FilaTablaSymbolos filaTablaSymbolos : resultfinal) {
            if(filaTablaSymbolos.getNombre().equals(nombre)&&filaTablaSymbolos.getTipo().equals(tipo)){
                return filaTablaSymbolos;
            }
        }
        return  null;
    }

    private int contarVariablesFinal(ArrayList<FilaTablaSymbolos> repitencia1, ArrayList<FilaTablaSymbolos> repitencia2) {
        int result = 0;
        FilaTablaSymbolos tmp = null;
        for (FilaTablaSymbolos filaTablaSymbolos : repitencia2) {
            tmp = this.buscarVariable(filaTablaSymbolos.getNombre(), filaTablaSymbolos.getTipo(),repitencia1);
            if(tmp!=null){
                result = result + tmp.getRepeticiones();
            }
        }
        return  result;
    }

    private ArrayList<Metodo> repitenciaMetodosProyectos(ArrayList<Metodo> metodos, ArrayList<Metodo> metodos0) {
        ArrayList<Metodo> tmp = new ArrayList<>();
        ArrayList<Metodo> resultFinal = new ArrayList<>();
        Metodo metodoTmp = null;
        tmp.addAll(metodos);
        tmp.addAll(metodos0);
        for (Metodo tmp1 : tmp) {
            metodoTmp = this.buscarListaMetodos(resultFinal,tmp1);
            if(metodoTmp!=null){
                metodoTmp.agregarRepeticion();
            }else{
                resultFinal.add(new Metodo(tmp1.getNombre(), tmp1.getTipo(), tmp1.getParametros()));
            }
        }
        return resultFinal;
    }

    private ArrayList<Metodo> repitenciaMetodosProyectos(ArrayList<Metodo> metodos) {
        ArrayList<Metodo> resultfinal = new ArrayList<>();
        Metodo metodoTmp = null;
        for (Metodo tmp1 : metodos) {
            metodoTmp = this.buscarListaMetodos(resultfinal,tmp1);
            if(metodoTmp==null){
                resultfinal.add(new Metodo(tmp1.getNombre(), tmp1.getTipo(), tmp1.getParametros()));
            }
        }
        return resultfinal;
    }

    private int contarMetodosRepetidos(ArrayList<Metodo> repitenciaMetodo1, ArrayList<Metodo> repitenciaMetodo2) {
        int result = 0;
        Metodo metodoTmp = null;
        for (Metodo filaTablaSymbolos : repitenciaMetodo2) {
            metodoTmp = this.buscarListaMetodos(repitenciaMetodo1,filaTablaSymbolos);
            if(metodoTmp!=null){
                result = result + metodoTmp.getRepeticiones();
            }
        }
        return  result;
    }

    private ArrayList<Clase> repitenciaClasesProyecto(ArrayList<Clase> clases, ArrayList<Clase> clases0) {
        ArrayList<Clase> tmp = new ArrayList<>();
        ArrayList<Clase> resultFinal = new ArrayList<>();
        Clase claseTmp = null;
        tmp.addAll(clases);
        tmp.addAll(clases0);
        for (Clase tmp1 : tmp) {
            claseTmp = this.buscarListaClases(resultFinal, tmp1);
            if(claseTmp!=null){
                claseTmp.agregarRepeticion();
            }else{
                resultFinal.add(new Clase(tmp1.getNombre(),tmp1.getFunciones()));
            }
        }
        return resultFinal;
    }

    private ArrayList<Clase> repitenciaClasesProyecto(ArrayList<Clase> clases) {
        ArrayList<Clase> resultfinal = new ArrayList<>();
        Clase claseTmp = null;
        for (Clase tmp1 : clases) {
            claseTmp = this.buscarListaClases(resultfinal,tmp1);
            if(claseTmp==null){
                resultfinal.add(new Clase(tmp1.getNombre(),tmp1.getFunciones()));
            }
        }
        return resultfinal;
    }

    private int contarClasesRepetidas(ArrayList<Clase> repitenciaClase1, ArrayList<Clase> repitenciaClase2) {
        int result = 0;
        Clase claseTmp = null;
        for (Clase filaTablaSymbolos : repitenciaClase2) {
            claseTmp = this.buscarListaClases(repitenciaClase1,filaTablaSymbolos);
            if(claseTmp!=null){
                result = result + claseTmp.getRepeticiones();
            }
        }
        return  result;
    }

    private ArrayList<Comentario> repitenciaComentariosProyectos(ArrayList<Comentario> comentarios, ArrayList<Comentario> comentarios0) {
        ArrayList<Comentario> tmp = new ArrayList<>();
        ArrayList<Comentario> resultFinal = new ArrayList<>();
        Comentario comentarioTmp = null;
        tmp.addAll(comentarios);
        tmp.addAll(comentarios0);
        for (Comentario tmp1 : tmp) {
            comentarioTmp = this.buscarListaComentario(resultFinal, tmp1);
            if(comentarioTmp!=null){
                comentarioTmp.agregarRepeticion();
            }else{
                resultFinal.add(new Comentario(tmp1.getTexto()));
            }
        }
        return resultFinal;
    }

    private ArrayList<Comentario> repitenciaComentariosProyectos(ArrayList<Comentario> comentarios) {
        ArrayList<Comentario> resultfinal = new ArrayList<>();
        Comentario comentarioTmp = null;
        for (Comentario tmp1 : comentarios) {
            comentarioTmp = this.buscarListaComentario(resultfinal,tmp1);
            if(comentarioTmp==null){
                resultfinal.add(new Comentario(tmp1.getTexto()));
            }
        }
        return resultfinal;
    }

    private int contarComentariosRepetidos(ArrayList<Comentario> repitenciaComentarios1, ArrayList<Comentario> repitenciaComentarios2) {
        int result = 0;
        Comentario comentarioTmp = null;
        for (Comentario filaTablaSymbolos : repitenciaComentarios2) {
            comentarioTmp = this.buscarListaComentario(repitenciaComentarios1,filaTablaSymbolos);
            if(comentarioTmp!=null){
                result = result + comentarioTmp.getRepeticiones();
            }
        }
        return  result;
    }

}


/*
    private int contarComentariosRepetidos(ArrayList<Comentario> comentarios) {
        int result =0;
        for (Comentario comentario : comentarios) {
            result = result + comentario.getRepeticiones();
        }
        return result;
    }

    private int contarClasesRepetidas(ArrayList<Clase> clases) {
        int result = 0;
        for (Clase clase : clases) {
            result = result + clase.getRepeticiones();
        }
        return result;
    }

    private int contarMetodosRepetidos(ArrayList<Metodo> metodos) {
        int result =0;
        for (Metodo metodo : metodos) {
            result = result + metodo.getRepeticiones();
        }
        return result;
    }
     private FilaTablaSymbolos recuperarVariable(String nombre, String tipo, ArrayList<FilaTablaSymbolos> variables) {
        for (FilaTablaSymbolos filaTablaSymbolos : variables) {
            if (filaTablaSymbolos.getNombre().equals(nombre) && filaTablaSymbolos.getTipo().equals(tipo)) {
                return filaTablaSymbolos;
            }
        }
        return null;
    }

    private ArrayList<String> mezaclarFunciones(ArrayList<String> funciones, ArrayList<String> funciones2) {
        ArrayList<String> funcionesResulttmp = new ArrayList<>();
        ArrayList<String> funcionesResult = new ArrayList<>();
        if (funciones != null) {
            funcionesResulttmp.addAll(funciones);
        }
        if (funciones2 != null) {
            funcionesResulttmp.addAll(funciones2);
        }
        boolean found = false;
        for (String string : funcionesResulttmp) {
            found = false;
            for (String string2 : funcionesResult) {
                if (string.equals(string2)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                funcionesResult.add(string);
            }
        }
        return funcionesResult;
    }

*/