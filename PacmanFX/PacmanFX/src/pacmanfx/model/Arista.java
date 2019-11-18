/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import java.util.List;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class Arista {

    private Integer peso;
    private Integer pesoOriginal;
    private Nodo origen;
    private Nodo destino;
    private Integer pesoCambio;
    private boolean bloqueado = false;

    public Arista() {
    }

    public Arista(Double posx, Double posy, Double posx2, Double posy2) {
        //Creo los nodos origen y destino de la ariata 
        this.origen = new Nodo(posx, posy);
        this.destino = new Nodo(posx2, posy2);
        Double p = origen.getPoint2D().distance(destino.getPoint2D());
        this.pesoOriginal = p.intValue();
        this.peso = p.intValue();
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPesoOriginal() {
        return pesoOriginal;
    }

    public void setPesoOriginal(Integer pesoOriginal) {
        this.pesoOriginal = pesoOriginal;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public Integer getPesoCambio() {
        return pesoCambio;
    }

    public void setPesoCambio(Integer pesoCambio) {
        this.pesoCambio = pesoCambio;
    }

    public void agregarNodos(List<Nodo> nodos) {

        for (Nodo nodo : nodos) {
            if (nodo.getPoint2D().getX() == getOrigen().getPoint2D().getX()
                    && nodo.getPoint2D().getY() == getOrigen().getPoint2D().getY()) {

                setOrigen(nodo);
                nodo.getAristas_Adyacentes().add(this);
            } else if (nodo.getPoint2D().getX() == getDestino().getPoint2D().getX()
                    && nodo.getPoint2D().getY() == getDestino().getPoint2D().getY()) {
                setDestino(nodo);
                nodo.getAristas_Adyacentes().add(this);
            }
        }
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    @Override
    public String toString() {
        return "Arista{" + "peso=" + peso + ", pesoOriginal=" + pesoOriginal + ", origen=" + origen.getPoint2D() + ", destino=" + destino.getPoint2D() + ", pesoCambio=" + pesoCambio + '}';
    }

}
