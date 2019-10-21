/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class pacMan2D {

    private Nodo nodo = new Nodo();
    private Arc pMan;

    public pacMan2D() {

    }

    /*
    Debe setear las aristas adyacentes constantemenente 
     */
    public pacMan2D(Double x, Double y, Double w, Double h, Double angSt, Double angExt) {
        pMan = new Arc(x, y, h, w, angSt, angExt);
        pMan.setFill(Paint.valueOf("YELLOW"));
        pMan.setType(ArcType.ROUND);
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Arc getpMan() {
        
        return pMan;
    }

    public void setpMan(Arc pMan) {
        this.pMan = pMan;
    }

}
