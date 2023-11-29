package Juego;

import Patrones.Bomba;
import Patrones.Casco;
import Patrones.ComodinManager;
import Patrones.Estrella;
import Patrones.IEstrategia;
import Patrones.Pala;
import Patrones.Reloj;
import Patrones.Tanque;
import SpriteClasses.Animation;
import SpriteClasses.Block;
import SpriteClasses.Bullet;
import SpriteClasses.ExplodingTank;
import SpriteClasses.PowerUps.BombPowerUp;
import SpriteClasses.PowerUps.ClockPowerUp;
import SpriteClasses.PowerUps.PowerUp;
import SpriteClasses.PowerUps.ShieldPowerUp;
import SpriteClasses.PowerUps.ShovelPowerUp;
import SpriteClasses.PowerUps.StarPowerUp;
import SpriteClasses.PowerUps.TankPowerUp;
import SpriteClasses.Tank;
import SpriteClasses.TankAI;
import SpriteClasses.TankShield;
import SpriteClasses.TankSpawn;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 * A utility class for the board
 *
 * @author Esteban
 */
public class BoardUtility {

    private static ArrayList<TankAI> enemy = new ArrayList<>();
    private static ArrayList<Block> blocks = new ArrayList<>();
    private static ArrayList<Animation> animations = new ArrayList<>();
    private static ArrayList<PowerUp> powerUps = new ArrayList<>();
    private static Tank tank;

