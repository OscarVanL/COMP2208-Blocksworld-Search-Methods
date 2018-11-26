package World;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oscar van Leusen
 */
public class BlocksWorld {

    private int gridSize;
    private Object[][] grid;
    private List<Block> blocks;
    private Block blockA;
    private Block blockB;
    private Block blockC;
    private Agent agent;


    public BlocksWorld(int n) {
        this.gridSize = n;
        initialiseGrid();
    }

    /**
     * Clones an existing BlocksWorld so references between objects are removed.
     * @param copy
     */
    public BlocksWorld (BlocksWorld copy) {
        this.gridSize = copy.gridSize;
        this.grid = new Object[gridSize][gridSize];
        blockA = new Block(copy.blockA.getType(), copy.blockA.getX(), copy.blockA.getY(), this);
        grid[copy.blockA.getX()][copy.blockA.getY()] = blockA;
        blockB = new Block(copy.blockB.getType(), copy.blockB.getX(), copy.blockB.getY(), this);
        grid[copy.blockB.getX()][copy.blockB.getY()] = blockB;
        blockC = new Block(copy.blockC.getType(), copy.blockC.getX(), copy.blockC.getY(), this);
        grid[copy.blockC.getX()][copy.blockC.getY()] = blockC;
        agent = new Agent(copy.agent.getX(), copy.agent.getY(), this);
        grid[copy.agent.getX()][copy.agent.getY()] = agent;
        blocks = new ArrayList<>();
        blocks.add(blockA);
        blocks.add(blockB);
        blocks.add(blockC);
    }


    /**
     * If we've got another BlocksWorld state we want to 'restore' to
     * (Eg: If we go down a path on a search and this was incorrect, we may want to backtrack to how it was before.)
     * @param w : World to restore to.
     */
    public void restoreBlocksWorld(BlocksWorld w) {
        this.grid = w.grid;
        this.blocks = w.blocks;
        this.blockA = w.blockA;
        this.blockB = w.blockB;
        this.blockC = w.blockC;
        this.agent = w.agent;
    }


    /**
     * Initialises the grid to size n, as this is an Object array everything is initialised to null.
     * Then fills the Start states for blocks and the agent.
     */
    private void initialiseGrid() {
        if (gridSize<4)
            System.out.println("Grid size is too small.");
        grid = new Object[gridSize][gridSize];
        blockA = new Block(Block.type.A, 0, 0, this);
        grid[0][0] = blockA;
        blockB = new Block(Block.type.B, 1, 0, this);
        grid[1][0] = blockB;
        blockC = new Block(Block.type.C, 2, 0, this);
        grid[2][0] = blockC;
        agent = new Agent(3, 0, this);
        grid[3][0] = agent;
        blocks = new ArrayList<>();
        blocks.add(blockA);
        blocks.add(blockB);
        blocks.add(blockC);
    }


    public boolean inGoalState() {
        return (grid[1][2] == blockA && grid[1][1] == blockB && grid[1][0] == blockC);
    }

    public void moveAgent(Direction d) {
        if (d == Direction.Left) {
            moveLeft();
        } else if (d == Direction.Right) {
            moveRight();
        } else if (d == Direction.Up) {
            moveUp();
        } else if (d == Direction.Down) {
            moveDown();
        }
    }

    private boolean moveLeft() {
        if (agent.canMoveLeft()) {
            //If the place the agent is moving to is already occupied by a block, swap the block and agent
            if (grid[agent.getX()-1][agent.getY()] instanceof Block) {
                Block swappingWith = (Block) grid[agent.getX()-1][agent.getY()];
                grid[agent.getX()][agent.getY()] = swappingWith;
                swappingWith.setCoords(agent.getX(), agent.getY());
                grid[agent.getX()-1][agent.getY()] = agent;
                agent.setCoords(agent.getX()-1, agent.getY());
                checkAboveAndBelow(blocks);
            } else {
                //If the agent is moving to an empty tile, then simply set the tile it's coming from to null.
                grid[agent.getX()][agent.getY()] = null;
                grid[agent.getX()-1][agent.getY()] = agent;
                agent.setCoords(agent.getX()-1, agent.getY());
            }
            return true;
        }
        return false;
    }

    private boolean moveRight() {
        if (agent.canMoveRight()) {
            if (grid[agent.getX()+1][agent.getY()] instanceof Block) {
                Block swappingWith = (Block) grid[agent.getX()+1][agent.getY()];
                grid[agent.getX()][agent.getY()] = swappingWith;
                swappingWith.setCoords(agent.getX(), agent.getY());
                grid[agent.getX()+1][agent.getY()] = agent;
                agent.setCoords(agent.getX()+1, agent.getY());
                checkAboveAndBelow(blocks);
            } else {
                grid[agent.getX()][agent.getY()] = null;
                grid[agent.getX()+1][agent.getY()] = agent;
                agent.setCoords(agent.getX()+1, agent.getY());
            }
            return true;
        }
        return false;
    }

    private boolean moveUp() {
        if (agent.canMoveUp()) {
            if (grid[agent.getX()][agent.getY()+1] instanceof Block ) {
                Block swappingWith = (Block) grid[agent.getX()][agent.getY()+1];
                grid[agent.getX()][agent.getY()] = swappingWith;
                swappingWith.setCoords(agent.getX(), agent.getY());
                grid[agent.getX()][agent.getY()+1] = agent;
                agent.setCoords(agent.getX(), agent.getY()+1);
                checkAboveAndBelow(blocks);
            } else {
                grid[agent.getX()][agent.getY()] = null;
                grid[agent.getX()][agent.getY()+1] = agent;
                agent.setCoords(agent.getX(), agent.getY()+1);
            }
            return true;
        }
        return false;
    }

    private boolean moveDown() {
        if (agent.canMoveDown()) {
            if (grid[agent.getX()][agent.getY()-1] instanceof Block) {
                Block swappingWith = (Block) grid[agent.getX()][agent.getY()-1];
                grid[agent.getX()][agent.getY()] = swappingWith;
                swappingWith.setCoords(agent.getX(), agent.getY());
                grid[agent.getX()][agent.getY()-1] = agent;
                agent.setCoords(agent.getX(), agent.getY()-1);
                checkAboveAndBelow(blocks);
            } else {
                grid[agent.getX()][agent.getY()] = null;
                grid[agent.getX()][agent.getY()-1] = agent;
                agent.setCoords(agent.getX(), agent.getY()-1);
            }
            return true;
        }
        return false;
    }

    public boolean canMove(Direction d) {
        if (agent.canMove(d)) {
            return true;
        } else {
            return false;
        }
    }

    public void checkAboveAndBelow(List<Block> blocks) {
        for (Block block : blocks) {
            checkAboveAndBelow(block);
        }
    }

    public void checkAboveAndBelow(Block block) {
        if (block.getY() + 1 < gridSize) {
            if (grid[block.getX()][block.getY()+1] instanceof Block) {
                block.setBelow((Block) grid[block.getX()][block.getY() +1]);
            } else {
                block.setBelow(null);
            }
        }

        if (block.getY() - 1 >= 0) {
            if (grid[block.getX()][block.getY()-1] instanceof Block) {
                block.setOntopOf((Block) grid[block.getX()][block.getY()-1]);
            } else {
                block.setOntopOf(null);
            }
        }
    }

    public Object getContentsAt(int x, int y) {
        return grid[x][y];
    }

    public int getGridSize() {
        return this.gridSize;
    }
}
