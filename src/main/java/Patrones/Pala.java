/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import Juego.BoardUtility;
import SpriteClasses.Animation;
import SpriteClasses.Block;
import SpriteClasses.Steel;
import SpriteClasses.Tank;
import SpriteClasses.TankAI;
import java.util.ArrayList;

/**
 *
 * @author andy2
 */
public class Pala implements IEstrategia{
    @Override
    public void agregarComodin(Tank tank, ArrayList<TankAI> enemies, ArrayList<Animation> animations) {
        ArrayList<Block> blocks = BoardUtility.getBlocks();
        blocks.add(new Steel(13 * 16, 24 * 16));
        blocks.add(new Steel(13 * 16, 25 * 16));
        blocks.add(new Steel(13 * 16, 26 * 16));

        blocks.add(new Steel(14 * 16, 24 * 16));
        blocks.add(new Steel(15 * 16, 24 * 16));

        blocks.add(new Steel(16 * 16, 24 * 16));
        blocks.add(new Steel(16 * 16, 25 * 16));
        blocks.add(new Steel(16 * 16, 26 * 16));
    }
}
