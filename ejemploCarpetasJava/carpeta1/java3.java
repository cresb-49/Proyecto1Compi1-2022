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
        
        File carpetaFile = new File();
        File archivoJson = new File();
        File archivoDef = new File();
        
        this.setPathCarpetaProyecto();
        this.setPathArchivDef();
        this.setPathArchivoJson();
        
        if (carpetaFile) {
            FileWriter fw = new FileWriter();
            BufferedWriter bw = new BufferedWriter();
            ObjectOutputStream oos = new ObjectOutputStream();
        } else {
            NotDirectoryCreate();
        }
    }
}
