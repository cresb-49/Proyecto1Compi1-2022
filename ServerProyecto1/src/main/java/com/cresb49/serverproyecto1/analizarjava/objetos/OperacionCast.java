package com.cresb49.serverproyecto1.analizarjava.objetos;

import com.cresb49.serverproyecto1.analizarjava.Asignacion;

public class OperacionCast {
    
    public OperacionCast() {
    }
    
    public static boolean validSumarRestar(Asignacion type){
        if(type==null){
            return false;
        }else 
        if(type.getTipo().equals(TablaSimbolos.VARIABLE)){
            return true;
        }else{
            return false;
        }
    }

    public static String expectedSumaRestar(){
        return "["+TablaSimbolos.VARIABLE+"]";
    }

    public static boolean validUniariNegPosi(Asignacion type){
        if(type.getTipo().equals(TablaSimbolos.INT)){
            return true;
        }else
        if(type.getTipo().equals(TablaSimbolos.DOUBLE)){
            return true;
        }else
        if(type.getTipo().equals(TablaSimbolos.COMODIN)){
            return true;
        }else
        if(type.getTipo().equals(TablaSimbolos.VARIABLE)){
            return true;
        }else{
            return false;
        }
    }

    public static String expectedUnariNegPosi(){
        return "["+TablaSimbolos.INT+","+TablaSimbolos.DOUBLE+","+TablaSimbolos.VARIABLE+"]";
    }

    public static boolean validUniariBool(Asignacion type){
        if(type.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return true;
        }else
        if(type.getTipo().equals(TablaSimbolos.COMODIN)){
            return true;
        }else
        if(type.getTipo().equals(TablaSimbolos.VARIABLE)){
            return true;
        }
        return false;
    }

    public static String expectedUniariBool(){
        return "["+TablaSimbolos.BOOLEAN+","+TablaSimbolos.VARIABLE+"]";
    }

    public static String newTypeSum(Asignacion left,Asignacion rigth){
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.STRING;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else{
            return TablaSimbolos.ERROR;
        }
    }
    
    public static String expectedSum(){
        return "["  +TablaSimbolos.INT+"+"+TablaSimbolos.DOUBLE+","
                    +TablaSimbolos.INT+"+"+TablaSimbolos.INT+","
                    +TablaSimbolos.INT+"+"+TablaSimbolos.STRING+","
                    +TablaSimbolos.DOUBLE+"+"+TablaSimbolos.INT+","
                    +TablaSimbolos.DOUBLE+"+"+TablaSimbolos.STRING+","
                    +TablaSimbolos.DOUBLE+"+"+TablaSimbolos.DOUBLE+","
                    +TablaSimbolos.STRING+"+"+TablaSimbolos.INT+","
                    +TablaSimbolos.STRING+"+"+TablaSimbolos.DOUBLE+","
                    +TablaSimbolos.STRING+"+"+TablaSimbolos.CHAR+","
                    +TablaSimbolos.STRING+"+"+TablaSimbolos.STRING+","
                    +TablaSimbolos.STRING+"+"+TablaSimbolos.BOOLEAN+","
                    +TablaSimbolos.BOOLEAN+"+"+TablaSimbolos.STRING+","
                    +TablaSimbolos.CHAR+"+"+TablaSimbolos.STRING+"]";
    }
    
    public static String newTypeResMulDiv(Asignacion left,Asignacion rigth){
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.INT;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.DOUBLE;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.COMODIN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.COMODIN;
        }else{
            return TablaSimbolos.ERROR;
        }
    }
    
    public static String expectedResMulDiv(){
        return "["+TablaSimbolos.INT+","+TablaSimbolos.DOUBLE+","+TablaSimbolos.VARIABLE+"]";
    }
    
    public static String newMayorMenor(Asignacion left,Asignacion rigth){
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else{
            return TablaSimbolos.ERROR;
        }
    }
    
    public static String newComparacion(Asignacion left,Asignacion rigth){
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.INT)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.DOUBLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.STRING)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.CHAR)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.DOUBLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.ERROR)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.INT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.OBJECT)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.STRING)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.CHAR)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.ERROR)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.ERROR;
        }else
        if(left.getTipo().equals(TablaSimbolos.OBJECT)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(rigth.getTipo())){
            return TablaSimbolos.BOOLEAN;
        }else{
            return TablaSimbolos.ERROR;
        }
    }
    
    public static String newAndOr(Asignacion left,Asignacion rigth){
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.BOOLEAN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.COMODIN)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.BOOLEAN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.COMODIN)){
            return TablaSimbolos.BOOLEAN;
        }else
        if(left.getTipo().equals(TablaSimbolos.VARIABLE)&&rigth.getTipo().equals(TablaSimbolos.VARIABLE)){
            return TablaSimbolos.BOOLEAN;
        }else{
            return TablaSimbolos.ERROR;
        }
    }
}
