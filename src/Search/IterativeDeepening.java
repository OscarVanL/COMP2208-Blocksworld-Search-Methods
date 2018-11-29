package Search;

import World.BlocksWorld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Oscar van Leusen
 */
public class IterativeDeepening extends Search {
    private Deque<Node> fringe;

    public IterativeDeepening(BlocksWorld world) {
        super(world);
        fringe = new ArrayDeque<>();
    }

    @Override
    public Node run() {
        Node result = null;
        int depth = 0;
        while (result == null) {
            fringe = new ArrayDeque<>();
            fringe.add(new Node (this.startWorld, 0));
            result = depthLimitedSearch(depth);
            depth++;
        }
        return result;
    }

    private Node depthLimitedSearch(int depth) {
        while (!fringe.isEmpty()) {
            Node expanding = fringe.removeFirst();

            if (isDebugging()) {
                printDebug(this, expanding);
            }

            newDepthCheck(expanding, this);

            if (expanding.isSolution()) {
                return expanding;
            } else if (expanding.getDepth()+1 <= depth) {
                incrementTime();
                expanding.calculateChildren();
                List<Node> successors = expanding.getChildren();
                fringe.addAll(successors);
            } else if (expanding.getDepth() > depth) {
                return null;
            }
        }
        return null;
    }

    @Override
    public int fringeSize() {
        return fringe.size();
    }
}
