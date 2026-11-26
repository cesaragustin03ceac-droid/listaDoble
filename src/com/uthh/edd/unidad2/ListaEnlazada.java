/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2;

/**
 *
 * @author Emi
 */
public class ListaEnlazada {
    
    private Nodo cabeza;
    private int tamanio;
    
    public ListaEnlazada(){
        this.cabeza=null; //empieza desde 0
        this.tamanio=0; //saber nodos que maneja la lista
    }
    
    public boolean estaVacia() {
        //return cabeza == null;
        if(cabeza==null){
            return true;
        }else{
            return false;
        }
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void insertarInicio(int x){
        Nodo nuevo = new Nodo(x,cabeza);
        cabeza=nuevo;
        tamanio++;
    }
    
    public void insertarFinal(int dato){
        Nodo nuevo = new Nodo(dato);
        if(estaVacia()){
            cabeza=nuevo;
        }else{
            Nodo aux=cabeza;
            while(aux.getSiguiente()!=null){
            aux=aux.getSiguiente();
        }
            aux.setSiguiente(nuevo);
        }
        tamanio++;
    }
    
    public int eliminarInicio(){
        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }
        
        int datoEliminado=cabeza.getDato();
        cabeza=cabeza.getSiguiente();
        tamanio--;
        return datoEliminado;
    }
    
    public boolean eliminarPorVair (int valor){
        if (estaVacia()){
            return false;
        }            
        
        if(cabeza.getDato()==valor){
            cabeza=cabeza.getSiguiente();
            tamanio--;
            return true;
        }
        
        Nodo aux=cabeza;
        while(aux.getSiguiente()!=null){
            if (aux.getSiguiente().getDato()==valor){
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                tamanio--;
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    public boolean buscar(int dato){
        Nodo aux = cabeza;
        while(aux!=null){
            if(aux.getDato()==dato){
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    @Override
    public String toString(){
        String res="";
        Nodo aux=cabeza;
        while(aux!=null){
            res += "["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res+="null";
        return res;
    }
    
    public Nodo obtenerNodo(int pos){
        if(pos<=0 ||pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        Nodo aux=cabeza;
        for(int i=1;i<pos;i++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    
    public void actualizar(int pos, int valor){
        Nodo val=obtenerNodo(pos);
        val.setDato(valor);
    }
    
    public void insertarEnPosicion(int pos,int valor){
        if(pos<=0 || pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        if(pos==1){
            insertarInicio(valor);
            return;
        }
       Nodo aux=obtenerNodo(pos-1);
       Nodo nuevo=new Nodo(11);
        
       nuevo.setSiguiente(aux.getSiguiente());
       aux.setSiguiente(nuevo);
       tamanio++;
    }
    
    public int eliminarEnPosicion(int pos){
        if (pos<=0 || pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        
        if(pos==1){
            return eliminarInicio();
        }
        
        Nodo aux=obtenerNodo(pos-1);
        Nodo objetivo=aux.getSiguiente();
        int dato = objetivo.getDato();
        aux.setSiguiente(objetivo.getSiguiente());
        tamanio--;
        return dato;
    }
    public void insertarOrdenado(int dato) {
        // Si está vacía o es menor que cabeza, va al inicio
        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarInicio(dato);
            return;
        }

        // Recorremos hasta encontrar su lugar
        Nodo aux = cabeza;
        while (aux.getSiguiente() != null && aux.getSiguiente().getDato() < dato) {
            aux = aux.getSiguiente();
        }

        Nodo nuevo = new Nodo(dato);
        // Primero conectamos el nuevo al siguiente para no perder los nodos
        nuevo.setSiguiente(aux.getSiguiente());
        // Luego aux apunta al nuevo nodo
        aux.setSiguiente(nuevo);
        tamanio++;
    }

}