package com.cresb49.server.AnalizadorJava;
import java.util.ArrayList;
import java_cup.runtime.*;

%%
%class LexerJava
%unicode
%public
%line
%column
%cup

%{
    private static final String ERROR_TYPE = "Léxico";
    //private Token anterior;
    //private Token actual; 

    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    //private Pila<ErrorAnalisis> errors;

    /*
    public Pila<ErrorAnalisis> getErrors() {
        return errors;
    }

    private void addError(ErrorAnalisis error){
        this.errors.push(error);
    }*/

%}
%eofval{
    this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,this.anterior);
    this.anterior = this.actual;
    return new java_cup.runtime.Symbol(ParserGraphicsSym.EOF,yyline+1,yycolumn+1,this.actual);
%eofval}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
//EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
EndOfLineComment     = "//" [^\n]*
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

Number = [0-9]
Entero = {Number}+
Decimal = {Entero}[.]{Entero}


%state STRING

%%


<YYINITIAL> {
    "true"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.TRUE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("import: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "false"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.FALSE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("import: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "import"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.IMPORT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("import: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "public"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PUBLIC,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("public: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "private"       {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PRIVATE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("private: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "protected"     {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PROTECTED,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("protected: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "final"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.FINAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("final: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "break"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.BREAK,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("break: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "return"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.RETURN,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("return: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "int"           {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.INT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("int: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "boolean"       {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.BOOL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("boolean: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "String"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.STR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("String: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "char"          {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CHAR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("char: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "double"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DOUBLE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("double: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Object"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.OBJ,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Object: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "if"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.IF,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("if: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "else"          {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.ELSE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("else: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "for"           {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.FOR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("for: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "do"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DO,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("do: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "while"         {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.WHILE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("while: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "switch"        {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.SWITCH,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("switch: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "case"          {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CASE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("case: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "class"          {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CLASS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("case: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Identifier}    {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.ID,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Identificador: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Comment}       {
                        System.out.println(yytext());   
                    }
    {Decimal}       {
                        this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DECIMAL,yyline+1,yycolumn+1,this.actual);
                        ////System.out.println("Decimal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Entero}       {
                        this.actual = new Token(yytext(),new Integer(yytext()),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.ENTERO,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("Numero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "!="            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DIFERENTE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("!= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "=="            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.IGUAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("== : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "="            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.EQUAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("== : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<="            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MENOR_IGUAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("<= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ">="            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MAYOR_IGUAL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(">= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<"             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MENOR_QUE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("< : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ">"             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MAYOR_QUE,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("> : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "&&"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.AND,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("&& : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "||"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.OR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("|| : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "!"             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.NOT,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("! : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "++"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.SUMAR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("++ : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "--"            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.RESTAR,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("-- : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [*]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MUL,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("*: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [/]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DIV,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("/: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [+]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MAS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("+: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [-]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.MENOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("-: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [(]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [)]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("): "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\[]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CO_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\]]            {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.CO_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [{]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.LLA_A,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [}]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.LLA_C,yyline+1,yycolumn+1,this.actual);
                        //System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [.]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PUNTO,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(".: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.COMA,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.DOSPUNTOS,yyline+1,yycolumn+1,this.actual);
                        //System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [;]             {
                        this.actual = new Token(yytext(),yytext(),yyline+1,yycolumn+1,null,this.anterior);
                        this.anterior = this.actual;
                        return new Symbol(ParserGraphicsSym.PUNTOCOMA,yyline+1,yycolumn+1,this.actual);
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
                                        return new Symbol(ParserGraphicsSym.STRING,yyline+1,yycolumn+1,this.actual); 
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
                        return new Symbol(ParserGraphicsSym.STRING,yyline+1,yycolumn+1,this.actual);
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