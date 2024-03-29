package Search;

import World.BlocksWorld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Oscar van Leusen
 */
public class DepthFirst extends Search {
    private Deque<Node> fringe;

    public DepthFirst(BlocksWorld world) {
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
                printDebug(this, expanding);
            }

            //newDepthCheck(expanding, this);

            if (expanding.isSolution()) {
                return expanding;
            } else {
                incrementTime();
                //Children are randomised for depth first, or else it will just run the same move repeatedly
                expanding.calculateRandomChildren();
                List<Node> successors = expanding.getChildren();
                for (Node node : successors) {
                    fringe.addFirst(node);
                }
            }
        }
        //If no solution is found.
        return null;
    }

    @Override
    public int fringeSize() {
        return fringe.size();
    }
}
