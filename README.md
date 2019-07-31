# COMP2208-Blocksworld-Search-Methods

An implementation of various search algorithms to find a solution to the BlocksWorld game from the University of Southampton's COMP2208 Module coursework.

This involves a game 'board' where a series of blocks have initial positions and goal positions they must be moved to. A theoretical 'agent' is able to move these blocks, but only by pushing one block up, down left or right at a time.

The task was to construct the game board (and the constraints put upon its entities), and then implement Breadth First, Depth First, Iterative Deepening and A Star Heuristic algorithms to automatically solve the game board in the fewest possible moves by the agent.
The performance of each algorithm to find this best solution was then assessed.

In src/World/BlocksWorld.java different initialisations of the BlocksWorld world can be uncommented to give variable complexity. The default best-case complexity is 14-moves to solve it. 
The BlocksWorld.java class contains easier initialisations, so that we can try each out and see how the performance of the algorithms varies by the complexity of the domain they are required to solve.

I received 90% for this coursework, so my professor must have been happy with it ;)

This repository was only made public long after we received our grades to ensure people couldn't use my work for plagiarism!
