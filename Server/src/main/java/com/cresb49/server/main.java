package com.cresb49.server;


/**
 * main
 */
public class main {
    public static void main(String[] args) {
        Server s = new Server();
        System.out.println("Puerto por defecto [5050]\n");
        String puerto = "5050";
        
        s.ejecutarConexion(Integer.parseInt(puerto));
        s.escribirDatos();
    }
}