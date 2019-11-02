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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class ConfiguracionController extends Controller implements Initializable {

    @FXML
    private Label lblVolver;
    @FXML
    private ImageView omg;
    @FXML
    private TextField txtPuntosTotales;
    @FXML
    private TextField txtMayorCantPartida;
    @FXML
    private TextField txtNivel1Completado;
    @FXML
    private TextField txtNivel2Completado;
    @FXML
    private TextField txtNivel3Completado;
    @FXML
    private TextField txtNivel4Completado;
    @FXML
    private TextField txtNivel5Completado;
    @FXML
    private TextField txtNivel6Completado;
    @FXML
    private TextField txtNivel7Completado;
    @FXML
    private TextField txtNivel8Completado;
    @FXML
    private TextField txtNivel9Completado;
    @FXML
    private Button btnGuardarMayorCantPartida111111111;
    @FXML
    private TextField txtNivel10Completado;
    @FXML
    private TextField txtCantFantasmas;
    @FXML
    private TextField txtCantVidas;
    @FXML
    private TextField txtEncierros;
    @FXML
    private Button btnDificultad;
    @FXML
    private Button btnEliminarTodo;

    @Override
    public void initialize() {

    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Menu", this.getStage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image imgLogo;
        try {
            imgLogo = new Image("/pacmanfx/resources/fondo8.jpg");
            omg.setImage(imgLogo);
        } catch (Exception e) {
        }
        /*
            Cargo todos los datos desde los bloc de notas hasta los textfield para que posteriormente se puedan editar
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
                txtPuntosTotales.setText(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int MayorCantPartida = 0;
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\MayorCantidadDePuntosPartida.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                MayorCantPartida = Integer.parseInt(line);
            }
            MayorCantPartida *= 10;
            txtMayorCantPartida.setText(String.valueOf(MayorCantPartida));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Nivel1Completado.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                txtNivel1Completado.setText(line);
            }
            File f2 = new File(".");
            String dir2 = f2.getAbsolutePath();
            String fileName2 = dir2 + "\\src\\pacmanfx\\resources\\Nivel2Completado.txt";
            File file2 = new File(fileName2);
            FileReader fr2 = new FileReader(file2);
            BufferedReader br2 = new BufferedReader(fr2);
            String line2;
            while ((line2 = br2.readLine()) != null) {
                txtNivel2Completado.setText(line2);
            }
            File f3 = new File(".");
            String dir3 = f3.getAbsolutePath();
            String fileName3 = dir3 + "\\src\\pacmanfx\\resources\\Nivel3Completado.txt";
            File file3 = new File(fileName3);
            FileReader fr3 = new FileReader(file3);
            BufferedReader br3 = new BufferedReader(fr3);
            String line3;
            while ((line3 = br3.readLine()) != null) {
                txtNivel3Completado.setText(line3);
            }
            File f4 = new File(".");
            String dir4 = f4.getAbsolutePath();
            String fileName4 = dir4 + "\\src\\pacmanfx\\resources\\Nivel4Completado.txt";
            File file4 = new File(fileName4);
            FileReader fr4 = new FileReader(file4);
            BufferedReader br4 = new BufferedReader(fr4);
            String line4;
            while ((line4 = br4.readLine()) != null) {
                txtNivel4Completado.setText(line4);
            }
            File f5 = new File(".");
            String dir5 = f5.getAbsolutePath();
            String fileName5 = dir5 + "\\src\\pacmanfx\\resources\\Nivel5Completado.txt";
            File file5 = new File(fileName5);
            FileReader fr5 = new FileReader(file5);
            BufferedReader br5 = new BufferedReader(fr5);
            String line5;
            while ((line5 = br5.readLine()) != null) {
                txtNivel5Completado.setText(line5);
            }
            File f6 = new File(".");
            String dir6 = f6.getAbsolutePath();
            String fileName6 = dir6 + "\\src\\pacmanfx\\resources\\Nivel6Completado.txt";
            File file6 = new File(fileName6);
            FileReader fr6 = new FileReader(file6);
            BufferedReader br6 = new BufferedReader(fr6);
            String line6;
            while ((line6 = br6.readLine()) != null) {
                txtNivel6Completado.setText(line6);
            }
            File f7 = new File(".");
            String dir7 = f7.getAbsolutePath();
            String fileName7 = dir7 + "\\src\\pacmanfx\\resources\\Nivel7Completado.txt";
            File file7 = new File(fileName7);
            FileReader fr7 = new FileReader(file7);
            BufferedReader br7 = new BufferedReader(fr7);
            String line7;
            while ((line7 = br7.readLine()) != null) {
                txtNivel7Completado.setText(line7);
            }
            File f8 = new File(".");
            String dir8 = f8.getAbsolutePath();
            String fileName8 = dir8 + "\\src\\pacmanfx\\resources\\Nivel8Completado.txt";
            File file8 = new File(fileName8);
            FileReader fr8 = new FileReader(file8);
            BufferedReader br8 = new BufferedReader(fr8);
            String line8;
            while ((line8 = br8.readLine()) != null) {
                txtNivel8Completado.setText(line8);
            }
            File f9 = new File(".");
            String dir9 = f9.getAbsolutePath();
            String fileName9 = dir9 + "\\src\\pacmanfx\\resources\\Nivel9Completado.txt";
            File file9 = new File(fileName9);
            FileReader fr9 = new FileReader(file9);
            BufferedReader br9 = new BufferedReader(fr9);
            String line9;
            while ((line9 = br9.readLine()) != null) {
                txtNivel9Completado.setText(line9);
            }
            File f10 = new File(".");
            String dir10 = f10.getAbsolutePath();
            String fileName10 = dir10 + "\\src\\pacmanfx\\resources\\Nivel10Completado.txt";
            File file10 = new File(fileName10);
            FileReader fr10 = new FileReader(file10);
            BufferedReader br10 = new BufferedReader(fr10);
            String line10;
            while ((line10 = br10.readLine()) != null) {
                txtNivel10Completado.setText(line10);
            }
            File f11 = new File(".");
            String dir11 = f11.getAbsolutePath();
            String fileName11 = dir11 + "\\src\\pacmanfx\\resources\\FantasmasComidos.txt";
            File file11 = new File(fileName11);
            FileReader fr11 = new FileReader(file11);
            BufferedReader br11 = new BufferedReader(fr11);
            String line11;
            while ((line11 = br11.readLine()) != null) {
                txtCantFantasmas.setText(line11);
            }
            File f12 = new File(".");
            String dir12 = f12.getAbsolutePath();
            String fileName12 = dir12 + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
            File file12 = new File(fileName12);
            FileReader fr12 = new FileReader(file12);
            BufferedReader br12 = new BufferedReader(fr12);
            String line12;
            while ((line12 = br12.readLine()) != null) {
                txtCantVidas.setText(line12);
            }
            File f13 = new File(".");
            String dir13 = f13.getAbsolutePath();
            String fileName13 = dir13 + "\\src\\pacmanfx\\resources\\Encierro5VecesCont.txt";
            File file13 = new File(fileName13);
            FileReader fr13 = new FileReader(file13);
            BufferedReader br13 = new BufferedReader(fr13);
            String line13;
            while ((line13 = br13.readLine()) != null) {
                txtEncierros.setText(line13);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GuardarEncierroCantidad() {
        try {
            String content = txtEncierros.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Encierro5VecesCont.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Editar Puntos Totales");
            alert.setContentText("Error al editar Puntos totales");
            alert.showAndWait();
        }
    }
    
    private void GuardarPuntosTotales() {
        try {
            String content = txtPuntosTotales.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\TotalPuntosGanados.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Editar Puntos Totales");
            alert.setContentText("Error al editar Puntos totales");
            alert.showAndWait();
        }
    }

    private void GuardarMayorCantPartida() {
        try {
            Integer contentAux = Integer.parseInt(txtMayorCantPartida.getText());
            contentAux /= 10;
            String content = String.valueOf(contentAux);
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\MayorCantidadDePuntosPartida.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Editar mayor cantidad de puntos en una partida");
            alert.setContentText("Error al editar mayor cantidad de puntos en una partida");
            alert.showAndWait();
        }
    }

    private void GuardarNivel1() {
        try {
            String content = txtNivel1Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel1Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel2() {
        try {
            String content = txtNivel2Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel2Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel3() {
        try {
            String content = txtNivel3Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel3Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel4() {
        try {
            String content = txtNivel4Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel4Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel5() {
        try {
            String content = txtNivel5Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel5Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel6() {
        try {
            String content = txtNivel6Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel6Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel7() {
        try {
            String content = txtNivel7Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel7Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel8() {
        try {
            String content = txtNivel8Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel8Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel9() {
        try {
            String content = txtNivel9Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel9Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }

    private void GuardarNivel10() {
        try {
            String content = txtNivel10Completado.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\Nivel10Completado.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }
    
    private void GuardarFantasmas() {
        try {
            String content = txtCantFantasmas.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\FantasmasComidos.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición de Nivel");
            alert.setContentText("Error al editar el nivel");
            alert.showAndWait();
        }
    }
    
    private void GuardarVidas() {
        try {
            String content = txtCantVidas.getText();
            File f1 = new File(".");
            String dir1 = f1.getAbsolutePath();
            String path = dir1 + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
            Files.write(Paths.get(path), content.getBytes());
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edición Juegos Consecutivos");
            alert.setContentText("Error al editar los juegos consecutivos");
            alert.showAndWait();
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        try {
            GuardarPuntosTotales();
            GuardarNivel9();
            GuardarNivel8();
            GuardarNivel7();
            GuardarNivel6();
            GuardarNivel5();
            GuardarNivel4();
            GuardarNivel3();
            GuardarNivel2();
            GuardarNivel10();
            GuardarNivel1();
            GuardarMayorCantPartida();
            GuardarFantasmas();
            GuardarEncierroCantidad();
            GuardarVidas();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Edición de Juego");
            alert.setContentText("Configuraciones guardadas existosamente");
            alert.showAndWait();
        } catch (Exception e) {

        }
    }

    @FXML
    private void SeleccionDificultad(ActionEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Dificultad", this.getStage());
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

}
