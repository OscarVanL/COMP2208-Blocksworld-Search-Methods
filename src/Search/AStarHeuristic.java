package Search;

import World.Block;
import World.BlocksWorld;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.abs;

/**
 * @author Oscar van Leusen
 */
public class AStarHeuristic extends Search implements SearchInterface {
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
        int blockA = abs(1-world.xOf(Block.type.A)) + abs(2-world.yOf(Block.type.A));
        int blockB = abs(1-world.xOf(Block.type.B)) + abs(1-world.yOf(Block.type.B));
        int blockC = abs(1-world.xOf(Block.type.C)) + abs(0-world.yOf(Block.type.C));
        return blockA + blockB + blockC;
    }
}
