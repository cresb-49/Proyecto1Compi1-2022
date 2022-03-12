package com.cresb49.appcliente.analizadores.json;

import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class AnalizarJson {

    private ArrayList<ErrorAnalisis> errores;
    private ArrayList<ErrorAnalisis> reporteFinalErrores;
    private LexerJson lexerJson;
    private ParserJson parserJson;

    public AnalizarJson() {
    }

    public void ejecutar(String texto) {
        reporteFinalErrores = null;
        Reader reader = new StringReader(texto);
        errores = new ArrayList<>();
        lexerJson = new LexerJson(reader);
        lexerJson.setErrors(errores);
        parserJson = new ParserJson(lexerJson);
        try {
            parserJson.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.err.println("----------------IMPRECION DE ERRORES-------------------");
        for (ErrorAnalisis errore : errores) {
            System.out.println(errore.toString());
        }
        System.err.println("----------------VALORES RECUPERADOS-------------------");
        if(parserJson.getReporteJson()!=null){
            parserJson.getReporteJson().imprimirReporte();
        }else{
            System.out.println("Recuperacion null");
        }

    }
    
    /**
     * @return the reporteFinalErrores
     */
    public ArrayList<ErrorAnalisis> getReporteFinalErrores() {
        return reporteFinalErrores;
    }
}
