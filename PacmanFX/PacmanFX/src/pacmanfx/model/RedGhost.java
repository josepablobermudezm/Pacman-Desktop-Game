/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author JORDI RODRIGUEZ
 */
public class RedGhost extends ImageView {

    private Nodo nodo = new Nodo(449.0,240.0);
    private boolean Azul = false;
    Image imgLogo;
        
    //en la parte de los nodos lo que se está guardando es la posición del Layout no la del nodo
    public RedGhost() {
        super();
        this.setLayoutX(435.0);
        this.setLayoutY(223.0);
        this.setId("RedGhost");
        this.setFitHeight(30);
        this.setFitWidth(30);
        this.setImage(new Image("/pacmanfx/resources/red-ghost.png"));
    }

    public boolean isAzul() {
        return Azul;
    }

    public void setAzul(boolean Azul) {
        this.Azul = Azul;
    }

    
    public void GenerarRuta(Nodo ini, Nodo fin) {
    }
}
