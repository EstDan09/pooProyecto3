/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import javax.swing.UIManager;

/**
 *
 * @author Esteban
 */
public class Main {
    
    public static void main () throws Exception {
        
        java.awt.EventQueue.invokeLater(new Runnable () {
            public void run () {
                Viewer gameView = new Viewer();
                StartMenu menu = new StartMenu(gameView);
                gameView.getPnlGame().add(menu);
                gameView.setVisibile(true);
                
            }
        
        
        }
        
        );
        
    }
    
}
