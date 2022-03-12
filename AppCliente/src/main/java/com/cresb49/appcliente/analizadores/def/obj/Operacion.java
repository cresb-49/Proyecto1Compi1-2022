/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cresb49.appcliente.analizadores.def.obj;

import java.util.Objects;
import javax.swing.text.TabableView;

/**
 *
 * @author Benjamin
 */
public class Operacion {

    private String tipo;
    private Object valor;

    public Operacion(String tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Operacion() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    /**
     * Realiza el auto casteo de parametros si no se puede realizar utilizara el
     * tipo de la primera variable
     *
     * @param tipoval1
     * @param operacion
     * @param tipoval2
     * @return
     * @throws NotCastException
     */
    public static String autoCast(String tipoval1, String operacion, String tipoval2) throws NotCastException {

        switch (operacion) {
            case TablaSimbolos.MAS: {
                if (tipoval1.equals(TablaSimbolos.STRING) && tipoval2.equals(TablaSimbolos.STRING)) {
                    return TablaSimbolos.STRING;
                } else if (tipoval1.equals(TablaSimbolos.STRING) && tipoval2.equals(TablaSimbolos.INT)) {
                    return TablaSimbolos.STRING;
                } else if (tipoval1.equals(TablaSimbolos.INT) && tipoval2.equals(TablaSimbolos.STRING)) {
                    return TablaSimbolos.STRING;
                } else if (tipoval1.equals(TablaSimbolos.INT) && tipoval2.equals(TablaSimbolos.INT)) {
                    return TablaSimbolos.INT;
                } else {
                    throw new NotCastException();
                }
            }
            case TablaSimbolos.MENOS: {
                if (tipoval1.equals(TablaSimbolos.INT) && tipoval2.equals(TablaSimbolos.INT)) {
                    return TablaSimbolos.INT;
                } else {
                    throw new NotCastException();
                }
            }
            case TablaSimbolos.MUL: {
                if (tipoval1.equals(TablaSimbolos.INT) && tipoval2.equals(TablaSimbolos.INT)) {
                    return TablaSimbolos.INT;
                } else {
                    throw new NotCastException();
                }
            }
            case TablaSimbolos.DIV: {
                if (tipoval1.equals(TablaSimbolos.INT) && tipoval2.equals(TablaSimbolos.INT)) {
                    return TablaSimbolos.INT;
                } else {
                    throw new NotCastException();
                }
            }
        }
        return tipoval1;
    }

    public static Object sumaTerminos(Operacion val1, Operacion val2) {
        Object result = null;

        if (val1.getTipo().equals(TablaSimbolos.STRING) && val2.getTipo().equals(TablaSimbolos.STRING)) {
            String vval1 = (String) val1.getValor();
            String vval2 = (String) val2.getValor();
            result = (vval1 + vval2);
            
        } else if (val1.getTipo().equals(TablaSimbolos.STRING) && val2.getTipo().equals(TablaSimbolos.INT)) {
            String vval1 = (String) val1.getValor();
            Integer vval2 = (Integer) val2.getValor();
            result = (vval1 + vval2.toString());
            
        } else if (val1.getTipo().equals(TablaSimbolos.INT) && val2.getTipo().equals(TablaSimbolos.STRING)) {
            Integer vval1 = (Integer) val1.getValor();
            String vval2 = (String) val2.getValor();
            result = (vval1.toString() + vval2);
            
        } else if (val1.getTipo().equals(TablaSimbolos.INT) && val2.getTipo().equals(TablaSimbolos.INT)) {
            Integer vval1 = (Integer) val1.getValor();
            Integer vval2 = (Integer) val2.getValor();
            result = (vval1 + vval2);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Operacion{" + "tipo=" + tipo + ", valor=" + valor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.tipo);
        hash = 71 * hash + Objects.hashCode(this.valor);
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
        final Operacion other = (Operacion) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }
}
