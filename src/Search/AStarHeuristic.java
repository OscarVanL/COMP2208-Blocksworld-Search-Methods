package Search;

import World.Block;
import World.BlocksWorld;

/**
 * @author Oscar van Leusen
 */
public class AStarHeuristic extends Search implements SearchInterface {
    public AStarHeuristic(BlocksWorld world) {
        super(world);
    }

    @Override
    public Node run() {
        return null;
    }

    /**
     * Calculates manhattan distance heuristic from our block positions versus the goal positions.
     */
    public static int manhattanDistance(BlocksWorld world) {
        int blockA = (1-world.xOf(Block.type.A)) + (2-world.yOf(Block.type.A));
        int blockB = (1-world.xOf(Block.type.B)) + (1-world.yOf(Block.type.B));
        int blockC = (1-world.xOf(Block.type.C)) + (0-world.yOf(Block.type.C));
        return blockA + blockB + blockC;
    }
}
