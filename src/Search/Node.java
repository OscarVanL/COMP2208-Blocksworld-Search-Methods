package Search;

import World.BlocksWorld;
import World.Direction;

import java.util.*;

/**
 * @author Oscar van Leusen
 */
public class Node {
    private Node parent;
    private BlocksWorld worldState;
    private List<Node> children;
    private int depth;

    /**
     * Used for instantiating first node in tree, since it won't have a parent.
     * @param state : States of all blocks in BlocksWorld, the default positions.
     */
    public Node (BlocksWorld state, int depth) {
        this.parent = null;
        this.worldState = state;
        this.depth = depth;
        children = new ArrayList<Node>();
    }

    public Node (Node parent, BlocksWorld state, int depth) {
        this.parent = parent;
        this.worldState = state;
        this.depth = depth;
        children = new ArrayList<Node>();
    }

    public boolean isFirstNode() {
        if (parent == null) {
            return true;
        } else {
            return false;
        }
     }

     public BlocksWorld getState() {
        return worldState;
     }

     public void calculateRandomChildren() {
        List<Direction> directionList = Arrays.asList(Direction.values());
        Collections.shuffle(directionList);

        for (Direction direction : directionList) {
            if (worldState.canMove(direction)) {
                BlocksWorld newWorld = new BlocksWorld(worldState);
                newWorld.moveAgent(direction);
                children.add(new Node (this, newWorld, this.depth+1));
            }
        }
     }

     public void calculateChildren() {
        if (worldState.canMove(Direction.Up)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Up);
            children.add(new Node(this, newWorld, this.depth+1));
        }
        if (worldState.canMove(Direction.Down)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Down);
            children.add(new Node(this, newWorld, this.depth+1));
        }
        if (worldState.canMove(Direction.Left)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Left);
            children.add(new Node(this, newWorld, this.depth+1));
        }
        if (worldState.canMove(Direction.Right)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Right);
            children.add(new Node(this, newWorld, this.depth+1));
        }
     }

    public static Direction randomDirection() {
        Random random = new Random();
        int rand = random.nextInt(Direction.class.getEnumConstants().length);
        return Direction.class.getEnumConstants()[rand];
    }

    public boolean isSolution() {
        return worldState.inGoalState();
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public int getDepth() {
        return this.depth;
    }

}
