package SpriteClasses.PowerUps;

/**
 * ShovelPowerUp extends PowerUp and sets the type at 11
 *
 * @param int x represents the starting x location in pixels
 * @param int y represents the starting y location in pixels
 * @author Esteban
 */
public class ShovelPowerUp extends PowerUp {
    public ShovelPowerUp(int x, int y) {
        super(x, y);
        loadImage("image/powerup_shovel.png");
        getImageDimensions();
        setType(11);
        s = "image/powerup_shovel.png";
    }

}
