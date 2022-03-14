package com.cresb49.appcliente.proyecto;

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
    
    public static void crear_guardar(File archivo,ProyectoCopy proyectoCopy) throws IOException, NotDirectoryCreate{
        
        String generalPath = archivo.getParent();
        
        String carpeta = File.separator + archivo.getName();
        String pathCopy = carpeta + File.separator + archivo.getName() + ".copy";
        String pathDef =carpeta + File.separator + archivo.getName() + ".def";
        String pathJson =carpeta + File.separator + archivo.getName() + ".json";
        
        File carpetaFile = new File(generalPath+carpeta);
        File archivoJson = new File(generalPath+pathJson);
        File archivoDef = new File(generalPath+pathDef);
        
        proyectoCopy.setPathCarpetaProyecto(carpeta);
        proyectoCopy.setPathArchivDef(pathDef);
        proyectoCopy.setPathArchivoJson(pathJson);
        
        
        if (!carpetaFile.exists()) {
            
            carpetaFile.mkdir();
            archivoDef.createNewFile();
            archivoJson.createNewFile();
            
            FileWriter fw = new FileWriter(archivoJson);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(VerificarProyectoCopy.MODEL_JSON);
            bw.close();
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(generalPath+pathCopy));
            oos.writeObject(proyectoCopy);
            oos.close();
        } else {
            throw new NotDirectoryCreate();
        }
    }
}
