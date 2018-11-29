package Search;

import World.Agent;
import World.Block;
import World.BlocksWorld;

/**
 * @author Oscar van Leusen
 */
public abstract class Search {
    protected int depthExplored = 0;
    private int computationTime = 0;
    protected BlocksWorld startWorld;
    private boolean isDebugging;

    public Search (BlocksWorld startWorld) {
        this.startWorld = startWorld;
    }

    protected void incrementTime() {
        computationTime++;
    }

    public int getTime() {
        return this.computationTime;
    }

    public void setDebugging(boolean isDebugging) {
        this.isDebugging = isDebugging;
    }

    public boolean isDebugging() {
        return this.isDebugging;
    }

    public void newDepthCheck(Node node, Search search) {
        if (node.numberOfParents() > depthExplored) {
            depthExplored = node.numberOfParents();
            System.out.println("Fringe size: " + search.fringeSize());
            System.out.println("Computational time: " + search.getTime());
            System.out.println("Depth: " + node.numberOfParents());
            System.out.println("Solution: ");
            node.printSolutionToNode();
            System.out.println("-----");
        }
    }

    public void newDepthCheck(Node node, IterativeDeepening search) {
        if (node.numberOfParents() > depthExplored) {
            depthExplored = node.numberOfParents();
            System.out.println("Fringe size: " + search.fringeSize());
            System.out.println("Computational time: " + search.getTime());
            System.out.println("Depth: " + node.numberOfParents());
            System.out.print("Actions: ");
            node.printSolutionToNode();
            System.out.println("-----");
        }
    }

    public void printGrid(Search search, Node node) {
        for (int y=startWorld.getGridSize()-1; y>=0; y--) {
            for (int x=0; x<startWorld.getGridSize(); x++) {
                if (node.getState().getContentsAt(x, y) == null) {
                    System.out.print("_");
                } else if (node.getState().getContentsAt(x, y) instanceof Agent) {
                    System.out.print("*");
                } else if (node.getState().getContentsAt(x, y) instanceof Block) {
                    if (node.getState().getContentsAt(x,y) == node.getState().getBlock(Block.type.A)) {
                        System.out.print("A");
                    } else if (node.getState().getContentsAt(x,y) == node.getState().getBlock(Block.type.B)) {
                        System.out.print("B");
                    } else if (node.getState().getContentsAt(x,y) == node.getState().getBlock(Block.type.C)) {
                        System.out.print("C");
                    }
                }
            }
            System.out.println("");
        }
    }

    public void printDebug(Search search, Node node) {
        printGrid(search, node);
        System.out.println("");
        System.out.println("Fringe size: " + search.fringeSize());
        System.out.println("Computational time: " + search.getTime());
        System.out.println("Depth: " + node.numberOfParents());
        System.out.println("Solution: ");
        node.printSolutionToNode();
        System.out.println("-----");

    }

    public abstract int fringeSize();
    public abstract Node run();
}

