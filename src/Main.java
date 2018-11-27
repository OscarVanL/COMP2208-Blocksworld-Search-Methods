import Search.*;
import World.BlocksWorld;

import java.util.List;

/**
 * @author Oscar van Leusen
 */
public class Main {
    public static void main(String[] args) {
        BlocksWorld blocksWorld = new BlocksWorld(4);

        //Not yet implemented.
        AStarHeuristic search1 = new AStarHeuristic(blocksWorld);
        search1.setDebugging(false);
        Node finalNode = search1.run();
        System.out.println("Solution found:");
        System.out.println("Depth of final move: " + finalNode.getDepth());
        System.out.println("Time complexity: " + search1.getTime());
        System.out.println("Moves taken: ");
        for (Node node : finalNode.findNodeHistory()) {
            System.out.print(node.getDirection());
        }
    }


}
