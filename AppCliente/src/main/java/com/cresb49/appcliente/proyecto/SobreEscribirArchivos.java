/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Benjamin
 */
public class SobreEscribirArchivos {

    public SobreEscribirArchivos() {
    }

    public static void sobreEscribirCopy(ProyectoCopy proyectoCopy,String path) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
        oos.writeObject(proyectoCopy);
        oos.close();
    }

    public static void sobreEscribirArchivoTexto(String path, String contenido) throws IOException {
        File archivoTexto = new File(path);
        FileWriter fw = new FileWriter(archivoTexto);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();
    }
}
