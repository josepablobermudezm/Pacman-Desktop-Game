/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class GameOverController extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private Label lblVolver1;
    @FXML
    private Label lblVolver11;
    @FXML
    private Label puntosTotales;
    private int puntajeTotal = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo8.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
        puntosTotales.setText(String.valueOf(puntajeTotal));
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("SeleccionNivel", this.getStage());
    }

    @Override
    public void initialize() {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo4.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
    }

    @FXML
    private void seguirJugando(MouseEvent event) {
    }

    @FXML
    private void Abandonar(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }

}
