/**
 * Descripción:Clase de ejemplo que demuestra el uso de la lista enlazada doble implementada en ListaDoble. 
 * En este ejemplo, se crean instancias de ListaSimple y se realizan varias operaciones, como
 * inserciones, búsquedas, intercambios y manipulaciones de nodos.
 * Clase recuperada y modificada de un ejercicio academico
 * Autores:  Martínez Chulin José Alexander
 * Fecha: 27/11/23
 */ 
public class UsaListaDoble
{
    public static void main(String [] args){
        
        ListaDoble lista = new ListaDoble();
        // Insertar nodos
        lista.insertaPrimerNodo("R");
        lista.imprimir();

        lista.insertaPrimerNodo("F");
        lista.imprimir();

        lista.insertaAntesPrimerNodo("H");
        lista.insertaAlFinal("Z");
        System.out.println(lista);

        // Insertar nodo entre nodos
        lista.insertaEntreNodos("T", "R");
        System.out.println(lista);

        // Insertar nodo antes del primer nodo
        lista.insertaAntesPrimerNodo("k");
        System.out.println(lista);

        // Insertar nodo al final
        lista.insertaAlFinal("Ñ");
        System.out.println(lista);

        // Borrar primer nodo
        lista.borrarPrimerNodo();
        System.out.println(lista);

        // Borrar último nodo
        lista.borrarUltimoNodo();
        System.out.println(lista);

        // Borrar nodo específico
        lista.borrarCualquierNodo("H");
        System.out.println(lista);
       
       
        // Buscar nodo
        Node nodoBuscado = lista.buscarNodo("Z");
        System.out.println("Nodo encontrado: " + (nodoBuscado != null ? nodoBuscado.name : "No encontrado"));
        
        // Insertar nodo después de un nodo buscado
        lista.insertarDespuesDeNodo("N", "Z");
        System.out.println(lista);
        
        // Intercambiar nodos ya creados
        lista.intercambiarNodosExistentes("T", "N");
        System.out.println(lista);
        
        // Sustituir un nodo por uno nuevo
        lista.sustituirNodo("N", "F");
        System.out.println(lista);

    }
}
