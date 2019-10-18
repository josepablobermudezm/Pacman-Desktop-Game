/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class Nodo {

    private final List<Arista> aristas_Adyacentes = new ArrayList<>();
    private final List<Nodo> nodos_Adyacentes = new ArrayList<>();
    private Point2D point2D;

    public Nodo() {
    }

    Nodo(Double posx, Double posy) {
        point2D = new Point2D(posx, posy);
    }

    public Point2D getPoint2D() {
        return point2D;
    }

    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;
    }

    public void distancia() {
        this.point2D.distance(point2D);
    }

    public List<Arista> getAristas_Adyacentes() {
        return aristas_Adyacentes;
    }

    public List<Nodo> getNodos_Adyacentes() {
        return nodos_Adyacentes;
    }

}
