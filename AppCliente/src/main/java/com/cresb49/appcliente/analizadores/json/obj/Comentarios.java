/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.analizadores.json.obj;

import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class Comentarios {
    private String texto;

    public Comentarios() {
    }

    public Comentarios(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "texto=" + texto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.texto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentarios other = (Comentarios) obj;
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }
    
}
