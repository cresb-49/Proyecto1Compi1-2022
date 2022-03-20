package com.cresb49.serverproyecto1.consolecontrol;

import javax.swing.JTextArea;

import com.cresb49.serverproyecto1.analizarjava.ErrorAnalisis;

public class ConsoleControl {
    private JTextArea consola;
    /**
     * @param consola
     */
    public ConsoleControl(JTextArea consola) {
        this.consola = consola;
    }
    public void addLog(String log){
        this.consola.append(log+"\n");
    }

    public ErrorAnalisis addLog(ErrorAnalisis errorAnalisis){
        String text = "Error " + errorAnalisis.getTipo() + " \"" + errorAnalisis.getLexema() + "\"" + ", Linea: " + errorAnalisis.getLinea() + ", Columna: " + errorAnalisis.getColumna() + " -> " + errorAnalisis.getDescipcion();
        this.consola.append(text+"\n");
        return errorAnalisis;
    }

    public ErrorAnalisis addLog(ErrorAnalisis errorAnalisis,String carpeta,String archivo){
        String text="Carpeta: "+carpeta+" Archivo: "+archivo+"\n";
        text = text + "↳ Error " + errorAnalisis.getTipo() + " \"" + errorAnalisis.getLexema() + "\"" + ", Linea: " + errorAnalisis.getLinea() + ", Columna: " + errorAnalisis.getColumna() + " -> " + errorAnalisis.getDescipcion();
        this.consola.append(text+"\n");
        return errorAnalisis;
    }
}
