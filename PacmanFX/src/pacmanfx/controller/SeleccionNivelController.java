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
public class SeleccionNivelController extends Controller {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize() {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo8.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }

    @FXML
    private void Nivel1(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel1", this.getStage());
    }

    @FXML
    private void Nivel2(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel2", this.getStage());
    }

    @FXML
    private void Nivel3(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Nivel3", this.getStage());
    }

    @FXML
    private void Nivel4(MouseEvent event) {
        FlowController.getInstance().goViewInWindowTransparent("Nivel4");
        this.getStage().close();
    }

    @FXML
    private void Nivel5(MouseEvent event) {
    }

    @FXML
    private void Nivel6(MouseEvent event) {
    }

    @FXML
    private void Nivel7(MouseEvent event) {
    }

    @FXML
    private void Nivel8(MouseEvent event) {
    }

    @FXML
    private void Nivel9(MouseEvent event) {
    }

    @FXML
    private void Nivel10(MouseEvent event) {
    }

}
