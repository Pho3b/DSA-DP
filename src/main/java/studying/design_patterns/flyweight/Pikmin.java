package studying.design_patterns.flyweight;

/**
 * In the main Pikmin class we initialize all the INTRINSIC properties of the object
 */
public class Pikmin {
    PikminType type;
    int x, y;


    /**
     * Default constructor
     *
     * @param x    int
     * @param y    int
     * @param type PikminType
     */
    Pikmin(int x, int y, PikminType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public PikminType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
