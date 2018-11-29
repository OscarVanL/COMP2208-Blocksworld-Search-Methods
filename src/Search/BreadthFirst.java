package Search;

import World.BlocksWorld;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Oscar van Leusen
 */
public class BreadthFirst extends Search {
    private Deque<Node> fringe;

    public BreadthFirst(BlocksWorld world) {
        super(world);
        fringe = new ArrayDeque<>();
    }

    @Override
    public Node run() {
        fringe.add(new Node (this.startWorld, 0));
        while (!fringe.isEmpty()) {
            Node expanding = fringe.removeFirst();

            if (isDebugging()) {
                printDebug(this, expanding);
            }

            newDepthCheck(expanding, this);

            if (expanding.isSolution()) {
                return expanding;
            } else {
                incrementTime();
                //Children are not randomised.
                expanding.calculateChildren();
                fringe.addAll(expanding.getChildren());
            }
        }
        return null;
    }

    public int fringeSize() {
        return fringe.size();
    }
}
