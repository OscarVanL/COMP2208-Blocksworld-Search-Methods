package Search;

/**
 * @author Oscar van Leusen
 */
public class Search {
    protected int computationTime = 0;

    private void incrementTime() {
        computationTime++;
    }

    private int getTime() {
        return this.computationTime;
    }
}
