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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pacmanfx.model.CyanGhost;
import pacmanfx.model.OrangeGhost;
import pacmanfx.model.PinkGhost;
import pacmanfx.model.RedGhost;

/**
 *
 * @author JORDI RODRIGUEZ
 */
public class hiloTiempo {

    private Timer timer = new Timer();
    private int tic = 1;
    public static boolean finalizado = false;

    private Timer timer2 = new Timer();
    public int tic2 = 1;
    public static boolean finalizado2 = false;
    
    private RedGhost redGhost;
    private CyanGhost cyanGhost;
    private OrangeGhost orangeGhost;
    private PinkGhost pinkGhost;

    public hiloTiempo() {

    }

    public int getTic() {
        return tic;
    }

    public int getTic2() {
        return tic2;
    }

    public void setTic2(int tic2) {
        this.tic2 = tic2;
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                tic++;
                if (finalizado) {
                    timer.cancel();
                    task.cancel();
                    finalizado = false;
                }
            });

        }
    };

    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            if (tic2 == 8) {
                Platform.runLater(() -> {
                    timer2.cancel();
                    task2.cancel();
                    tic2 = 1;
                    redGhost.setImage(new Image("/pacmanfx/resources/red-ghost.png"));
                    cyanGhost.setImage(new Image("/pacmanfx/resources/blue-ghost.png"));
                    orangeGhost.setImage(new Image("/pacmanfx/resources/yellow-ghost.png"));
                    pinkGhost.setImage(new Image("/pacmanfx/resources/pink-ghost.png"));
                });
            }
            tic2++;
            
        }
    };

    public void correrHilo2() {
        timer2.schedule(task2, 10, 1000);
    }

    public void correrHilo() {
        timer.schedule(task, 10, 1000);
    }

    public void correrHilo(RedGhost redGhost, CyanGhost cyanGhost, OrangeGhost orangeGhost, PinkGhost pinkGhost) {
        this.redGhost = redGhost;
        this.cyanGhost = cyanGhost;
        this.pinkGhost = pinkGhost;
        this.orangeGhost = orangeGhost;
        redGhost.setImage(new Image("/pacmanfx/resources/blue-ghost-Eatable.png"));
        cyanGhost.setImage(new Image("/pacmanfx/resources/blue-ghost-Eatable.png"));
        orangeGhost.setImage(new Image("/pacmanfx/resources/blue-ghost-Eatable.png"));
        pinkGhost.setImage(new Image("/pacmanfx/resources/blue-ghost-Eatable.png"));
        timer2.schedule(task2, 10, 1000);
    }
}
