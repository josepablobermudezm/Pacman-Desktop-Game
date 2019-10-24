/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import pacmanfx.model.Arista;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class MenuController extends Controller {

    @FXML
    private ImageView omg;

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
    private void Start(MouseEvent event) {
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(dir + "\\src\\pacmanfx\\resources\\Datos.txt"));
            String line = null;

            if ((line = reader.readLine()) == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR AL MOMENTO DE INGRESAR");
                alert.setHeaderText("NOMBRE DE USUARIO");
                alert.setContentText("Debes de ingresar tu nombre de usuario antes de poder jugar!");
                alert.showAndWait();
            } else {
                FlowController.getInstance().initialize();
                FlowController.getInstance().goViewInStage("SeleccionNivel", this.getStage());
            }
        } catch (IOException | NumberFormatException e) {
        }

        //this.getStage().close();
    }

    @FXML
    private void Configuracion(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Configuracion", this.getStage());
        //this.getStage().close();
    }

    @FXML
    private void Salir(MouseEvent event) {
        //FlowController.getMainStage().close();
        this.getStage().close();
    }

    @FXML
    private void jugador(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Jugador", this.getStage());
    }

}
