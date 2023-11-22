package SpriteClasses;

/**
 * Steel is a Block with type 2 and health 1
 *
 * @param int x represents the starting x location in pixels
 * @param int y represents the starting y location in pixels
 * @author Esteban
 */
public class Steel extends Block {

    public Steel(int x, int y) {
        super(x, y);
        loadImage("image/wall_steel.png");
        getImageDimensions();
        setHealth(1);
        setType(2);
    }

}
