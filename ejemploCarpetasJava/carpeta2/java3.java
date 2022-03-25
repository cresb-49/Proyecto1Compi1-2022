import com.cresb49.appcliente.proyecto.exceptions.NotDirectoryCreate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class CrearArchivos {

    public CrearArchivos() {
    }
    
    public static void crear_guardar(File archivo,ProyectoCopy proyectoCopy){
        
        String generalPath;
        
        String carpeta = "holas";
        String pathCopy = carpeta+ ".copy";
        String pathDef =carpeta + ".def";
        String pathJson =carpeta +".json";
        
        File carpetaFile = new Object();
        File archivoJson = new Object();
        File archivoDef = new Object();
        
        setPathCarpetaProyecto();
        setPathArchivDef();
        setPathArchivoJson();
        
        if (carpetaFile) {
            FileWriter fw = new Object();
            BufferedWriter bw = new Object();
            ObjectOutputStream oos = new Object();
        } else {
            NotDirectoryCreate();
        }
    }
}
