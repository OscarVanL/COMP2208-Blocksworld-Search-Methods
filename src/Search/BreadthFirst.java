package Search;

import World.BlocksWorld;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Oscar van Leusen
 */
public class BreadthFirst extends Search implements SearchInterface {
    private Deque<Node> fringe;

    public BreadthFirst(BlocksWorld world) {
        super(world);
        fringe = new ArrayDeque<>();
    }

    @Override
    public Node run() {
        fringe.add(new Node (this.startWorld, 0));
        //If fringe empties without finding the solution, then for some reason we can't find the solution with DepthFirst
        //(This shouldn't be a possibility anyway.)
        while (!fringe.isEmpty()) {
            Node expanding = fringe.removeFirst();

            if (isDebugging()) {
                System.out.println("Fringe size: " + fringe.size());
                printDebug(expanding);
            }

            if (expanding.isSolution()) {
                return expanding;
            } else {
                incrementTime();
                //Children are not randomised.
                expanding.calculateChildren();
                fringe.addAll(expanding.getChildren());

            }
        }
        //If no solution is found.
        return null;
    }
}
