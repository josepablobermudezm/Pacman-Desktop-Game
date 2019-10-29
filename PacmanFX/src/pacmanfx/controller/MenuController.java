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
public class MenuController extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    static public int PuntosTotales = 0;
    static public int MayorCantidadDePuntosPartida = 0;
    static public int TiempoTotalJuego = 0;

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
        //verifico que ya haya puesto el nombre
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
        
        /*
            Puntos totales ganador en el juego
        */
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\TotalPuntosGanados.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                PuntosTotales += Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String content = String.valueOf(PuntosTotales);
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String path = dir + "\\src\\pacmanfx\\resources\\TotalPuntosGanados.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
            Tiempo total en el juego
        */
        
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\TiempoTotalJuego.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                TiempoTotalJuego += Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String content = String.valueOf(TiempoTotalJuego);
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String path = dir + "\\src\\pacmanfx\\resources\\TiempoTotalJuego.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getStage().close();
    }

    @FXML
    private void jugador(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Jugador", this.getStage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo4.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
    }

}
