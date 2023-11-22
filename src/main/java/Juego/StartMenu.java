/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * Class for the main menu of the game
 *
 * @author Esteban
 */
public class StartMenu extends JPanel implements ActionListener, KeyListener  {
    public Viewer gameView;
    
    public Image background;
    public Image tank;
    public Image tree;
    
    private int yPos = Map.BOARD_HEIGHT;
    private int direction = -1;
    private final int stopYPos = 100;
    private static boolean menuStatus = true;
    private final ImageManager imageManagerInstance = ImageManager.getInstance();
    
    
    
    /**
     * Constructor
     * @param gameView 
     */
    public StartMenu (Viewer gameView) {
        this.gameView = gameView;
        this.setBackground(Color.BLACK);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
        loadMenuImages();
        addTimer();
        
    }
    
    private void addTimer() {
        Timer timer = new Timer (10, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               yPos += direction;
               if (yPos == stopYPos) {
                   direction = 0;
               } else if (yPos + background.getHeight(null) > getHeight()) {
                   yPos = getHeight() - background.getHeight(null);
               } else if (yPos < 0) {
                   yPos = 0;
                   direction *= 1;
               }
               repaint();
           }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }
    
    private void loadMenuImages() {
        this.background = this.imageManagerInstance.getBackground();
        this.tank = imageManagerInstance.getTanque();
        this.tree = imageManagerInstance.getTreeAlt();
        
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Font fuente = loadFont();
        g.drawImage(this.background, Map.BOARD_WIDTH / 2 - background.getWidth(null) / 2 - 10, yPos, this);
        g.setFont(fuente);
        g.setColor(Color.WHITE);
        g.drawString("Gooo!", Map.BOARD_WIDTH / 2 - 56, yPos + background.getHeight(null) + 50);
        if (yPos == stopYPos) {
            drawMenu(g);
        }
    }
    
    private void drawMenu(Graphics g) {
        g.drawImage(tank, Map.BOARD_WIDTH / 2 - 90, yPos + background.getHeight(null) + 25, this);
        Font fuente = loadFont();
        g.setFont(fuente);
        g.setColor(Color.WHITE);
        g.drawString("Sin Miedo al Exito",
                     Map.BOARD_WIDTH / 2 - 80,
                     Map.BOARD_HEIGHT * 4 / 5 + 25);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
    }
    
    public static Font loadFont() {
        Font fuente = null;
        try {
            fuente = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                                            new File("prstart.ttf"));
            fuente = fuente.deriveFont(java.awt.Font.PLAIN, 15);
            GraphicsEnvironment ge
                                = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fuente;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            menuStatus = false;
            gameView.getPnlGame().removeAll();
            GameBoard panel = new GameBoard(gameView);
            
        }
    }
    
    
    
}
