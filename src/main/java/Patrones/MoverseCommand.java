/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import SpriteClasses.Tank;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author andy2
 */
public class MoverseCommand implements Command{
    
    private Tank tanque;

    public MoverseCommand(Tank tank) {
        this.tanque = tank;
    }
    
    @Override
    public void execute(KeyEvent e) {
        tanque.move();
        int key = e.getKeyCode();
        ImageIcon ii;
        switch (key) {
            case KeyEvent.VK_A:
                ii = new ImageIcon("image/playerTank_left.png");
                tanque.setImage(ii.getImage());
                tanque.setDirection(3);
                tanque.setDx(-1);
                tanque.setDy(0);
                break;
            case KeyEvent.VK_D:
                ii = new ImageIcon("image/playerTank_right.png");
                tanque.setImage(ii.getImage());
                tanque.setDirection(1);
                tanque.setDx(1);
                tanque.setDy(0);
                break;
            case KeyEvent.VK_W:
                ii = new ImageIcon("image/playerTank_up.png");
                tanque.setImage(ii.getImage());
                tanque.setDirection(0);
                tanque.setDx(0);
                tanque.setDy(-1);
                break;
            case KeyEvent.VK_S:
                ii = new ImageIcon("image/playerTank_down.png");
                tanque.setImage(ii.getImage());
                tanque.setDirection(2);
                tanque.setDx(0);
                tanque.setDy(1);
                break;
        }
    }
    
}
