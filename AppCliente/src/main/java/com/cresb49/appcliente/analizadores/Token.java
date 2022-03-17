package com.cresb49.appcliente.analizadores;

public class Token {

    //CONSTANTES DE TOKENS
    public static final int VIEW = 0;
    public static final int PRINT = 1;
    public static final int CAMBIAR = 3;
    public static final int CONSULTAR = 4;
    public static final int BUCLE_INI = 5;
    public static final int BUCLE_FIN = 6;
    public static final int IGNORE = 7;
    public static final int VAR_CONSULT = 8;
    

    private String lexema;
    private Object value;
    private int linea;
    private int columna;
    private Token sigToken;
    private Token antToken;


    //ATRIBUTOS ESPECIALES DE LOS TOKENS
    private int id;
    private int accion;
    private Object valorToken;


    public Token(String lexema, Object value, int linea, int columna, Token sigToken, Token antToken) {
        this.lexema = lexema;
        this.value = value;
        this.linea = linea;
        this.columna = columna;
        this.sigToken = sigToken;
        this.antToken = antToken;
    }


    public Token(int id,String lexema, Object value, int linea, int columna, Token sigToken, Token antToken) {
        this.id = id;
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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public Object getValorToken() {
        return valorToken;
    }

    public void setValorToken(Object valorToken) {
        this.valorToken = valorToken;
    }
}
