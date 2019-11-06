/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class Grafo {

    public static ArrayList<Nodo> nodos = new ArrayList();
    private static ArrayList<Arista> aristas = new ArrayList();
    private ArrayList<Nodo> listaDirigida = new ArrayList();

    public Grafo() {
    }
    
    public Arista getArista(Nodo origen, Nodo destino) {
        Arista aux = null;
        for (Arista a : getAristas()) {
            if ((a.getOrigen().equals(origen) && a.getDestino().equals(destino)) || (a.getDestino().equals(origen) && a.getOrigen().equals(destino))) {
                aux = a;
            }
        }
        return aux;
    }

    public Grafo(ArrayList<Nodo> nodos, ArrayList<Arista> aristas) {
        this.nodos = nodos;
        this.aristas = aristas;
    }

    public ArrayList<Nodo> getListaDirigida() {
        return listaDirigida;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public static ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public static void setNodos(ArrayList<Nodo> nodos) {
        Grafo.nodos = nodos;
    }

}
