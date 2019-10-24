/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class JugadorController extends Controller {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Label lbl;
    @FXML
    private ImageView logro1;
    @FXML
    private ImageView logro2;
    @FXML
    private ImageView logro3;
    @FXML
    private ImageView logro4;
    @FXML
    private ImageView logro5;
    @FXML
    private ImageView logro6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize() {
        Image imgLogo;
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
        logro1.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro2.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro3.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro4.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro5.setImage(new Image("/pacmanfx/resources/premio.png"));
        logro6.setImage(new Image("/pacmanfx/resources/premio.png"));
        /*
        logro1.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        logro2.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        logro3.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        logro4.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        logro5.setImage(new Image("/pacmanfx/resources/premiowhite.png"));
        logro6.setImage(new Image("/pacmanfx/resources/premiowhite.png"));*/

        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Datos.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                txtUsuario.setText(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }

    @FXML
    private void agregar(ActionEvent event) {
        try {
            if (!txtUsuario.getText().isEmpty()) {
                String content = txtUsuario.getText();
                File f = new File(".");
                String dir = f.getAbsolutePath();
                String path = dir + "\\src\\pacmanfx\\resources\\Datos.txt";
                Files.write(Paths.get(path), content.getBytes());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Nombre guardado exitosamente!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("INFORMACIÓN");
                alert.setContentText("Debes de escribir algo!");
                alert.showAndWait();

            }
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class
                    .getName()).log(Level.SEVERE, null, ex);
            lbl.setText("   Algo salió mal...");
        }
    }

}
