package dynamicprogramming.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    Map<UndirectedGraphNode, UndirectedGraphNode> checked;

    public static void main(String[] args) {
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        node.neighbors.add(new UndirectedGraphNode(3));
        node.neighbors.add(new UndirectedGraphNode(2));
        UndirectedGraphNode child = new UndirectedGraphNode(4);
        child.neighbors.add(new UndirectedGraphNode(5));
        child.neighbors.add(new UndirectedGraphNode(6));
        node.neighbors.add(child);

        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.cloneGraph(node);

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        checked = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        if (!checked.isEmpty() && checked.containsKey(node)) {
            return checked.get(node);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        checked.put(node, cloneNode);
        for (UndirectedGraphNode neighbour : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbour));
        }
        return cloneNode;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
