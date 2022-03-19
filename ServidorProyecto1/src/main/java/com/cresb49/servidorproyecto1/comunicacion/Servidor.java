package com.cresb49.servidorproyecto1.comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Servidor
 */
public class Servidor extends Observable implements Runnable{
    
    private int puerto = 5000;
    

    public Servidor(){
        
    }
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream in;
        
        try {
            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor Iniciado");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("El cliente se conecto");
                
                in = new ObjectInputStream(socket.getInputStream());
                
                Object mensaje = mensaje = in.readObject();
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                socket.close();
                System.out.println("El cliente se desconecto");
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
                
    }
    
}