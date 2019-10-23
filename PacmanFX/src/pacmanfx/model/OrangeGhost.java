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
public class OrangeGhost extends ImageView{
    private Nodo nodo = new Nodo(449.0,298.0);
    Image imgLogo;
    
    public OrangeGhost(){
        super();
        this.setLayoutX(435.0);
        this.setLayoutY(288.0);
        this.setId("OrangeGhost");
        this.setFitHeight(30);
        this.setFitWidth(30);
        this.setImage(new Image("/pacmanfx/resources/yellow-ghost.png"));
    }
}
