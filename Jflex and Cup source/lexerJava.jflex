import java.util.ArrayList;
//import java_cup.runtime.*;

%%
%class LexerJava
%standalone
%unicode
%public
%line
%column
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
    "import"        {
                        System.out.println("import: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "public"        {
                        System.out.println("public: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "private"        {
                        System.out.println("private: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "protected"        {
                        System.out.println("protected: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "final"        {
                        System.out.println("final: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "break"        {
                        System.out.println("break: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "return"        {
                        System.out.println("return: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "int"        {
                        System.out.println("int: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "boolean"        {
                        System.out.println("boolean: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "String"        {
                        System.out.println("String: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "char"        {
                        System.out.println("char: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "double"        {
                        System.out.println("double: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "Object"        {
                        System.out.println("Object: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "If"        {
                        System.out.println("If: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "if"        {
                        System.out.println("if: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "else"        {
                        System.out.println("else: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "for"        {
                        System.out.println("for: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "do"        {
                        System.out.println("do: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "while"        {
                        System.out.println("while: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "switch"        {
                        System.out.println("switch: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "case"        {
                        System.out.println("case: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Identifier}    {
                        System.out.println("Identificador: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Comment}       {
                        System.out.println(yytext());   
                    }
    {Decimal}       {
                        //this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,//this.anterior);
                        ////this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.DECIMAL,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("Decimal: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    {Entero}       {
                        //this.actual = new Token(yytext(),new Double(yytext()),yyline+1,yycolumn+1,null,//this.anterior);
                        ////this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.NUMBERS,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("Numero: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "!="            {
                        System.out.println("!= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "=="            {
                        System.out.println("== : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<="            {
                        System.out.println("<= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ">="            {
                        System.out.println(">= : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "<"             {
                        System.out.println("< : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    ">"             {
                        System.out.println("> : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "&&"            {
                        System.out.println("&& : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "||"            {
                        System.out.println("|| : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "!"             {
                        System.out.println("! : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "++"             {
                        System.out.println("++ : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    "--"             {
                        System.out.println("-- : "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
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
    [{]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.LLA_A,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("{: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
                    }
    [}]             {
                        //this.actual = new Token(yytext(),null,yyline+1,yycolumn+1,null,//this.anterior);
                        //this.anterior = //this.actual;
                        //return new Symbol(ParserGraphicsSym.LLA_C,yyline+1,yycolumn+1,//this.actual);
                        System.out.println("}: "+yytext()+", Linea: "+(yyline+1)+", Columna: "+(yycolumn+1));
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