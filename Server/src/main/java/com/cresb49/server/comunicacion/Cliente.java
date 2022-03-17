package com.cresb49.server.comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private int puerto = 6000;
    private String host = "localhost";
    private Object mensaje;

    public Cliente() {
        
    }
    
    public Cliente(int puerto,String host){
        this.puerto= puerto;
        this.host = host;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Object getMensaje() {
        return mensaje;
    }

    public void setMensaje(Object mensaje) {
        this.mensaje = mensaje;
    }    

    @Override
    public void run() {
        Socket socket = null;
        ObjectOutput out;

        try {
            socket = new Socket(host, puerto);
            System.out.println("Servidor Iniciado");
            
            out = new ObjectOutputStream(socket.getOutputStream());

            ///Envio de mansaje de respuesta al servidor
            this.enviar(out,mensaje);

            socket.close();
            System.out.println("Se desconecto del servidor");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enviar(ObjectOutput out, Object data) throws IOException {
        out.writeObject(data);
    }
}
