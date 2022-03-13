package com.cresb49.appcliente.analizadores.def;

import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;


public class AnalizarDef {
    private ArrayList<ErrorAnalisis> errores;
    private ArrayList<ErrorAnalisis> reporteFinalErrores;
    private LexerDef lexerDef;
    private ParserDef parserDef;

    public AnalizarDef() {
    }

    public void ejecutar(String texto) {
        reporteFinalErrores = null;
        Reader reader = new StringReader(texto);
        errores = new ArrayList<>();
        lexerDef = new LexerDef(reader);
        lexerDef.setErrors(errores);
        parserDef = new ParserDef(lexerDef);
        try {
            parserDef.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.err.println("----------------IMPRECION DE ERRORES-------------------");
        for (ErrorAnalisis errore : errores) {
            System.out.println(errore.toString());
        }
        //System.err.println("----------------VALORES RECUPERADOS-------------------");
        parserDef.getTablaSimbolos().imprimirTabla();
    }
    
    /**
     * @return the reporteFinalErrores
     */
    public ArrayList<ErrorAnalisis> getReporteFinalErrores() {
        return reporteFinalErrores;
    }
}
