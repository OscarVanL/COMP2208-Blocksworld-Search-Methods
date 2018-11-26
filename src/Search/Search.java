package Search;

import World.Agent;
import World.Block;
import World.BlocksWorld;

/**
 * @author Oscar van Leusen
 */
public class Search {
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

    public void printDebug(Node expanding) {
        for (int y=startWorld.getGridSize()-1; y>=0; y--) {
            for (int x=0; x<startWorld.getGridSize(); x++) {
                if (expanding.getState().getContentsAt(x, y) == null) {
                    System.out.print("_");
                } else if (expanding.getState().getContentsAt(x, y) instanceof Agent) {
                    System.out.print("A");
                } else if (expanding.getState().getContentsAt(x, y) instanceof Block) {
                    System.out.print("B");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }
}

