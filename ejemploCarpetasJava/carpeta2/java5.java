import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente{

    private int puerto = 6000;
    private String host = "localhost";
    private Object mensaje;

    public Cliente() {

    }

    public Cliente(int puerto, String host) {
        this.puerto = puerto;
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

    public void run() {
        Socket socket = null;
        ObjectOutput out;
        socket = new Object();
        out = new Object();

        /// Envio de mansaje de respuesta al servidor
        this.enviar(out, mensaje);

    }

    private void enviar(ObjectOutput out, Object data){
        print = data;
    }
}