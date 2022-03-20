package com.cresb49.appcliente.Objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmpaquetarInformacion {
    
    /**
     * 
     */
    public EmpaquetarInformacion() {
    }

    public Proyecto empaquetar(File carpeta1,File carpeta2) throws IOException{
        Proyecto proyecto = new Proyecto();
        proyecto.setCarpeta1(new ArrayList<>());
        proyecto.setCarpeta2(new ArrayList<>());
        
        String tmpcode;
        for (File filejava : carpeta1.listFiles()) {    
            tmpcode = this.getCode(filejava);
            if(tmpcode!=null){
                proyecto.getCarpeta1().add(new FileJava(tmpcode, filejava.getName(), ".java"));
            }
        }

        for (File filejava : carpeta2.listFiles()) {    
            tmpcode = this.getCode(filejava);
            if(tmpcode!=null){
                proyecto.getCarpeta2().add(new FileJava(tmpcode, filejava.getName(), ".java"));
            }
        }
        return proyecto;
    }

    private String getCode(File file) throws IOException{
        String lec = "";
        BufferedReader obj = new BufferedReader(new FileReader(file));
        String strng;
        while ((strng =obj.readLine()) != null) {
            lec =  lec + strng +"\n";
        }
        return lec;
    }
}
