import Search.BreadthFirst;
import Search.DepthFirst;
import Search.IterativeDeepening;
import Search.Node;
import World.BlocksWorld;

/**
 * @author Oscar van Leusen
 */
public class Main {
    public static void main(String args[]) {
        BlocksWorld blocksWorld = new BlocksWorld(4);

        //Not yet implemented.
        IterativeDeepening search1 = new IterativeDeepening(blocksWorld);
        search1.setDebugging(false);
        search1.run();
        System.out.println(search1.getTime());
    }
}
