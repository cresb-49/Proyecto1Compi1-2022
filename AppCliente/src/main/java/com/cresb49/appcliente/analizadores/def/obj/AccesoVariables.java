package com.cresb49.appcliente.analizadores.def.obj;

import com.cresb49.appcliente.analizadores.Token;

public class AccesoVariables {
    private Token token;
    private Object variable;
    private Object index;
    public AccesoVariables(){

    }
    public AccesoVariables(Token token,Object variable,Object index){
        this.token = token;
        this.variable = variable;
        this.index = index;
    }
    public Object getIndex() {
        return index;
    }
    public Token getToken() {
        return token;
    }
    public Object getVariable() {
        return variable;
    }
    public void setIndex(Object index) {
        this.index = index;
    }
    public void setToken(Token token) {
        this.token = token;
    }
    public void setVariable(Object variable) {
        this.variable = variable;
    }
}
