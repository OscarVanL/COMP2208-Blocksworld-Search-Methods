package Search;

import World.Block;
import World.BlocksWorld;

import java.util.Comparator;
import java.util.PriorityQueue;

import static World.BlocksWorld.*;
import static java.lang.Math.abs;

/**
 * @author Oscar van Leusen
 */
public class AStarHeuristic extends Search {
    private Comparator<Node> manhattanComparator = Comparator.comparingInt(n -> n.getDepth() + manhattanDistance(n.getState()));
    private PriorityQueue<Node> fringe;

    public AStarHeuristic(BlocksWorld world) {
        super(world);
        fringe = new PriorityQueue<>(manhattanComparator);
    }

    @Override
    public Node run() {
        fringe.add(new Node(this.startWorld, 0));

        while (!fringe.isEmpty()) {
            Node nextClosest = fringe.remove();

            if (isDebugging()) {
                printDebug(this, nextClosest);
            }

            newDepthCheck(nextClosest, this);

            if (nextClosest.isSolution()) {
                return nextClosest;
            } else {
                incrementTime();
                nextClosest.calculateChildren();
                fringe.addAll(nextClosest.getChildren());

            }
        }

        return null;
    }

    /**
     * Calculates manhattan distance heuristic from our block positions versus the goal positions.
     */
    private static int manhattanDistance(BlocksWorld world) {
        int blockA = abs(goalxOfA-world.xOf(Block.type.A)) + abs(goalyOfA-world.yOf(Block.type.A));
        int blockB = abs(goalxOfB-world.xOf(Block.type.B)) + abs(goalyOfB-world.yOf(Block.type.B));
        int blockC = abs(goalxOfC-world.xOf(Block.type.C)) + abs(goalyOfC-world.yOf(Block.type.C));
        return blockA + blockB + blockC;
    }

    public int fringeSize() {
        return fringe.size();
    }

    @Override
    public void printDebug(Search search, Node node) {
        printGrid(search, node);
        System.out.println("");
        System.out.println("Fringe size: " + search.fringeSize());
        System.out.println("Computational time: " + search.getTime());
        System.out.println("Depth: " + node.numberOfParents());
        System.out.print("Solution: ");
        node.printSolutionToNode();
        System.out.println("Manhattan distance: " + manhattanDistance(node.getState()));
        System.out.println("-----");

    }
}
