package Search;

import World.BlocksWorld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Oscar van Leusen
 */
public class IterativeDeepening extends Search implements SearchInterface {
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
            System.out.println("Iterative deepening depth: " + depth);
            result = depthLimitedSearch(depth);
            depth++;
        }

        return result;
    }

    private Node depthLimitedSearch(int depth) {
        while (!fringe.isEmpty()) {
            Node expanding = fringe.removeFirst();

            if (expanding.isSolution()) {
                return expanding;
            } else if (expanding.getDepth()+1 <= depth) {
                incrementTime();
                expanding.calculateChildren();
                List<Node> successors = expanding.getChildren();
                for (Node node : successors) {
                    fringe.addFirst(node);
                }
            }
        }
        return null;
    }
}
