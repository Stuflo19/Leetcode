package Problem_2642;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
    public HashMap<Integer, Integer> neighbors;

    void addNeighbor(int cost, int node) {
        neighbors.putIfAbsent(node, cost);  
    }

    Node() {
        this.neighbors = new HashMap<>();
    }
}

public class Graph {
    HashMap<Integer, Node> graph = new HashMap<>();

    public Graph(int n, int[][] edges) {
        for(int[] node : edges) {
            addEdge(node);
        }
    }
    
    public void addEdge(int[] edge) {
        graph.putIfAbsent(edge[0], new Node()); 
        graph.putIfAbsent(edge[1], new Node());
        graph.get(edge[0]).addNeighbor(edge[2], edge[1]);
    }
    
    public int shortestPath(int node1, int node2) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distances = new HashMap<>(); 

        for(int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(node1, 0);

        for (int i = 0; i < graph.size() - 1; i++) {
            int min = minDistance(distances, visited); 
            visited.add(min);

            if(graph.containsKey(min)) {
                for(int neighbor : graph.get(min).neighbors.keySet()) {
                    if (!visited.contains(neighbor)) {
                        distances.put(neighbor, Math.min(distances.get(neighbor), distances.get(min) + graph.get(min).neighbors.get(neighbor)));
                    }
                }
            }
        }

        if(distances.get(node2) == Integer.MAX_VALUE) return -1;
        return distances.get(node2);
    }

    private int minDistance(Map<Integer, Integer> distances, Set<Integer> visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int node : distances.keySet()) {
            if (!visited.contains(node) && distances.get(node) < min) {
                min = distances.get(node);
                minIndex = node;
            }
        }

        return minIndex;
    }
}
