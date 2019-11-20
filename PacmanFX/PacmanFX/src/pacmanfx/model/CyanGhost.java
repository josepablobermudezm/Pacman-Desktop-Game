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
public class CyanGhost extends ImageView {

    private Nodo nodo = new Nodo(352.0,298.0);
    //en la parte de los nodos lo que se está guardando es la posición del Layout no la del nodo
    Image imgLogo;
    private boolean azul;
    public CyanGhost() {
        super();
        this.setLayoutX(352.0);
        this.setLayoutY(288.0);
        this.setId("CyanGhost");
        this.setFitHeight(30);
        this.setFitWidth(30);
        this.setImage(new Image("/pacmanfx/resources/blue-ghost.png"));
        this.azul = false;
    }

    public boolean isAzul() {
        return azul;
    }

    public void setAzul(boolean azul) {
        this.azul = azul;
    }
    
}
