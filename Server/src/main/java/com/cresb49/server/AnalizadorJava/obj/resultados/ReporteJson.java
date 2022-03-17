package com.cresb49.server.AnalizadorJava.obj.resultados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class ReporteJson implements Serializable{
    private String score;
    private ArrayList<Clase> clases;
    private ArrayList<Variable> variables;
    private ArrayList<Metodo> metodos;
    private ArrayList<Comentario> comentarios;
    
    public ReporteJson(){
        
    }

    public ReporteJson(String score, ArrayList<Clase> clases, ArrayList<Variable> variables, ArrayList<Metodo> metodos, ArrayList<Comentario> comentarios) {
        this.score = score;
        this.clases = clases;
        this.variables = variables;
        this.metodos = metodos;
        this.comentarios = comentarios;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<Metodo> metodos) {
        this.metodos = metodos;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public void imprimirReporte(){
        System.out.println("score: "+this.score);
        System.out.println("------------Clases-----------");
        clases.forEach(clase -> {
            System.out.println(clase.toString());
        });
        System.out.println("------------Variables-----------");
        variables.forEach(variable -> {
            System.out.println(variable.toString());
        });
        System.out.println("------------Metodos-----------");
        metodos.forEach(metodo -> {
            System.out.println(metodo.toString());
        });
        System.out.println("------------Comentarios-----------");
        comentarios.forEach(comentario -> {
            System.out.println(comentario.toString());
        });
    }

    @Override
    public String toString() {
        return "ReporteJson{" + "score=" + score + ", clases=" + clases + ", variables=" + variables + ", metodos=" + metodos + ", comentarios=" + comentarios + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.score);
        hash = 79 * hash + Objects.hashCode(this.clases);
        hash = 79 * hash + Objects.hashCode(this.variables);
        hash = 79 * hash + Objects.hashCode(this.metodos);
        hash = 79 * hash + Objects.hashCode(this.comentarios);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReporteJson other = (ReporteJson) obj;
        if (!Objects.equals(this.score, other.score)) {
            return false;
        }
        if (!Objects.equals(this.clases, other.clases)) {
            return false;
        }
        if (!Objects.equals(this.variables, other.variables)) {
            return false;
        }
        if (!Objects.equals(this.metodos, other.metodos)) {
            return false;
        }
        if (!Objects.equals(this.comentarios, other.comentarios)) {
            return false;
        }
        return true;
    }
}
