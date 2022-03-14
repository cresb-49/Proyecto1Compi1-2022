package com.cresb49.appcliente.analizadores.filecopy;

import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import com.cresb49.appcliente.analizadores.Token;
import com.cresb49.appcliente.ED.Pila;

import java.util.ArrayList;
import java_cup.runtime.*;

%%
%class LexerFileCopy
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
    return new java_cup.runtime.Symbol(ParserFileCopySym.EOF,yyline+1,yycolumn+1,this.actual);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
text = [\w]+
Number = [0-9]
Entero = {Number}+


%state STRING

%%


<YYINITIAL> {
    "Proyecto1"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.PROYECT1,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Score: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Proyecto2"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.PROYECT2,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Score: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "FileDef"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.FILEDEF,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Score: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "ReporteJson"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.REPORTJSON,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Score: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {text}          {
                        String des = "La cadena no existe en el lenguaje";
                        //this.addError(new ErrorAnalisis(this.ERROR_TYPE,yytext(),(yyline+1),(yycolumn+1),des));
                        //System.out.println("Cadena Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [{]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.LLA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [}]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.LLA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserFileCopySym.DOSPUNTOS,yyline+1,yycolumn+1,this.actual);
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
                                        return new Symbol(ParserFileCopySym.STRING,yyline+1,yycolumn+1,this.actual); 
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
                        return new Symbol(ParserFileCopySym.STRING,yyline+1,yycolumn+1,this.actual);
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