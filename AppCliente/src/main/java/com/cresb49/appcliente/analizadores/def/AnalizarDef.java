package com.cresb49.appcliente.analizadores.def;

import com.cresb49.appcliente.analizadores.ErrorAnalisis;
import com.cresb49.appcliente.analizadores.def.obj.RenderizarHTML;
import com.cresb49.appcliente.analizadores.def.obj.TablaEjecucion;
import com.cresb49.appcliente.analizadores.def.obj.exceptions.NoReporteJson;
import com.cresb49.appcliente.analizadores.json.obj.ReporteJson;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

public class AnalizarDef {

    private ArrayList<ErrorAnalisis> errores;
    private LexerDef lexerDef;
    private ParserDef parserDef;
    private RenderizarHTML renderizarHTML;

    public AnalizarDef() {
    }

    public void ejecutar(String texto, ReporteJson reporteJson) throws NoReporteJson {
        if (reporteJson == null) {
            throw new NoReporteJson("Debe de tener un resultado Json cargado en el proyecto");
        } else {
            Reader reader = new StringReader(texto);
            
            errores = new ArrayList<>();
            lexerDef = new LexerDef(reader);
            lexerDef.setErrors(errores);
            lexerDef.setTablaEjecucion(new TablaEjecucion());
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
            lexerDef.getTablaEjecucion().imprimirTabla();
            
            renderizarHTML = new RenderizarHTML(parserDef.getTablaSimbolos(),lexerDef.getTablaEjecucion());
        }
    }
    
    public String getHTML(){
        return renderizarHTML.HTML();
    }
    
    public ArrayList<ErrorAnalisis> getErrores() {
        return errores;
    }
}
