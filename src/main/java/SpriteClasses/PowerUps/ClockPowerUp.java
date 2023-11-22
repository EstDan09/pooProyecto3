package SpriteClasses.PowerUps;

/**
 * ClockPowerUp extends PowerUp and sets the type as 10
 *
 * @param int x represents the starting x location in pixels
 * @param int y represents the starting y location in pixels
 * @author Esteban
 */
public class ClockPowerUp extends PowerUp {
    public ClockPowerUp(int x, int y) {
        super(x, y);
        loadImage("image/powerup_timer.png");
        getImageDimensions();
        setType(10);
        s = "image/powerup_timer.png";
    }

}
