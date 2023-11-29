/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import SpriteClasses.Animation;
import SpriteClasses.Tank;
import SpriteClasses.TankAI;
import SpriteClasses.TankShield;
import java.util.ArrayList;

/**
 *
 * @author andy2
 */
public class Casco implements IEstrategia{
    @Override
    public void agregarComodin(Tank tank, ArrayList<TankAI> enemies, ArrayList<Animation> animations) {
        tank.shield = true;
        animations.add(new TankShield(tank, 1));
    }
}
