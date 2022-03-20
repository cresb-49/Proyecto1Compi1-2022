import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 * Servidor
 */
public class Servidor{

    private int puerto = 5000;

    public Servidor() {

    }

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream in;

        serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor Iniciado");
        while (true) {
            socket = serverSocket;

            in = new ObjectInputStream();

            Object mensaje = "hola mensaje nuevo";
        }
    }

}