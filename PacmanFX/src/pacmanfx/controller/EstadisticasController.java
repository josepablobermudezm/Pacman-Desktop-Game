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
import static pacmanfx.controller.MenuController.PuntosTotales;
import static pacmanfx.controller.MenuController.TiempoTotalJuego;
import static pacmanfx.controller.MenuController.VidasConsecutivas;
import pacmanfx.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Jose Pablo Bermudez
 */
public class EstadisticasController extends Controller implements Initializable {

    @FXML
    private ImageView omg;
    @FXML
    private Label lblVolver;
    @FXML
    private Label lblTotalPuntos;
    @FXML
    private Label lblPuntosPartida;
    @FXML
    private Label lblPuntosPartidaVida;
    @FXML
    private Label lblVidasPerdidas;
    @FXML
    private Label lblNivel1;
    @FXML
    private Label lblNivel2;
    @FXML
    private Label lblNivel3;
    @FXML
    private Label lblNivel4;
    @FXML
    private Label lblNivel5;
    @FXML
    private Label lblNivel6;
    @FXML
    private Label lblNivel7;
    @FXML
    private Label lblNivel8;
    @FXML
    private Label lblNivel9;
    @FXML
    private Label lblNivel10;
    @FXML
    private Label lblTiempo1;
    @FXML
    private Label lblTiempo2;
    @FXML
    private Label lblTiempo3;
    @FXML
    private Label lblTiempo4;
    @FXML
    private Label lblTiempo5;
    @FXML
    private Label lblTiempo6;
    @FXML
    private Label lblTiempo7;
    @FXML
    private Label lblTiempo8;
    @FXML
    private Label lblTiempo9;
    @FXML
    private Label lblTiempo10;
    @FXML
    private Label lblFantasmasComidos;
    @FXML
    private Label lblTiempoTotalJuego;
    static public boolean estadisticas = false;
    int txtPuntosTotales = 0, txtTiempoTotal = 0, aux1 = 0, ContNivel1 = 0, ContNivel2 = 0, ContNivel3 = 0, ContNivel4 = 0, ContNivel5 = 0, ContNivel6 = 0, ContNivel7 = 0,
            ContNivel8 = 0, ContNivel9 = 0, ContNivel10 = 0;
    int tiempo1 = 0, tiempo2 = 0, tiempo3 = 0, tiempo4 = 0, tiempo5 = 0, tiempo6 = 0, tiempo7 = 0, tiempo8 = 0, tiempo9 = 0, tiempo10 = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadisticas = true;
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
        /*
            Puntos totales en toda la historia
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
                txtPuntosTotales = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
            tiempo total gastado en el juego
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
                txtTiempoTotal = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\MayorCantidadDePuntosPartida.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                aux1 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
            Lee los archivos de la cantidad de partidas jugadas por nivel
         */
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas1.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel1 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas2.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel2 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas3.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel3 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas4.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel4 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas5.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel5 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas6.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel6 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas7.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel7 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas8.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel8 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas9.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel9 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Partidas10.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ContNivel10 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
            lee los archivos de los mejores tiempos por nivel
         */
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo1.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo1 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo2.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo2 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo3.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo3 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo4.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo4 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo5.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo5 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo6.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo6 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo7.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo7 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo8.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo8 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo9.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo9 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\Mejor_Tiempo10.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                tiempo10 = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
            Juegos sin perder Vidas consecutivas
        */
        int vidas = 0;
        try {
            File f = new File(".");
            String dir = f.getAbsolutePath();
            String fileName = dir + "\\src\\pacmanfx\\resources\\NoPerderVidasCont.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                vidas = Integer.parseInt(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JugadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (vidas >= 3) {
            try {
                String content = "1";
                File f1 = new File(".");
                String dir1 = f1.getAbsolutePath();
                String path = dir1 + "\\src\\pacmanfx\\resources\\NoPerderVidas.txt";
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
        //setea los mejores tiempos para cada nivel
        lblTiempo1.setText(String.valueOf(String.valueOf(tiempo1 / 60) + ":" + String.valueOf((tiempo1 % 60 >= 10) ? tiempo1 % 60 : "0" + tiempo1 % 60)));
        lblTiempo2.setText(String.valueOf(String.valueOf(tiempo2 / 60) + ":" + String.valueOf((tiempo2 % 60 >= 10) ? tiempo2 % 60 : "0" + tiempo2 % 60)));
        lblTiempo3.setText(String.valueOf(String.valueOf(tiempo3 / 60) + ":" + String.valueOf((tiempo3 % 60 >= 10) ? tiempo3 % 60 : "0" + tiempo3 % 60)));
        lblTiempo4.setText(String.valueOf(tiempo4 / 60) + ":" + String.valueOf((tiempo4 % 60 >= 10) ? tiempo4 % 60 : "0" + tiempo4 % 60));
        lblTiempo5.setText(String.valueOf(tiempo5 / 60) + ":" + String.valueOf((tiempo5 % 60 >= 10) ? tiempo5 % 60 : "0" + tiempo5 % 60));
        lblTiempo6.setText(String.valueOf(tiempo6 / 60) + ":" + String.valueOf((tiempo6 % 60 >= 10) ? tiempo6 % 60 : "0" + tiempo6 % 60));
        lblTiempo7.setText(String.valueOf(tiempo7 / 60) + ":" + String.valueOf((tiempo7 % 60 >= 10) ? tiempo7 % 60 : "0" + tiempo7 % 60));
        lblTiempo8.setText(String.valueOf(tiempo8 / 60) + ":" + String.valueOf((tiempo8 % 60 >= 10) ? tiempo8 % 60 : "0" + tiempo8 % 60));
        lblTiempo9.setText(String.valueOf(tiempo9 / 60) + ":" + String.valueOf((tiempo9 % 60 >= 10) ? tiempo9 % 60 : "0" + tiempo9 % 60));
        lblTiempo10.setText(String.valueOf(tiempo10 / 60) + ":" + String.valueOf((tiempo10 % 60 >= 10) ? tiempo10 % 60 : "0" + tiempo10 % 60));
        //setea las cantidades de partidas que tiene cada nivel
        lblNivel1.setText(String.valueOf(ContNivel1));
        lblNivel2.setText(String.valueOf(ContNivel2));
        lblNivel3.setText(String.valueOf(ContNivel3));
        lblNivel4.setText(String.valueOf(ContNivel4));
        lblNivel5.setText(String.valueOf(ContNivel5));
        lblNivel6.setText(String.valueOf(ContNivel6));
        lblNivel7.setText(String.valueOf(ContNivel7));
        lblNivel8.setText(String.valueOf(ContNivel8));
        lblNivel9.setText(String.valueOf(ContNivel9));
        lblNivel10.setText(String.valueOf(ContNivel10));
        //mayor cantidad de puntos ganados en una partida
        lblPuntosPartida.setText(String.valueOf(aux1 * 10));
        /*
            aquí lo que hago es mostrar el valor de que tenga la variable static que es lo que se va a haber generado hasta el momento en el nivel
            y después a esa variable le sumo el dato obtenido desde el txt
         */
        //setea los puntos que se han comido en toda la historia
        lblTotalPuntos.setText(String.valueOf(PuntosTotales + txtPuntosTotales));//variable PuntosTotales es una variable estatica de Menu
        //setea el tiempo total de juego
        lblTiempoTotalJuego.setText(String.valueOf(
                (TiempoTotalJuego + txtTiempoTotal) / 60 + ":" + String.valueOf(((TiempoTotalJuego + txtTiempoTotal) % 60 >= 10) ? (TiempoTotalJuego + txtTiempoTotal) % 60 : "0" + ((TiempoTotalJuego + txtTiempoTotal) % 60))));//variable TiempoTotalJuego es una variable estatica de Menu
        //setea la mayor cantidad de puntos que se hayan obtenido en los niveles
    }

    @Override
    public void initialize() {
        omg.setImage(new Image("/pacmanfx/resources/fondo8.jpg"));
    }

    @FXML
    private void Volver(MouseEvent event) {
        FlowController.getInstance().initialize();
        FlowController.getInstance().goViewInStage("Jugador", this.getStage());
    }

}
