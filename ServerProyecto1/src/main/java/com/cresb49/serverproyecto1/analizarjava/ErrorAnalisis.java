package com.cresb49.serverproyecto1.analizarjava;

public class ErrorAnalisis {
    private String tipo;
    private String lexema;
    private int linea;
    private int columna;
    private String descipcion;

    public ErrorAnalisis(String tipo, String lexema, int linea, int columna, String descipcion) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.descipcion = descipcion;
    }

    public ErrorAnalisis() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    @Override
    public String toString() {
        return "ErrorAnalisis{" +
                "tipo='" + tipo + '\'' +
                ", lexema='" + lexema + '\'' +
                ", linea=" + linea +
                ", columna=" + columna +
                ", descipcion='" + descipcion + '\'' +
                '}';
    }
}
