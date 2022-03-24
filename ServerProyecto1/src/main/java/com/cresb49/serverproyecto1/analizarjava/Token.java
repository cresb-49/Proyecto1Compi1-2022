package com.cresb49.serverproyecto1.analizarjava;

public class Token {
    private String lexema;
    private Object value;
    private int linea;
    private int columna;


    public Token(String lexema, Object value, int linea, int columna) {
        this.lexema = lexema;
        this.value = value;
        this.linea = linea;
        this.columna = columna;
    }

    public Token() {
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
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
}
