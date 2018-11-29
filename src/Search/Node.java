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
    private Direction directionMoved;

    /**
     * Used for instantiating first node in tree, since it won't have a parent.
     * @param state : States of all blocks in BlocksWorld, the default positions.
     */
    public Node (BlocksWorld state, int depth) {
        this.parent = null;
        this.worldState = state;
        this.depth = depth;
        this.directionMoved = null;
        children = new ArrayList<Node>();
    }

    private Node (Node parent, BlocksWorld state, int depth, Direction directionMoved) {
        this.parent = parent;
        this.worldState = state;
        this.depth = depth;
        this.directionMoved = directionMoved;
        children = new ArrayList<Node>();
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
                children.add(new Node (this, newWorld, this.depth+1, direction));
            }
        }
     }

     public void calculateChildren() {
        if (worldState.canMove(Direction.Up)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Up);
            children.add(new Node(this, newWorld, this.depth+1, Direction.Up));
        }
        if (worldState.canMove(Direction.Down)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Down);
            children.add(new Node(this, newWorld, this.depth+1, Direction.Down));
        }
        if (worldState.canMove(Direction.Left)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Left);
            children.add(new Node(this, newWorld, this.depth+1, Direction.Left));
        }
        if (worldState.canMove(Direction.Right)) {
            BlocksWorld newWorld = new BlocksWorld(worldState);
            newWorld.moveAgent(Direction.Right);
            children.add(new Node(this, newWorld, this.depth+1, Direction.Right));
        }
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


    public Deque<Node> findNodeHistory() {
        Deque<Node> nodeHistory = new ArrayDeque<Node>();
        nodeHistory.add(this);
        Node currentNode = this;
        while (currentNode != null) {
            currentNode = currentNode.parent;
            if (currentNode != null && currentNode.directionMoved != null) {
                nodeHistory.addFirst(currentNode);
            }
        }
        return nodeHistory;
    }

    public void printSolutionToNode() {
        for (Node node : this.findNodeHistory()) {
            System.out.print(node.getDirection());
        }
        System.out.println();
    }

    public Direction getDirection() {
        return this.directionMoved;
    }

    public int numberOfParents() {
        int parents = 0;
        Node checkedNode = this;
        while (checkedNode.parent != null) {
            parents++;
            checkedNode = checkedNode.parent;
        }
        return parents;
    }
}
