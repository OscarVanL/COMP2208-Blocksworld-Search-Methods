package World;

/**
 * @author Oscar van Leusen
 */
public class Block {
    public enum type {
        A,
        B,
        C
    }

    private type blockType;
    private Block isOntop;
    private Block isBelow;
    private BlocksWorld world;
    private int x;
    private int y;

    public Block(type t, int x, int y, BlocksWorld world) {
        this.blockType = t;
        isOntop = null;
        isBelow = null;
        this.world = world;
        this.x = x;
        this.y = y;
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

    public void setOntopOf(Block block) {
        this.isOntop = block;
    }

    public void setBelow(Block block) {
        this.isBelow = block;
    }

    public type getType() {
        return this.blockType;
    }

}
