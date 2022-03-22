package com.cresb49.serverproyecto1.analizarjava.objetos;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public class Comentario {
    private String texto;
    private int repeticiones;

    public Comentario() {
    }

    public Comentario(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void agregarRepeticion(){
        this.repeticiones++;
    }

    /**
     * @return the repeticiones
     */
    public int getRepeticiones() {
        return repeticiones;
    }

    /**
     * @param repeticiones the repeticiones to set
     */
    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    /**
     * Este metodo recive el numero de repeticiones y la suma a la cantidad ya existente en el objeto
     * @param repeticiones
     */
    public void mezclarRepeticiones(int repeticiones){
        this.repeticiones = this.repeticiones + repeticiones;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Comentario [repeticiones=" + repeticiones + ", texto=" + texto + "]";
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
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }
    
}