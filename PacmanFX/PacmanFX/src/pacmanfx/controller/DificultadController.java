/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
public class DificultadController extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private Label lblFacil;
    @FXML
    private Label lblIntermedio;
    @FXML
    private Label lblDificil;
    private int Dificultad = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Inicio();
    }    

    public void Inicio(){
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo8.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Dificultad.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //guardo lo que eset en el txt en la variable dificultad
                Dificultad = Integer.parseInt(line);
            }
            /*
                Dependiendo de cual este seleccionada le cambio del ID para que así se le seleccione un style diferente
            */
            if(Dificultad == 1){
                lblFacil.setId("lblSelected");
            }else if(Dificultad == 2){
                lblIntermedio.setId("lblSelected");
            }else if(Dificultad == 3){
                lblDificil.setId("lblSelected");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void initialize() {
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Configuracion", this.getStage());
    }

    /*
        Guardo la dificultad deseada en un txt para mantener el dato
    */
    
    @FXML
    private void facil(MouseEvent event) {
        try {
            String content = "1";
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Dificultad.txt";
            Files.write(Paths.get(path), content.getBytes());
            //para que actualice la nueva elección
            Inicio();
            lblDificil.setId("lblDificil");
            lblIntermedio.setId("lblIntermedio");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    @FXML
    private void intermedio(MouseEvent event) {
        try {
            String content = "2";
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Dificultad.txt";
            Files.write(Paths.get(path), content.getBytes());
            //para que actualice la nueva elección
            Inicio();
            lblFacil.setId("lblFacil");
            lblDificil.setId("lblDificil");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    @FXML
    private void dificil(MouseEvent event) {
        try {
            String content = "3";
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Dificultad.txt";
            Files.write(Paths.get(path), content.getBytes());
            //para que actualice la nueva elección
            Inicio();
            lblFacil.setId("lblFacil");
            lblIntermedio.setId("lblIntermedio");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }
    
}
