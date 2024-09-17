# What is a Graph?

A graph is a collection of nodes where each node might point to other nodes. These nodes are connected to each other through a set of edges. Graphs are similar to trees but trees follow certain rules when it comes to its edges:

For a tree with N nodes, it will have (N-1) edges; one edge for each parent-child relationship. All nodes must be reachable from the root and there must be exactly one possible path from root to a node.


# Graph Type

1. **Directed edges** in which connections are one-way (Unidirectional). One of the end points is the origin and the other end point is the destination.
2. **Undirected edges** in which connections are two-way (Bidirectional).


# Cycles in Graph

1. Undirected Cyclic and Acyclic Graph
2. Directed Cyclic and Acyclic Graph


# Path

* contains lot of nodes and edges and each of them are reachable.
* node cannot appear more than once in a path

# Degree of a graph

1. **Undirected Graph** : No of edges that attached to a node total degree= 2*No. Edges
2. **Directed Graph :** InDegree and outDegree


# Weighted Edges

Not all edges are created equal. Sometimes in a graph, some connections may be preferable to others. If we go back to the example of representing streets as graphs, usually if you wanted to get from point A to point B, you would want to take the path with the least traffic. An edge with less traffic may be “worth more”. A highway with a higher speed limit may also be “worth more” than a side road with a lower speed limit.
