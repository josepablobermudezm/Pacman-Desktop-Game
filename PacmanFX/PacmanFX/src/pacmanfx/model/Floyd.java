/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.paint.Color;

/**
 *
 * @author JORDI RODRIGUEZ
 */
public class Floyd {

    private ArrayList<Integer> rutInteger = new ArrayList<>();
    private ArrayList<Nodo> nodosRuta = new ArrayList<>();
    private ArrayList<Arista> aristaRuta = new ArrayList<>();
    private Integer n;
    private Integer[][] mCaminos;
    private Integer[][] mAux;
    private Stack <Integer> caminos = new Stack();
    
    public Floyd(Integer n) {
        this.n = n;
    }

    /*public void matrizAdyacencia(Integer[][] mady) {
        int i, j, k;

        // Camino mínimo de un vértice a si mismo: 0
        for (i = 0; i < n; i++) {
            D[i][i] = 0;
        }
        /* En el caso de que no se realice esta inicialización el algoritmo
	obtiene en la diagonal los ciclos o bucles de longitud mínima 
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if ((D[i][k] + D[k][j]) < D[i][j]) // nuevo mínimo
                    {
                        D[i][j] = D[i][k] + D[k][j];
                        traza[i][j] = k;
                    }
                }
            }
        }
    }*/
    public void iniciarMatriz(Integer[][] mady) {

        int aux;

        mCaminos = new Integer[mady.length][mady.length];
        mAux = new Integer[mady.length][mady.length];

        for (int i = 0; i < mady.length; i++) {
            for (int j = 0; j < mady.length; j++) {
                mCaminos[i][j] = -1;
                mAux[i][j] = mady[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (k != i) {
                    for (int j = 0; j < n; j++) {
                        aux = mAux[k][i] + mAux[j][k];
                        if (aux < mAux[i][j]) {
                            mAux[i][j] = aux;
                            mCaminos[i][j] = k;
                        }
                    }
                }
            }
        }

//        recuperaCamino(ini, fin, mCaminos);

        /*      rutInteger.stream().forEach((y) -> {
            grafo.getDestinos().stream().forEach((t) -> {
                if (t.getNumNodo().equals(y)) {
                    t.setMarca(true);
                    nodosRuta.add(t);
                }
            });
        });

        grafo.getAristas().stream().forEach((t) -> {
            nodosRuta.stream().forEach((y) -> {
                int i = nodosRuta.indexOf(y) + 1;
                if (i < nodosRuta.size()) {
                    Nodo auxNodo = nodosRuta.get(i);
                    if (auxNodo.equals(t.getDestino()) && y.equals(t.getOrigen()) || auxNodo.equals(t.getOrigen()) && y.equals(t.getDestino())) {
                        aristaRuta.add(t);
                    }
                }
            });
        });
         */
        // return rutInteger;
    }

    public void recuperaCamino(int i, int j) {
        rutInteger.add(i);
        recupera(i, j, mCaminos);
        rutInteger.add(j);
    }

    public void recupera(int i, int j, Integer[][] mRecorrido) {
        int k = mRecorrido[i][j];
        if (k != -1) {
            recupera(i, k, mRecorrido);
            caminos.push(k);
            rutInteger.add(k);
            recupera(k, j, mRecorrido);
        }
    }

    public void marcarRuta() {
        aristaRuta.stream().forEach((t) -> {
            /*t.setStroke(Color.BLACK);
            t.setStrokeWidth(5);*/
        });
    }

    public ArrayList<Nodo> getNodosRuta() {
        return nodosRuta;
    }

    public void setNodosRuta(ArrayList<Nodo> nodosRuta) {
        this.nodosRuta = nodosRuta;
    }

    public ArrayList<Arista> getAristaRuta() {
        return aristaRuta;
    }

    public void setAristaRuta(ArrayList<Arista> aristaRuta) {
        this.aristaRuta = aristaRuta;
    }

    public Stack<Integer> getCaminos() {
        return caminos;
    }

}
