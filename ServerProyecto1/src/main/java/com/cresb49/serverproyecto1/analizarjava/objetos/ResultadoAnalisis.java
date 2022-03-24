package com.cresb49.serverproyecto1.analizarjava.objetos;

import java.util.ArrayList;

public class ResultadoAnalisis {
    private ArrayList<Clase> clases;
    private ArrayList<Metodo> metodos;
    private ArrayList<Comentario> comentarios;
    private TablaSimbolos tablaSimbolos;

    /**
     * @param clases
     * @param metodos
     * @param comentarios
     * @param tablaSimbolos
     */
    public ResultadoAnalisis(ArrayList<Clase> clases, ArrayList<Metodo> metodos, ArrayList<Comentario> comentarios,TablaSimbolos tablaSimbolos) {
        this.clases = clases;
        this.metodos = metodos;
        this.comentarios = comentarios;
        this.tablaSimbolos = tablaSimbolos;
    }
    /**
     * @return the clases
     */
    public ArrayList<Clase> getClases() {
        return clases;
    }
    /**
     * @param clases the clases to set
     */
    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }
    /**
     * @return the metodos
     */
    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }
    /**
     * @param metodos the metodos to set
     */
    public void setMetodos(ArrayList<Metodo> metodos) {
        this.metodos = metodos;
    }
    /**
     * @return the comentarios
     */
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    /**
     * @return the tablaSimbolos
     */
    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }
    /**
     * @param tablaSimbolos the tablaSimbolos to set
     */
    public void setTablaSimbolos(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }
    
    public int numeroDeVariables(){
        if(tablaSimbolos==null){
            return 0;
        }else if(tablaSimbolos.getFilas()==null){
            return 0;
        }else{
            return tablaSimbolos.getFilas().size();
        }
    }

    public int numeroClases(){
        if(clases==null){
            return 0;
        }else{
            return clases.size();
        }
    }

    public int numeroComentarios(){
        if(comentarios==null){
            return 0;
        }else{
            return comentarios.size();
        }
    }
    
    public int numeroMetodos(){
        if(metodos==null){
            return 0;
        }else{
            return metodos.size();
        }
    }
    public void imprimirClases(){
        System.out.println("-------------------------CLASES--------------------------");
        for (Clase clase : clases) {
            System.out.println(clase.toString());
        }
    }
    public void imprimirMetodos(){
        System.out.println("-------------------------METODOS--------------------------");
        for (Metodo clase : metodos) {
            System.out.println(clase.toString());
        }
    }
    public void imprimirCometarios(){
        System.out.println("-------------------------COMENTARIOS--------------------------");
        for (Comentario clase : comentarios) {
            System.out.println(clase.toString());
        }
    }
}
