/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanfx.util;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author JORDI RODRIGUEZ
 */
public class hiloTiempo {

    private Timer timer = new Timer();
    private int tic = 1;
    public static boolean finalizado = false;

    public hiloTiempo() {
       
    }

    public int getTic() {
        return tic;
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                /*switch (tic) {
                    case 1:
                        label.setText("Enviando Correos.");
                        tic++;
                        break;
                    case 2:
                        label.setText("Enviando Correos..");
                        tic++;
                        break;
                    case 3:
                        label.setText("Enviando Correos...");
                        tic = 1;
                        break;
                }*/
                tic++;
                if (finalizado) {
                    timer.cancel();
                    task.cancel();
                    finalizado = false;
                }
            });

        }
    };

    public void correrHilo() {
        timer.schedule(task, 10, 1000);
    }
}
