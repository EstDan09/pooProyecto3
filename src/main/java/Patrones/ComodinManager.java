/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import SpriteClasses.Animation;
import SpriteClasses.Tank;
import SpriteClasses.TankAI;
import java.util.ArrayList;

/**
 *
 * @author andy2
 */
public class ComodinManager {
    private IEstrategia estrategia;

    public void setEstrategia(IEstrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void aplicarPowerUp(Tank tank, ArrayList<TankAI> enemies, ArrayList<Animation> animations) {
        if (estrategia != null) {
            estrategia.agregarComodin(tank, enemies, animations);
        }
    }
}
