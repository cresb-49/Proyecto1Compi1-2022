
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.cresb49.appcliente.analizadores.def;

import java.util.ArrayList;
import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import com.cresb49.appcliente.analizadores.Token;
import com.cresb49.appcliente.analizadores.def.obj.*;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserDef extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserDefSym.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserDef() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserDef(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserDef(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\023\000\002\002\003\000\002\002\004\000\002\002" +
    "\003\000\002\003\006\000\002\004\007\000\002\004\007" +
    "\000\002\006\004\000\002\007\005\000\002\007\002\000" +
    "\002\010\005\000\002\010\005\000\002\010\003\000\002" +
    "\011\005\000\002\011\005\000\002\011\003\000\002\012" +
    "\003\000\002\012\003\000\002\012\003\000\002\012\005" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\043\000\010\017\010\020\007\036\004\001\002\000" +
    "\004\037\043\001\002\000\004\002\042\001\002\000\004" +
    "\002\001\001\002\000\004\036\036\001\002\000\004\036" +
    "\012\001\002\000\004\002\uffff\001\002\000\004\037\013" +
    "\001\002\000\012\010\020\015\015\016\022\036\014\001" +
    "\002\000\016\011\ufff2\014\ufff2\043\ufff2\044\ufff2\045\ufff2" +
    "\046\ufff2\001\002\000\016\011\ufff0\014\ufff0\043\ufff0\044" +
    "\ufff0\045\ufff0\046\ufff0\001\002\000\016\011\ufff6\014\ufff6" +
    "\043\ufff6\044\ufff6\045\030\046\027\001\002\000\016\011" +
    "\ufff3\014\ufff3\043\ufff3\044\ufff3\045\ufff3\046\ufff3\001\002" +
    "\000\012\010\020\015\015\016\022\036\014\001\002\000" +
    "\010\014\025\043\023\044\024\001\002\000\016\011\ufff1" +
    "\014\ufff1\043\ufff1\044\ufff1\045\ufff1\046\ufff1\001\002\000" +
    "\012\010\020\015\015\016\022\036\014\001\002\000\012" +
    "\010\020\015\015\016\022\036\014\001\002\000\004\002" +
    "\ufffd\001\002\000\016\011\ufff7\014\ufff7\043\ufff7\044\ufff7" +
    "\045\030\046\027\001\002\000\012\010\020\015\015\016" +
    "\022\036\014\001\002\000\012\010\020\015\015\016\022" +
    "\036\014\001\002\000\016\011\ufff4\014\ufff4\043\ufff4\044" +
    "\ufff4\045\ufff4\046\ufff4\001\002\000\016\011\ufff5\014\ufff5" +
    "\043\ufff5\044\ufff5\045\ufff5\046\ufff5\001\002\000\016\011" +
    "\ufff8\014\ufff8\043\ufff8\044\ufff8\045\030\046\027\001\002" +
    "\000\010\011\035\043\023\044\024\001\002\000\016\011" +
    "\uffef\014\uffef\043\uffef\044\uffef\045\uffef\046\uffef\001\002" +
    "\000\004\037\037\001\002\000\012\010\020\015\015\016" +
    "\022\036\014\001\002\000\010\014\041\043\023\044\024" +
    "\001\002\000\004\002\ufffc\001\002\000\004\002\000\001" +
    "\002\000\012\010\020\015\015\016\022\036\014\001\002" +
    "\000\010\014\045\043\023\044\024\001\002\000\004\002" +
    "\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\043\000\010\002\004\003\005\004\010\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\010\020\011\015\012\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\010\033\011\015\012\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\011\032\012\016\001" +
    "\001\000\006\011\025\012\016\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\012\031\001\001\000\004\012" +
    "\030\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\010\037\011\015\012\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\010" +
    "\043\011\015\012\016\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserDef$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserDef$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserDef$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return this.lexerDef.next_token(); 
    }


    // Connect this parser to a scanner!

    private static final String ERROR_TYPE_SIN = "Sintactico";
    private static final String ERROR_TYPE_SEM = "Semantico";

    private LexerDef lexerDef;
    private ArrayList<ErrorAnalisis> errorAnalisisesTmp;
    private SimbolosTerminalesDef simbolosTerminalesDef;
    private TablaSimbolos tablaSimbolos;
    
    public ParserDef (LexerDef lexerDef){ 
        super(lexerDef);
        this.lexerDef=lexerDef;
        this.tablaSimbolos = new TablaSimbolos();
        this.simbolosTerminalesDef = new SimbolosTerminalesDef();
    }

    public void report_error(String message, Object info) {
        System.out.println("public void report_error");
    }
    
    public void report_fatal_error(String message, Object info) {
        System.out.println("public void report_fatal_error");
    }

    public void syntax_error(Symbol cur_token) {
        Token tok = (Token) cur_token.value;
        if(tok!=null){
            if (cur_token.sym == ParserDefSym.EOF) {
                String er = "Simbolo inesperado, se esperaba: "+ simbolosTerminalesDef.obtenerSimbolos(expected_token_ids()).toString();
                System.out.println("FIN ARCHIVO"+" "+er);
                this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SIN,"FIN ARCHIVO", cur_token.left, cur_token.right, er));
                System.out.println(er);
            } else {
                String er = "Simbolo inesperado, se esperaba: "+ simbolosTerminalesDef.obtenerSimbolos(expected_token_ids()).toString();
                System.out.println(tok.getLexema()+" "+er);
                this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SIN,tok.getLexema(), tok.getLinea(), tok.getColumna(), er));
                System.out.println(er);
            }
        }else{
            String er = "Simbolo inesperado, se esperaba: "+ simbolosTerminalesDef.obtenerSimbolos(expected_token_ids()).toString();
            System.out.println("FIN ARCHIVO"+" "+er);
            this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SIN,"FIN ARCHIVO", cur_token.left, cur_token.right, er));
            System.out.println(er);
        }
    }

    public void unrecovered_syntax_error(Symbol cur_token) {
        if (cur_token.sym == ParserDefSym.EOF) {
            String er = "Error irrecuperable se llego al final del archivo";
            System.out.println("FIN ARCHIVO"+" "+er);
            this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SIN,"FIN ARCHIVO", cur_token.left, cur_token.right, er));
            System.out.println(er);
        } else {
            Token tok = (Token) cur_token.value;
            //String er = "Error irrecuperable, un posible simbolo esperado: "+ simbolosTerminalesDef.obtenerSimbolos(expected_token_ids()).toString();
            String er = "Error irrecuperable resuelva el error anterior";
            System.out.println(tok.getLexema()+" "+er);
            this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SIN, tok.getLexema(), tok.getLinea(), tok.getColumna(), er));
            System.out.println(er);
        }
    }

    private void semantic_error(Token token,String contexto) {
        this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SEM,token.getLexema(), token.getLinea(), token.getColumna(), contexto));
    }

    private boolean definition_error(Token ini,Token fin,ArrayList<String> errores){
        boolean status = false;
        for (String errore : errores) {
            status = true;
            String error = "Error en definicion, "+errore+" Ubicacion general --> Linea: "+ini.getLinea()+" a Linea: "+fin.getLinea();
            this.lexerDef.getErrors().add(new ErrorAnalisis(ERROR_TYPE_SEM, ini.getLexema(), ini.getLinea(), ini.getColumna(), error));
            System.out.println(error);
        }
        return status;
    }

    protected int error_sync_size() {
		return 1;
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserDef$actions {
  private final ParserDef parser;

  /** Constructor */
  CUP$ParserDef$actions(ParserDef parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserDef$do_action_part00000000(
    int                        CUP$ParserDef$act_num,
    java_cup.runtime.lr_parser CUP$ParserDef$parser,
    java.util.Stack            CUP$ParserDef$stack,
    int                        CUP$ParserDef$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserDef$result;

      /* select the action based on the action number */
      switch (CUP$ParserDef$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // ini ::= asig 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= ini EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).value;
		RESULT = start_val;
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserDef$parser.done_parsing();
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // ini ::= dec 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // asig ::= ID EQUAL exp PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("asig",1, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-3)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // dec ::= INT ID EQUAL exp PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("dec",2, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-4)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // dec ::= STR ID EQUAL exp PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("dec",2, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-4)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // decp ::= decpp ID 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("decp",4, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // decpp ::= decpp ID COMA 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("decpp",5, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // decpp ::= 
            {
              Object RESULT =null;

              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("decpp",5, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // exp ::= exp MAS t 
            {
              Operacion RESULT =null;
		int val1left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).left;
		int val1right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).right;
		Operacion val1 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).value;
		int val2left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int val2right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Operacion val2 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		  
                                    try {
                                        String tipo = Operacion.autoCast(val1.getTipo(),TablaSimbolos.MUL,val2.getTipo());
                                        Object result = Operacion.sumaTerminos(val1, val2);
                                        RESULT = new Operacion(tipo,result);
                                    } catch (NotCastException e) {
                                        System.out.println("No se pudo castear el resultado");
                                        RESULT = val1;
                                    }
                                
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("exp",6, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // exp ::= exp MENOS t 
            {
              Operacion RESULT =null;
		int val1left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).left;
		int val1right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).right;
		Operacion val1 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).value;
		int val2left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int val2right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Operacion val2 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                                    try {
                                        String tipo = Operacion.autoCast(val1.getTipo(),TablaSimbolos.MUL,val2.getTipo());
                                        Integer result = ((Integer)val1.getValor())-((Integer)val2.getValor());
                                        RESULT = new Operacion(tipo,result);
                                    } catch (NotCastException e) {
                                        System.out.println("No se pudo castear el resultado");
                                        RESULT = val1;
                                    }
                                
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("exp",6, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // exp ::= t 
            {
              Operacion RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Operacion val = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                    RESULT = val;
                
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("exp",6, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // t ::= t MUL f 
            {
              Operacion RESULT =null;
		int val1left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).left;
		int val1right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).right;
		Operacion val1 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).value;
		int val2left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int val2right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Operacion val2 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                                try {
                                    String tipo = Operacion.autoCast(val1.getTipo(),TablaSimbolos.MUL,val2.getTipo());
                                    Integer result = ((Integer)val1.getValor())*((Integer)val2.getValor());
                                    RESULT = new Operacion(tipo,result);
                                } catch (NotCastException e) {
                                    System.out.println("No se pudo castear el resultado");
                                    RESULT = val1;
                                }
                            
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("t",7, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // t ::= t DIV f 
            {
              Operacion RESULT =null;
		int val1left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).left;
		int val1right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).right;
		Operacion val1 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).value;
		int val2left = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int val2right = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Operacion val2 = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                                try {
                                    String tipo = Operacion.autoCast(val1.getTipo(),TablaSimbolos.MUL,val2.getTipo());
                                    Integer result = ((Integer)val1.getValor())/((Integer)val2.getValor());
                                    RESULT = new Operacion(tipo,result);
                                } catch (NotCastException e) {
                                    System.out.println("No se pudo castear el resultado");
                                    RESULT = val1;
                                }
                            
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("t",7, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // t ::= f 
            {
              Operacion RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Operacion val = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                    RESULT = val;
                
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("t",7, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // f ::= ID 
            {
              Operacion RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Object val = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                        Token token = (Token) val;
                        System.out.println("Buscar en tabla de simbolos");
                        FilaTabla simbolo = tablaSimbolos.buscar(token.getLexema());
                        if(simbolo!=null){
                            if(simbolo.getValor()!=null){
                                RESULT = new Operacion(simbolo.getTipo(),simbolo.getValor());
                            }else{
                                System.out.println("La variable no tiene valor asignado");
                            }
                        }else{
                            System.out.println("No existe la variable en el programa");
                        }
                    
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("f",8, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // f ::= ENTERO 
            {
              Operacion RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Object val = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                        Token token = (Token) val;
                        RESULT = new Operacion(TablaSimbolos.INT,Integer.parseInt(token.getLexema()));
                    
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("f",8, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // f ::= STRING 
            {
              Operacion RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()).right;
		Object val = (Object)((java_cup.runtime.Symbol) CUP$ParserDef$stack.peek()).value;
		
                        Token token = (Token) val;
                        RESULT = new Operacion(TablaSimbolos.STRING,token.getLexema());
                    
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("f",8, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // f ::= PA_A exp PA_C 
            {
              Operacion RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).right;
		Operacion val = (Operacion)((java_cup.runtime.Symbol) CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-1)).value;
		
                                RESULT = val;
                            
              CUP$ParserDef$result = parser.getSymbolFactory().newSymbol("f",8, ((java_cup.runtime.Symbol)CUP$ParserDef$stack.elementAt(CUP$ParserDef$top-2)), ((java_cup.runtime.Symbol)CUP$ParserDef$stack.peek()), RESULT);
            }
          return CUP$ParserDef$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserDef$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserDef$do_action(
    int                        CUP$ParserDef$act_num,
    java_cup.runtime.lr_parser CUP$ParserDef$parser,
    java.util.Stack            CUP$ParserDef$stack,
    int                        CUP$ParserDef$top)
    throws java.lang.Exception
    {
              return CUP$ParserDef$do_action_part00000000(
                               CUP$ParserDef$act_num,
                               CUP$ParserDef$parser,
                               CUP$ParserDef$stack,
                               CUP$ParserDef$top);
    }
}

}
