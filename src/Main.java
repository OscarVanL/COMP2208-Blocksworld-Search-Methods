import Search.*;
import World.BlocksWorld;

/**
 * @author Oscar van Leusen
 */
public class Main {
    public static void main(String[] args) {
        BlocksWorld blocksWorld = new BlocksWorld(4);

        //DepthFirst search1 = new DepthFirst(blocksWorld);
        //BreadthFirst search1 = new BreadthFirst(blocksWorld);
        //IterativeDeepening search1 = new IterativeDeepening(blocksWorld);
        AStarHeuristic search1 = new AStarHeuristic(blocksWorld);
        search1.setDebugging(false);
        Node finalNode = search1.run();
        System.out.println("Solution found!");
        System.out.println("Fringe size: " + search1.fringeSize());
        System.out.println("Depth of final move: " + finalNode.getDepth());
        System.out.println("Time complexity: " + search1.getTime());
        System.out.println("Moves taken: ");
        finalNode.printSolutionToNode();
    }
}