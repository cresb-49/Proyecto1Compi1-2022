package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.analizadores.Token;

public class AccesoVariables {
    private Token token;
    private Object index;
    public AccesoVariables(){

    }
    public AccesoVariables(Token token,Object index){
        this.token = token;
        this.index = index;
    }
    public Object getIndex() {
        return index;
    }
    public Token getToken() {
        return token;
    }
    public void setIndex(Object index) {
        this.index = index;
    }
    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AccesoVariables{" + "token=" + token + ", index=" + index + '}';
    }
}
