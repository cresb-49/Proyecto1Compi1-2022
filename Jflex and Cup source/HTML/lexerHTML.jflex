import java.util.ArrayList;
//import java_cup.runtime.*;

%%
%class LexerHTML
%standalone
%unicode
%public
%line
%column
%caseless
%ignorecase

//%cup

%{
    private static final String ERROR_TYPE = "Léxico";
    //private Token anterior;
    //private Token actual; 

    private int stringColumnInit = 0; 
    private StringBuffer string = new StringBuffer();
    //private Pila<ErrorAnalisis> errors;

    /*
    public Pila<ErrorAnalisis> getErrors() {
        //return errors;
    }

    private void addError(ErrorAnalisis error){
        this.errors.push(error);
    }*/

%}

/*
%eofval{
    //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
    //this.anterior = //this.actual;
    //return new java_cup.runtime.Symbol(ParserGraphicsSym.EOF,yyline+1,yycolumn+1,//this.actual);
%eofval}
*/

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment}
TraditionalComment   = "</" [^/] ~"/>" | "</" "/"+ "/>"
Number = [0-9]
Entero = {Number}+

Identifier = [:jletter:] [:jletterdigit:]*
text = [\w]+([ ]+[/w]+)*



%state STRING
%state INERTEXT

%%


<YYINITIAL> {
    "Integer"        {
                        System.out.println("Integer: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "String"        {
                        System.out.println("String: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "html"          {
                        System.out.println("html: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "h1"            {
                        System.out.println("h1: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "h2"            {
                        System.out.println("h2: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "table"         {
                        System.out.println("table: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "for"           {
                        System.out.println("for: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "tr"            {
                        System.out.println("tr: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "td"            {
                        System.out.println("td: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "br"            {
                        System.out.println("br: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "iterador"      {
                        System.out.println("iterador: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "hasta"         {
                        System.out.println("hasta: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "$$("           {
                        System.out.println("$$(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ")$$"           {
                        System.out.println(")$$: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Identifier}    {
                        System.out.println("Identificador: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Comment}       {
                        System.out.println(yytext());   
                    }
    {Entero}        {
                        //this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,//this.anterior);
                        ////this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.NUMBERS,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("Entero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [*]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.MUL,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("*: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [/]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.DIV,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("/: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [+]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.MAS,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("+: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [-]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.MENOS,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("-: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "="             {
                        System.out.println("= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<"             {
                        System.out.println("<: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ">"             {
                        System.out.println(">: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                        yybegin(INERTEXT);
                    }
    "</"            {
                        System.out.println("</: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [(]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.PA_A,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [)]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.PA_C,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("): "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\[]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.CO_A,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("[: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [\]]            {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.CO_C,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("]: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [.]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.COMA,yyline+1,yycolumn+1,//this.actual);
                        System.out.println(".: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [,]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.COMA,yyline+1,yycolumn+1,//this.actual);
                        System.out.println(",: "+yytext()+" , Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [:]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.DOSPUNTOS,yyline+1,yycolumn+1,//this.actual);
                        System.out.println(":-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [;]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.PUNTOCOMA,yyline+1,yycolumn+1,//this.actual);
                        System.out.println(";-> "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
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
                                        System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
                                        //return symbol(sym.STRING_LITERAL,string.toString()); 
                                    }
      [^\n\r\"\\]+                   { string.append( yytext()); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
}

<INERTEXT>{
    {WhiteSpace}                   { /* ignore */ }
    "</"            {
                        yybegin(YYINITIAL);
                        System.out.println("</: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<"             {
                        yybegin(YYINITIAL);
                        System.out.println("<: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "$$("           {
                        yybegin(YYINITIAL);
                        System.out.println("$$(: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {text}          { 
                        System.out.println("text: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
}

/*
<STRING>{
    [\"]            {
                        yybegin(YYINITIAL);
                        //this.actual = new Token(string.toString(),string.toString(),yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.STRING,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("String: "+string.toString()+", Linea: "+(yyline+1)+", Columna: "+stringColumnInit);
                    }
    [^\n\r\"]+      {
                        string.append(yytext());
                    }
}*/

[^]                 { 
                        String des ="El simbolo/cadena no existe en el lenguaje";
                        //this.addError(new ErrorAnalisis(this.ERROR_TYPE,yytext(),(yyline+1),(yycolumn+1),des));
                        System.out.println("Simbolo Ilegal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }