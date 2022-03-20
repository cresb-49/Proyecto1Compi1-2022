package com.cresb49.appcliente.Objetos;

import javax.swing.JTextArea;

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
}
