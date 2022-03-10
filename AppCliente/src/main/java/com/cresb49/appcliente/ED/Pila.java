package com.cresb49.appcliente.ED;

import java.util.ArrayList;

import com.cresb49.appcliente.ED.Exceptions.NoDataException;

public class Pila<T> {

    private NodoPila<T> raiz;
    private int size;

    /**
     * Contructor de la Pila
     */
    public Pila() {
        this.raiz = null;
        this.size = 0;
    }

    /**
     * Introduce un elemento en la pila
     *
     * @param data
     */
    public void push(T data) {
        if (this.raiz == null) {
            this.raiz = new NodoPila<T>(data, null);
            this.size++;
        } else {
            NodoPila<T> tmp = this.raiz;
            this.raiz = new NodoPila<T>(data, tmp);
            this.size++;
        }
    }

    /**
     * Retira el elmento superior de la pila sacandolo Si la pila esta vacia
     * genera una excepcion NoDataException
     *
     * @return
     */
    public T pop() throws NoDataException {
        if (this.isEmpty()) {
            throw new NoDataException("No hay elementos en la pila");
        } else {
            NodoPila<T> tmp = this.raiz;
            this.raiz = tmp.getNext();
            this.size--;
            return tmp.getData();
        }
    }

    /**
     * Retorna el objeto superior en la pila sin sacarlo Si la pila esta vacia
     * genera una excepcion NoDataException
     *
     * @return
     */
    public T peek() throws NoDataException {
        if (this.isEmpty()) {
            throw new NoDataException("No hay elementos en la pila");
        } else {
            return this.raiz.getData();
        }
    }

    /**
     * Retorna un valor logico si la pila esta vacia, true si lo esta, false si
     * esta tiene elementos
     *
     * @return
     */
    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna el tamaño de la pila
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Retorna la pila en forma de ArrayList
     *
     * @return
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> data = new ArrayList<>();
        if (this.raiz == null) {
            data = null;
        } else {
            NodoPila<T> tmp = this.raiz;
            while (tmp != null) {
                data.add(tmp.data);
                tmp = tmp.getNext();
            }
        }
        return data;
    }

    /**
     * Retorna la pila en forma de Array
     *
     * @return
     */
    public T[] toArray(Class<T[]> arrayType) {
        T[] res = null;
        if (this.toArrayList() == null) {
            return null;
        } else {
            res = arrayType.cast(java.lang.reflect.Array.newInstance(arrayType.getComponentType(), this.toArrayList().size()));
            for (int i = 0; i < res.length; i++) {
                res[i] = this.toArrayList().get(i);
            }
        }
        return res;
    }

    public void imprimirPila() {
        if (this.raiz == null) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("-----------------------");
            NodoPila<T> tmp = this.raiz;
            while (tmp != null) {
                System.out.println(tmp.toString());
                tmp = tmp.getNext();
            }
            System.out.println("-----------------------");
        }
    }

    public class NodoPila<T> {

        private NodoPila<T> next;
        private T data;

        public NodoPila(T data, NodoPila<T> next) {
            this.next = next;
            this.data = data;
        }

        /**
         * Retorna el siguiente elemento del nodo evaluado
         *
         * @return
         */
        public NodoPila<T> getNext() {
            return next;
        }

        /**
         * Retorna el dato guardado en el nodo evaluado
         *
         * @return
         */
        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Data: " + data;
        }

    }
}