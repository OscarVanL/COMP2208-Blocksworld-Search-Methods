package World;

import java.util.ArrayList;
import java.util.List;

import static World.Block.*;

/**
 * @author Oscar van Leusen
 */
public class BlocksWorld {

    public static final int goalxOfA = 1;
    public static final int goalyOfA = 2;
    public static final int goalxOfB = 1;
    public static final int goalyOfB = 1;
    public static final int goalxOfC = 1;
    public static final int goalyOfC = 0;

    //Below are a list of initialisations of BlocksWorld that give varying length depth solutions. For example

    //Default, 14-Depth

    public static final int initxOfA = 0;
    public static final int inityOfA = 0;
    public static final int initxOfB = 1;
    public static final int inityOfB = 0;
    public static final int initxOfC = 2;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 3;
    public static final int inityOfAgent = 0;


    //1-Depth: L
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 2;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 1;
    public static final int inityOfAgent = 1;
    */


    //2-Depth: DL
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 1;
    public static final int inityOfAgent = 2;
    */

    //3-Depth: DDL
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 1;
    public static final int inityOfAgent = 3;
    */


    //4-Depth: DLDL
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 2;
    public static final int inityOfAgent = 3;
    */



    //5-Depth: LLDDL
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 3;
    public static final int inityOfAgent = 3;
    */


    //6-Depth: DLLURR
    /*
    public static final int initxOfA = 2;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 2;
    public static final int inityOfAgent = 2;
    */


    //7-Depth: DDLLURR
    /*
    public static final int initxOfA = 2;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 2;
    public static final int inityOfAgent = 3;
    */


    //8-Depth: DLDLLURR
    /*
    public static final int initxOfA = 2;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 1;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 3;
    public static final int inityOfAgent = 3;
    */


    //9-Depth: DRDLLURDR
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 0;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 1;
    public static final int inityOfAgent = 2;
    */


    //10-Depth: DRRDLLURDR
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 0;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 1;
    public static final int inityOfAgent = 3;
    */


    //11-Depth: DDDLLUURDDR
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 0;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 2;
    public static final int inityOfAgent = 3;
    */

    //12-Depth: DDDLLLUURDDR
    /*
    public static final int initxOfA = 1;
    public static final int inityOfA = 1;
    public static final int initxOfB = 0;
    public static final int inityOfB = 0;
    public static final int initxOfC = 1;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 3;
    public static final int inityOfAgent = 3;
    */


    //13-Depth: LLDLURDRUULDL
    /*
    public static final int initxOfA = 0;
    public static final int inityOfA = 0;
    public static final int initxOfB = 1;
    public static final int inityOfB = 0;
    public static final int initxOfC = 2;
    public static final int inityOfC = 0;
    public static final int initxOfAgent = 3;
    public static final int inityOfAgent = 1;
    */



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
     * Initialises the grid to size n, as this is an Object array everything is initialised to null.
     * Then fills the Start states for blocks and the agent.
     */
    private void initialiseGrid() {
        if (gridSize<4)
            System.out.println("Grid size is too small.");
        grid = new Object[gridSize][gridSize];
        blockA = new Block(type.A, initxOfA, inityOfA, this);
        grid[initxOfA][inityOfA] = blockA;
        blockB = new Block(type.B, initxOfB, inityOfB, this);
        grid[initxOfA][inityOfB] = blockB;
        blockC = new Block(type.C, initxOfC, inityOfC, this);
        grid[initxOfC][inityOfC] = blockC;
        agent = new Agent(initxOfAgent, inityOfAgent, this);
        grid[initxOfAgent][inityOfAgent] = agent;
        blocks = new ArrayList<>();
        blocks.add(blockA);
        blocks.add(blockB);
        blocks.add(blockC);
    }

    public boolean inGoalState() {
        return (grid[goalxOfA][goalyOfA] == blockA &&
                grid[goalxOfB][goalyOfB] == blockB &&
                grid[goalxOfC][goalyOfC] == blockC);
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

    public int xOf(type type) {
        switch(type) {
            case A:
                return blockA.getX();
            case B:
                return blockB.getX();
            case C:
                return blockC.getX();
            default:
                return 0;
        }
    }

    public int yOf(type type) {
        switch(type) {
            case A:
                return blockA.getY();
            case B:
                return blockB.getY();
            case C:
                return blockC.getY();
            default:
                return 0;
        }
    }

    public Block getBlock(type type) {
        switch(type) {
            case A:
                return blockA;
            case B:
                return blockB;
            case C:
                return blockC;
            default:
                return null;
        }
    }

    public Object getContentsAt(int x, int y) {
        return grid[x][y];
    }

    public int getGridSize() {
        return this.gridSize;
    }
}
