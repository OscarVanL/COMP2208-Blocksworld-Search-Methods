package World;

/**
 * @author Oscar van Leusen
 */
public class Agent {
    private int x;
    private int y;
    private World world;

    public Agent(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean canMoveUp() {
        //If we're not yet at the boundary of the grid
        if (y+1 < world.getGridSize()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canMoveDown() {
        //If we're not yet at the boundary of the grid
        if (y > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canMoveLeft() {
        //If we're not yet at the boundary of the grid
        if (x > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canMoveRight() {
        //If we're not yet at the boundary of the grid
        if (x+1 < world.getGridSize()) {
            return true;
        } else {
            return false;
        }
    }
}
