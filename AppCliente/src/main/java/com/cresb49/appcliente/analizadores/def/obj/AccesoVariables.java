package com.cresb49.appcliente.analizadores.def.obj;

public class AccesoVariables {
    private Object arreglo;
    private Object index;
    public AccesoVariables(){

    }
    public AccesoVariables(Object arreglo,Object index){
        this.arreglo = arreglo;
        this.index = index;
    }
    public Object getIndex() {
        return index;
    }
    public Object getarreglo() {
        return arreglo;
    }
    public void setIndex(Object index) {
        this.index = index;
    }
    public void setArreglo(Object arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public String toString() {
        return "AccesoVariables{" + "arreglo=" + arreglo + ", index=" + index + '}';
    }
}
