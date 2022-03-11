package com.cresb49.appcliente.analizadores.json;

import com.cresb49.appcliente.ED.Pila;
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
        if (!this.errores.isEmpty()) {
            //this.ajusteDeErrores();
        } else {
            this.reporteFinalErrores = new ArrayList<>();
        }

    }

    private void ajusteDeErrores() {
        for (ErrorAnalisis reporteFinalErrore : reporteFinalErrores) {
            System.out.println(reporteFinalErrore.toString());
        }
    }
    
    /**
     * @return the reporteFinalErrores
     */
    public ArrayList<ErrorAnalisis> getReporteFinalErrores() {
        return reporteFinalErrores;
    }
}
