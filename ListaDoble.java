/**
 * Descripción:Clase que implementa una lista enlazada doble. Permite la manipulación de nodos en una lista enlazada doble, incluyendo inserciones, eliminaciones,
 * búsquedas y operaciones de intercambio. Esta clase proporciona métodos para realizar diversas operaciones comunes en listas enlazadas.
 * Clase recuperada y modificada de un ejercicio academico
 * Autores: Martínez Chulin José Alexander
 * Fecha: 27/11/23
 */ 
public class ListaDoble{

    Node topForward;
    Node topBackward;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (topForward == null) { //La lista está vacía
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;

            topBackward = topForward;

            return true;
        }
        else {
            return false;
        }
    }

    public void imprimir(){
        System.out.print("[X]"); 

        for (Node temp = this.topForward; temp != null; temp = temp.next){
            System.out.print(" ← [ " + temp.name + " ] → ");
        }

        System.out.print("[X]\n"); 
    }

    public String toString(){
        String cadAux = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next){
            cadAux += " ← [ " + temp.name + " ] → ";
        }

        cadAux += "[X]"; 

        return cadAux;
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp; 
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;

        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null) 
        && temp2.name.equals(buscado) == false ) {    
            temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;

            return true;
        }
        else return false;
    } 

    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    public void borrarUltimoNodo(){
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }

    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.topForward;

        while ( (temp != null) 
        && temp.name.equals(buscado) == false ) {    
            temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;

            return true;
        }
        else return false;
    }

    // buscar
    public Node buscarNodo(String buscado) {
        Node temp = this.topForward;

        while (temp != null && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        return temp;
    }

    // insertar despues 
    public boolean insertarDespuesDeNodo(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        while (temp2 != null && !temp2.name.equals(buscado)) {
            temp2 = temp2.next;
        }

        if (temp2 != null) {
            temp.next = temp2.next;
            temp2.next = temp;

            if (temp.next != null) {
                temp.next.previous = temp;
            } else {
                this.topBackward = temp;
            }

            temp.previous = temp2;
            temp = null;
            temp2 = null;

            return true;
        } else {
            return false;
        }
    }
    // intercambiar nodos ya creados
    public boolean intercambiarNodosExistentes(String nombreNodo1, String nombreNodo2) {
        Node nodo1 = buscarNodo(nombreNodo1);
        Node nodo2 = buscarNodo(nombreNodo2);

        if (nodo1 != null && nodo2 != null && nodo1 != nodo2) {
            // Actualizar referencias de nodos vecinos de nodo1
            if (nodo1.previous != null) {
                nodo1.previous.next = nodo2;
            } else {
                topForward = nodo2;
            }

            if (nodo1.next != null) {
                nodo1.next.previous = nodo2;
            } else {
                topBackward = nodo2;
            }

            // Actualizar referencias de nodos vecinos de nodo2
            if (nodo2.previous != null) {
                nodo2.previous.next = nodo1;
            } else {
                topForward = nodo1;
            }

            if (nodo2.next != null) {
                nodo2.next.previous = nodo1;
            } else {
                topBackward = nodo1;
            }

            // Intercambiar referencias de nodo1 y nodo2
            Node tempPrevious = nodo1.previous;
            Node tempNext = nodo1.next;

            nodo1.previous = nodo2.previous;
            nodo1.next = nodo2.next;

            nodo2.previous = tempPrevious;
            nodo2.next = tempNext;

            return true;
        } else {
            return false;
        }
    }
    // Sustituir 
    public void sustituirNodo(String nodoAntiguo, String nuevoNombre) {
        Node nodoExistente = buscarNodo(nodoAntiguo);

        if (nodoExistente != null) {
            // Crear nuevo nodo
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoNombre;

            // Actualizar referencias de nodos vecinos
            if (nodoExistente.previous != null) {
                nodoExistente.previous.next = nuevoNodo;
            } else {
                topForward = nuevoNodo;
            }

            if (nodoExistente.next != null) {
                nodoExistente.next.previous = nuevoNodo;
            } else {
                topBackward = nuevoNodo;
            }

            // Copiar referencias del nodo existente al nuevo nodo
            nuevoNodo.previous = nodoExistente.previous;
            nuevoNodo.next = nodoExistente.next;

            // Liberar el nodo existente
            nodoExistente = null;
        }
    }
}

