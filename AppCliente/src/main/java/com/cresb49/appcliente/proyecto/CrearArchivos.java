package com.cresb49.appcliente.proyecto;

import com.cresb49.appcliente.proyecto.exceptions.NotDirectoryCreate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class CrearArchivos {

    public CrearArchivos() {
    }
    
    public static void crear_guardar(File archivo,ProyectoCopy proyectoCopy) throws IOException, NotDirectoryCreate{
        String carpeta = archivo.getParent() + File.separator + archivo.getName();
        String pathCopy = carpeta + File.separator + archivo.getName() + ".copy";
        String pathDef =carpeta + File.separator + archivo.getName() + ".def";
        String pathJson =carpeta + File.separator + archivo.getName() + ".json";
        
        File carpetaFile = new File(carpeta);
        File archivoJson = new File(pathJson);
        File archivoDef = new File(pathDef);
        
        proyectoCopy.setPathArchivDef(pathDef);
        proyectoCopy.setPathArchivoJson(pathJson);
        
        if (!carpetaFile.exists()) {
            
            carpetaFile.mkdir();
            archivoDef.createNewFile();
            archivoJson.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathCopy));
            oos.writeObject(proyectoCopy);
            oos.close();
        } else {
            throw new NotDirectoryCreate();
        }
    }
}
