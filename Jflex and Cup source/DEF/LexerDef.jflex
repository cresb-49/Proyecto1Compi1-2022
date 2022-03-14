package com.cresb49.appcliente.analizadores.def;

import com.cresb49.appcliente.analizadores.Token;
import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import com.cresb49.appcliente.analizadores.def.obj.TablaEjecucion;

import java.util.ArrayList;
import java_cup.runtime.*;

%%
%class LexerDef
%unicode
%public
%line
%column
%caseless
%ignorecase
%cup

%{
    private static final String ERROR_TYPE = "Léxico";
    private Token anterior;
    private Token actual; 
    private boolean habilitar_cont=false;
    private boolean ingresar_id=false;

    private int contador_tokens = 0;

    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    private ArrayList<ErrorAnalisis> errors;

    private TablaEjecucion tablaEjecucion;

    public void setErrors(ArrayList<ErrorAnalisis> errors) {
        this.errors = errors;
    }

    public ArrayList<ErrorAnalisis> getErrors() {
        return errors;
    }

    private void addError(ErrorAnalisis error){
        this.errors.add(error);
    }

    private void habilitar_conteo(){
        this.habilitar_cont = true;
    }

    private void habilitar_ingresar_id(){
        this.ingresar_id = true;
    }
    private void dehabilitar_ingresar_id(){
        this.ingresar_id = false;
    }

    public TablaEjecucion getTablaEjecucion() {
        return tablaEjecucion;
    }

    public void setTablaEjecucion(TablaEjecucion tablaEjecucion) {
        this.tablaEjecucion = tablaEjecucion;
    }

    private void asig_valor_agregar_tabla_ejecucion(Token token){
        if(habilitar_cont){
            token.setId(contador_tokens);
            this.tablaEjecucion.getFilas().add(token);
            contador_tokens++;
        }
    }

    private void ingresar_id_tabla(Token token){
        if(habilitar_cont && ingresar_id){
            token.setId(contador_tokens);
            this.tablaEjecucion.getFilas().add(token);
            contador_tokens++;
        }
    }

%}
%eofval{
    this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
    this.anterior = this.actual;
    this.habilitar_cont = false;
    this.contador_tokens = 0;
    dehabilitar_ingresar_id();
    return new java_cup.runtime.Symbol(ParserDefSym.EOF,yyline+1,yycolumn+1,this.actual);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment}
TraditionalComment   = "</" [^/] ~"/>" | "</" "/"+ "/>"
Number = [0-9]
Entero = {Number}+

Identifier = [:jletter:] [:jletterdigit:]*
text = [\w]+([ ]+[\w]+)*



%state STRING
%state INERTEXT

%%


<YYINITIAL> {
    {Comment}       {
                        //System.out.println(yytext());   
                    }
    "Integer"       {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.INT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Integer: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "String"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.STR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("String: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "html"          {
                        habilitar_conteo();
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.HTML,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("html: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "h1"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.H1,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("h1: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "h2"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.H2,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("h2: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "table"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.TABLE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("table: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "for"           {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.FOR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("for: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "th"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.TH,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("tr: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "tr"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.TR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("tr: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "td"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.TD,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("td: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "br"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.BR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("br: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "iterador"      {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        habilitar_ingresar_id();
                        return new Symbol(ParserDefSym.ITERATOR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("iterador: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "hasta"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        dehabilitar_ingresar_id();
                        return new Symbol(ParserDefSym.HASTA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("hasta: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "$$("           {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.D_PA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("$$(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ")$$"           {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        dehabilitar_ingresar_id();
                        return new Symbol(ParserDefSym.PA_C_D,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(")$$: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Identifier}    {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.CONSULTAR);
                        this.ingresar_id_tabla(this.actual);
                        return new Symbol(ParserDefSym.ID,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Identificador: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Entero}        {
                        this.actual = new Token(yytext(),new Integer(yytext()),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.ENTERO,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Entero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [*]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.MUL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("*: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [/]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.DIV,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("/: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [+]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.MAS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("+: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [-]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.MENOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("-: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "="             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.EQUAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "</"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.ME_QB,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("</: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<"             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.ME_Q,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("<: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ">"             {
                        yybegin(INERTEXT);
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        dehabilitar_ingresar_id();
                        return new Symbol(ParserDefSym.MA_Q,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(">: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [(]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.PA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [)]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.PA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("): "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\[]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.CO_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\]]            {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.CO_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [.]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(".: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.DOSPUNTOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [;]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.PUNTOCOMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(";-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
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
                                        return new Symbol(ParserDefSym.STRING,yyline+1,yycolumn+1,this.actual);
                                        //System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
                                    }
      [^\n\r\"\\]+                   { string.append( yytext()); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
}

<INERTEXT>{
    {text}          { 
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        this.actual.setAccion(Token.PRINT);
                        this.asig_valor_agregar_tabla_ejecucion(this.actual);
                        return new Symbol(ParserDefSym.TEXT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("text: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [.]             {
                        this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(".: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "</"            {
                        yybegin(YYINITIAL);
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.ME_QB,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("</: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<"             {
                        yybegin(YYINITIAL);
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.ME_Q,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("<: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "$$("           {
                        yybegin(YYINITIAL);
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        habilitar_ingresar_id();
                        return new Symbol(ParserDefSym.D_PA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("$$(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {WhiteSpace}                   { /* ignore */ }
}

/*
<STRING>{
    [\"]            {
                        yybegin(YYINITIAL);
                        this.actual = new Token(string.toString(),string.toString(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserDefSym.STRING,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
                    }
    [^\n\r\"]+      {
                        string.append(yytext());
                    }
}*/

[^]                 { 
                        String des ="El simbolo/cadena no existe en el lenguaje";
                        this.addError(new ErrorAnalisis(this.ERROR_TYPE,yytext(),(yyline+1),(yycolumn+1),des));
                        //System.out.println("Simbolo Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }