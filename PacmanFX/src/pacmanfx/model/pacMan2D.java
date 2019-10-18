/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import com.sun.javafx.geom.Arc2D;



/**
 *
 * @author Jose Pablo Bermudez
 */
public class pacMan2D {

    private Nodo nodo = new Nodo();
    private Arc2D pMan;

    public pacMan2D() {

    }
/*
    Debe setear las aristas adyacentes constantemenente 
    */


    public pacMan2D(float x, float y, float w, float h, float angSt, float angExt, int closure) {
        pMan = new Arc2D(x, y, w, h, angSt, angExt, closure);
        
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Arc2D getpMan() {
        return pMan;
    }

    public void setpMan(Arc2D pMan) {
        this.pMan = pMan;
    }
    
    

}