    /**
     * Constructor for the BoardUtility class
     *
     * @param enemy1 an array list that stores enemy tanks
     * @param blocks1 an array list that stores blocks on the board
     * @param animations1 an array list that stores different animations
     * @param powerUps1 an array list that stores different power-ups
     * @param tank1 the Tank class that represents the player
     */
    public static void loadBoardUtility(ArrayList<TankAI> enemy1,
                                        ArrayList<Block> blocks1,
                                        ArrayList<Animation> animations1,
                                        ArrayList<PowerUp> powerUps1, Tank tank1) {
        enemy = enemy1;
        blocks = blocks1;
        animations = animations1;
        powerUps = powerUps1;
        tank = tank1;
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    /**
     * Update power ups on the board.
     */
    // strategy
    public static void updatePowerUps() {
        for (int i = 0; i < powerUps.size(); i++) {
            PowerUp p = powerUps.get(i);
            p.updateAnimation();
            BlockType type = BlockType.getTypeFromInt(p.getType());
            Rectangle r1 = tank.getBounds();
            Rectangle r2 = p.getBounds();

            if (System.currentTimeMillis() - p.getLoadTime() > 10000) {
                powerUps.remove(i);
            }

            if (r1.intersects(r2)) {
                powerUps.remove(i);
                SoundUtility.powerupPick();
                IEstrategia estrategia = null;
                if (type.equals(BlockType.TANK)) {
                    estrategia = new Tanque();
                    
                } else if (type.equals(BlockType.SHIELD)) {
                    estrategia = new Casco();
                    
                } else if (type.equals(BlockType.SHOVEL)) {
                    estrategia = new Pala();
                    
                } else if (type.equals(BlockType.STAR)) {
                    estrategia = new Estrella();
                    
                } else if (type.equals(BlockType.CLOCK)) {
                    estrategia = new Reloj();
                    
                } else if (type.equals(BlockType.BOMB)) {
                    estrategia = new Bomba();
                }
                ComodinManager powerUPManager = new ComodinManager();
                powerUPManager.setEstrategia(estrategia);
                powerUPManager.aplicarPowerUp(tank, enemy, animations);
            }
        }

    }

    /**
     * Spawn random PowerUp when the given tank AI carries powerUp and is
     * destroyed.
     */
    public static void spawnPowerUp() {
        Random random = new Random();
        int randomPow = random.nextInt(6);
        if (CollisionUtility.powerUpX != 0 || CollisionUtility.powerUpY != 0) {
            switch (randomPow) {
                case 0:
                    powerUps.add(new BombPowerUp(CollisionUtility.powerUpX,
                                                 CollisionUtility.powerUpY));
                    break;
                case 1:
                    powerUps.add(new ClockPowerUp(CollisionUtility.powerUpX,
                                                  CollisionUtility.powerUpY));
                    break;
                case 2:
                    powerUps.add(new ShieldPowerUp(CollisionUtility.powerUpX,
                                                   CollisionUtility.powerUpY));
                    break;
                case 3:
                    powerUps.add(new StarPowerUp(CollisionUtility.powerUpX,
                                                 CollisionUtility.powerUpY));
                    break;
                case 4:
                    powerUps.add(new TankPowerUp(CollisionUtility.powerUpX,
                                                 CollisionUtility.powerUpY));
                    break;
                case 5:
                    powerUps.add(new ShovelPowerUp(CollisionUtility.powerUpX,
                                                 CollisionUtility.powerUpY));
                    break;
                default:
                    break;
            }
            CollisionUtility.powerUpX = 0;
            CollisionUtility.powerUpY = 0;
        }
    }

    /**
     * Spawn Tank AI on the board.
     *
     * @param difficulty a string that represents the difficulty of the tank AI
     * @param powerUp a boolean that represents if the tank AI carries powerUp
     */
    
    // Prototype
    public static void spawnTankAI(String difficulty, boolean powerUp) throws CloneNotSupportedException {
        Random random = new Random();
        int randomPos = random.nextInt(3);
        int randomType = random.nextInt(20);
        String type;
        if (randomType < 2) {
            type = "armor";
        } else if (randomType >= 2 && randomType < 7) {
            type = "power";
        } else if (randomType >= 8 && randomType < 13) {
            type = "fast";
        } else {
            type = "basic";
        }
        if (randomPos == 0) {
            animations.add(new TankSpawn(2 * 16, 1 * 16));
            TankAI prototypeAI = TankAI.getInstance(2 * 16, 1 * 16, difficulty, type, powerUp);
            TankAI clonedAI = prototypeAI.clone();
            clonedAI.setType(type);
            clonedAI.setDifficulty(difficulty);
            clonedAI.setPowerUp(powerUp);
            clonedAI.setX(2 * 16);
            clonedAI.setY(1 * 16); 
            clonedAI.setUp(clonedAI);
            clonedAI.imageSetUp(clonedAI);
            enemy.add(clonedAI);
        } else if (randomPos == 1) {
            animations.add(new TankSpawn(14 * 16, 1 * 16));
            TankAI prototypeAI = TankAI.getInstance(14 * 16, 1 * 16, difficulty, type, powerUp);
            TankAI clonedAI = prototypeAI.clone();
            clonedAI.setType(type);
            clonedAI.setDifficulty(difficulty);
            clonedAI.setPowerUp(powerUp);
            clonedAI.setX(14 * 16);
            clonedAI.setY(1 * 16); 
            clonedAI.setUp(clonedAI);
            clonedAI.imageSetUp(clonedAI);
            enemy.add(clonedAI);
        } else {
            animations.add(new TankSpawn(26 * 16, 1 * 16));
            TankAI prototypeAI = TankAI.getInstance(26 * 16, 1 * 16, difficulty, type, powerUp);
            TankAI clonedAI = prototypeAI.clone();
            clonedAI.setType(type);
            clonedAI.setDifficulty(difficulty);
            clonedAI.setPowerUp(powerUp);
            clonedAI.setX(26 * 16);
            clonedAI.setY(1 * 16);
            clonedAI.setUp(clonedAI);
            clonedAI.imageSetUp(clonedAI);
            enemy.add(clonedAI);
        }
    }

    /**
     * Update bullets and tank AI on the board.
     */
    public static void updateBulletsTankAI() {
        for (TankAI tankAI : enemy) {
            ArrayList<Bullet> bullets = tankAI.getBullets();
            for (int i = 0; i < bullets.size(); i++) {
                Bullet b = bullets.get(i);
                if (b.isVisible()) {
                    b.move();
                } else if (b.isVisible() == false) {
                    bullets.remove(i);
                }
            }
        }
    }

    /**
     * Update bullets and tank on the Board.
     */
    public static void updateBulletsTank() {
        ArrayList<Bullet> bullets = tank.getBullets();

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            if (b.isVisible()) {
                b.move();
            } else if (b.isVisible() == false) {
                bullets.remove(i);
            }
        }
    }

    /**
     * Update blocks on the Board.
     */
    public static void updateBlocks() {
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            BlockType type = BlockType.getTypeFromInt(b.getType());
            if (type.equals(BlockType.RIVER)) {
                b.updateAnimation();
            } else if (type.equals(BlockType.BASE)) {
                b.updateAnimation();
            }
            if (b.isVisible() == false) {
                blocks.remove(i);
            }
        }
    }

    /**
     * Update animations on the Board.
     */
    public static void updateAnimations() {
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i).vis == false) {
                animations.remove(i);
            } else {
                animations.get(i).updateAnimation();
            }
        }
    }

    /**
     * Update tank on the Board.
     */
    public static void updateTank() {
        if (tank.isVisible()) {
            tank.move();
        }
    }

    /**
     * Check for collisions on the board.
     */
    public static void checkCollisions() {
        ArrayList<Bullet> bullets = new ArrayList<>();
        bullets.addAll(tank.getBullets());
        for (TankAI tankAI : enemy) {
            bullets.addAll(tankAI.getBullets());
        }
        CollisionUtility.checkCollisionBulletsBlocks(bullets, blocks);
        CollisionUtility.checkCollisionBulletsTank(bullets, tank);
        CollisionUtility.checkCollisionBulletsTankAI(bullets, enemy);
        CollisionUtility.checkCollisionTankTankAI(enemy, tank);

    }

}
