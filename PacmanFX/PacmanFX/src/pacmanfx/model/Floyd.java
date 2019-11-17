/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import java.util.ArrayList;
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
    private Integer[][] D;
    private Integer[][] traza;
    
    public Floyd(Integer n) {
        this.n = n;
    }

    public void matrizAdyacencia(Integer[][] mady) {
        int i, j, k;
        
        // Camino mínimo de un vértice a si mismo: 0
        for (i = 0; i < n; i++) {
            D[i][i] = 0;
        }
        /* En el caso de que no se realice esta inicialización el algoritmo
	obtiene en la diagonal los ciclos o bucles de longitud mínima */
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

    }

    public ArrayList<Integer> floyd_cam(Integer[][] mady, int ini, int fin) {

        int aux;

        Integer mCaminos[][] = new Integer[mady.length][mady.length];
        Integer mAux[][] = new Integer[mady.length][mady.length];
        for (int x = 0; x < mady.length; x++) {
            for (int y = 0; y < mady.length; y++) {
                mCaminos[y][x] = y;
                mAux[x][y] = mady[x][y];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x != y) {
                    for (int z = 0; z < n; z++) {
                        if (z != x) {
                            aux = mAux[x][y] + mAux[z][x];
                            if (aux < mAux[z][y]) {
                                mAux[z][y] = aux;
                                mCaminos[z][y] = x;
                            }
                        }
                    }
                }
            }
        }

        recuperaCamino(ini, fin, mCaminos);

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
        return rutInteger;

    }

    public void recuperaCamino(int i, int j, Integer[][] mRecorrido) {
        rutInteger.add(i);
        recupera(i, j, mRecorrido);
        rutInteger.add(j);
    }

    public void recupera(int i, int j, Integer[][] mRecorrido) {
        int k = mRecorrido[i][j];
        if (k != i) {
            recupera(i, k, mRecorrido);
            System.out.println(k);
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

}
