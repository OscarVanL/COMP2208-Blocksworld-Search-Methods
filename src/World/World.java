package World;

import java.util.List;

/**
 * @author Oscar van Leusen
 */
public class World {
    public enum direction {
        Left,
        Right,
        Up,
        Down
    }
    private int gridSize;
    private Object[][] grid;

    List<Block> blocks;
    Block blockA;
    Block blockB;
    Block blockC;
    Agent agent;


    public World(int n) {
        this.gridSize = n;
        initialiseGrid();
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
        blocks.add(blockA);
        blocks.add(blockB);
        blocks.add(blockC);
    }

    public boolean inGoalState() {
        return (grid[1][2] == blockA && grid[1][1] == blockB && grid[1][0] == blockC);
    }

    public boolean moveAgent(direction d) {
        if (d == direction.Left) {
            return moveLeft();
        } else if (d == direction.Right) {
            return moveRight();
        } else if (d == direction.Up) {
            return moveUp();
        } else if (d == direction.Down) {
            return moveDown();
        }
        return false;
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

    public void checkAboveAndBelow(List<Block> blocks) {
        for (Block block : blocks) {
            checkAboveAndBelow(block);
        }
    }

    public void checkAboveAndBelow(Block block) {
        if (block.getY() + 1 <= gridSize) {
            if (grid[block.getX()][block.getY()+1] instanceof Block) {
                block.setBelow((Block) grid[block.getX()][block.getY() +1]);
            } else {
                block.setBelow(null);
            }
        }

        if (block.getY() - 1 <= 0) {
            if (grid[block.getX()][block.getY()-1] instanceof Block) {
                block.setOntopOf((Block) grid[block.getX()][block.getY()-1]);
            } else {
                block.setOntopOf(null);
            }
        }
    }

    public int getGridSize() {
        return this.gridSize;
    }
}
