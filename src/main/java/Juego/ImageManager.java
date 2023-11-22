/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * Clase que carga todas las imagenes
 *
 * @author Esteban
 */
public class ImageManager {
    
    private final Image livesIcono;
    private final Image flagIcono;
    private final Image enemigoIcono;
    
    private final Image flecha;
    private final Image tanqueBasico;
    private final Image tanqueRapido;
    private final Image tanquePoder;
    private final Image tanqueArmadura;
    
    private final Image background;
    private final Image tanque;
    private final Image treeAlt;
    
    private static ImageManager instance;
    
    
    public static ImageManager getInstance() {
        if (instance == null) {
            return new ImageManager();
        }
        return instance;
    }
    
    
    private ImageManager() {
        this.livesIcono = loadImage("imagenes/lives.png");
        this.flagIcono = loadImage("imagenes/flag.png");
        this.enemigoIcono = loadImage("imagenes/enemy.png");
        this.flecha = loadImage("imagenes/arrow.png");
        this.tanqueBasico = loadImage("imagenes/tank_basic.png");
        this.tanqueRapido = loadImage("image/tank_fast.png");
        this.tanquePoder = loadImage("image/tank_power.png");
        this.tanqueArmadura = loadImage("image/tank_armor.png");
        this.background = loadImage("image/battle_city.png");
        this.tanque = loadImage("image/playerTank_right.png");
        this.treeAlt = loadImage("image/trees2.png");
    }
    
    /**
     * Cargo una imegen usando una url de path
     * 
     * @param urlImagen que es la dirección de la imagen que quiero
     * @return la iamgen
     */
    public Image loadImage (String urlImagen) {
        ImageIcon icono = new ImageIcon(urlImagen);
        return icono.getImage();
    }

    
    
    /**
     * Getters
     * @return 
     */
    
    public Image getLivesIcono() {
        return livesIcono;
    }

    public Image getFlagIcono() {
        return flagIcono;
    }

    public Image getEnemigoIcono() {
        return enemigoIcono;
    }

    public Image getFlecha() {
        return flecha;
    }

    public Image getTanqueBasico() {
        return tanqueBasico;
    }

    public Image getTanqueRapido() {
        return tanqueRapido;
    }

    public Image getTanquePoder() {
        return tanquePoder;
    }

    public Image getTanqueArmadura() {
        return tanqueArmadura;
    }

    public Image getBackground() {
        return background;
    }

    public Image getTanque() {
        return tanque;
    }

    public Image getTreeAlt() {
        return treeAlt;
    }
    
}
