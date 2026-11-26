package com.uthh.edd.unidad2;

public class Main {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarOrdenado(25);
        System.out.println(lista);

        lista.insertarOrdenado(10);
        System.out.println(lista);

        lista.insertarOrdenado(40);
        System.out.println(lista);

        lista.insertarOrdenado(5); 
        System.out.println(lista);

        lista.insertarOrdenado(30);
        System.out.println(lista);

        lista.insertarOrdenado(50); 
        System.out.println(lista);
    }
}