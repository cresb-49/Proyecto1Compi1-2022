package com.cresb49.appcliente.proyecto;

import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;

public class VerificarProyectoCopy {

    public VerificarProyectoCopy() {

    }

    public static ArrayList<String> verificarArchivos(File archivos) {
        ArrayList<String> errores = new ArrayList<>();
        String extencion = "";
        if (archivos != null) {
            for (File archivo : archivos.listFiles()) {
                extencion = FilenameUtils.getExtension(archivo.getName());
                if (!extencion.toLowerCase().equals(".java")) {
                    errores.add("El archivo: \"" + archivo.getName() + "\" no es un archivo .java");
                    System.out.println("El archivo: \"" + archivo.getName() + "\" no es un archivo .java");
                }
            }
        } else {
            errores.add("No a seleccionado un carpeta de archivos java");
        }
        return errores;
    }
}
