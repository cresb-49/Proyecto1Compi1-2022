package com.cresb49.servidorproyecto1.analizardorjava;

public class Token {

    private String lexema;
    private Object value;
    private int linea;
    private int columna;
    private Token sigToken;
    private Token antToken;


    public Token(String lexema, Object value, int linea, int columna, Token sigToken, Token antToken) {
        this.lexema = lexema;
        this.value = value;
        this.linea = linea;
        this.columna = columna;
        this.sigToken = sigToken;
        this.antToken = antToken;
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

    public Token getSigToken() {
        return sigToken;
    }

    public void setSigToken(Token sigToken) {
        this.sigToken = sigToken;
    }

    public Token getAntToken() {
        return antToken;
    }

    public void setAntToken(Token antToken) {
        this.antToken = antToken;
    }
}

