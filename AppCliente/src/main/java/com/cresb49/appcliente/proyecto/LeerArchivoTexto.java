/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Benjamin
 */
public class LeerArchivoTexto {

    public LeerArchivoTexto() {
    }

    public static String leerArchivo(String path) throws FileNotFoundException, IOException {
        String lec = "";
        File file = new File(path);
        BufferedReader obj = new BufferedReader(new FileReader(file));
        String strng;
        while ((strng =obj.readLine()) != null) {
            lec =  lec + strng +"\n";
        }
        return lec;
    }
}
