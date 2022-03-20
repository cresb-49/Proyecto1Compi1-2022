package com.cresb49.serverproyecto1.consolecontrol;

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
        this.consola.append(log);
    }
}
