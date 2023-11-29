/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import SpriteClasses.Tank;
import java.awt.event.KeyEvent;

/**
 *
 * @author andy2
 */
public class DispararCommand implements Command{
     private Tank tanque;

    public DispararCommand(Tank tank) {
        this.tanque = tank;
    }

    @Override
    public void execute(KeyEvent e) {
        int time;
        int key = e.getKeyCode();
        if (tanque.getStarLevel() == 0) {
            time = 700;
        } else {
            time = 250;
        }
        if (key == KeyEvent.VK_SPACE && (System.currentTimeMillis() - tanque.getLastFired()) > time) {
            tanque.fire();
            tanque.setLastFired(System.currentTimeMillis());
        }
    }
}
