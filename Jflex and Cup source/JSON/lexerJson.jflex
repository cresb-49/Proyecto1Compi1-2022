package com.cresb49.appcliente.analizadores.json;

import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import com.cresb49.appcliente.analizadores.Token;
import com.cresb49.appcliente.ED.Pila;

import java.util.ArrayList;
import java_cup.runtime.*;

%%
%class LexerJson
%unicode
%public
%line
%column
%cup

%{
    private static final String ERROR_TYPE = "Léxico";
    private Token anterior;
    private Token actual; 

    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    private Pila<ErrorAnalisis> errors;

    public void setErrors(Pila<ErrorAnalisis> errors) {
        this.errors = errors;
    }

    public Pila<ErrorAnalisis> getErrors() {
        return errors;
    }

    private void addError(ErrorAnalisis error){
        this.errors.push(error);
    }
%}
%eofval{
    this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
    this.anterior = this.actual;
    return new java_cup.runtime.Symbol(ParserJsonSym.EOF,yyline+1,yycolumn+1,this.actual);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
text = [\w]+
Number = [0-9]
Entero = {Number}+


%state STRING

%%


<YYINITIAL> {
    "Score"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.SCORE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Score: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Clases"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.CLASS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Clases: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Variables"     {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.VAR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Variables: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Nombre"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.NAME,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Nombre: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Tipo"          {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.TYPE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Tipo: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Funcion"       {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.FUN,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Funcion: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Metodos"       {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.METD,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Metodos: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Parametros"    {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.PARA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Paremetros: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Comentarios"   {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.COMENT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Comentarios: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Texto"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.TEXT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Texto: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Entero}        {
                        this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.ENTERO,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Entero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {text}          {
                        String des = "La cadena no existe en el lenguaje";
                        //this.addError(new ErrorAnalisis(this.ERROR_TYPE,yytext(),(yyline+1),(yycolumn+1),des));
                        //System.out.println("Cadena Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\[]            {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.CO_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\]]            {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.CO_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [{]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.LLA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [}]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.LLA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.DOSPUNTOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\"]            {
                        this.stringColumnInit = (yycolumn+1);
                        this.string.setLength(0); 
                        yybegin(STRING); 
                    }
    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}


<STRING>    {
      \"                            {
                                        yybegin(YYINITIAL);
                                        this.actual = new Token(string.toString(),string.toString(),yyline+1,yycolumn+1,null,this.anterior);
                                        this.anterior = this.actual;
                                        return new Symbol(ParserJsonSym.STRING,yyline+1,yycolumn+1,this.actual); 
                                    }
      [^\n\r\"\\]+                   { string.append( yytext()); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
}

/*
<STRING>{
    [\"]            {
                        yybegin(YYINITIAL);
                        this.actual = new Token(string.toString(),string.toString(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserJsonSym.STRING,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
                    }
    [^\n\r\"]+      {
                        string.append(yytext());
                    }
}*/

[^]                 { 
                        String des ="El simbolo/cadena no existe en el lenguaje";
                        //this.addError(new ErrorAnalisis(this.ERROR_TYPE,yytext(),(yyline+1),(yycolumn+1),des));
                        //System.out.println("Simbolo Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }