package Problem_1743;

import java.util.*;

class Solution {
    public static void dfs(Map<Integer, List<Integer>> graph, Integer start, Set<Integer> visited) {
        System.out.println(start);
        visited.add(start);

        List<Integer> neighbors = graph.get(start);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfs(graph, neighbor, visited);
                }
            }
        }
    }

    private void addToMap(Map<Integer, List<Integer>> graph, int src, int dest) {
        List<Integer> list = graph.getOrDefault(src, new ArrayList<>());
        list.add(dest);
        graph.put(src, list);
    }

    public static Integer findFirstSingleNode(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getKey();
            }
        }
        return null; // Return null if no such node is found
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < adjacentPairs.length; i++) {
            addToMap(graph, adjacentPairs[i][0], adjacentPairs[i][1]);
            addToMap(graph, adjacentPairs[i][1], adjacentPairs[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(graph, findFirstSingleNode(graph), visited);

        return visited.stream().mapToInt(Integer::intValue).toArray();
    }
}

