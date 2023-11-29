/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import Juego.Board;
import Juego.CollisionUtility;
import SpriteClasses.Animation;
import SpriteClasses.ExplodingTank;
import SpriteClasses.Tank;
import SpriteClasses.TankAI;
import java.util.ArrayList;

/**
 *
 * @author andy2
 */
public class Bomba implements IEstrategia{
    @Override
    public void agregarComodin(Tank tank, ArrayList<TankAI> enemies, ArrayList<Animation> animations) {
        for (int x = 0; x < enemies.size(); x++) {
            enemies.get(x).vis = false;
            for (TankAI ai : enemies) {
                CollisionUtility.incrementNum(ai);
            }
            Board.decrementEnemies(enemies.size());
            animations.add(new ExplodingTank(enemies.get(x).x, enemies.get(x).y));
        }
    }
}
