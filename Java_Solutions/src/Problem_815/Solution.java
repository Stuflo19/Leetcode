import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class BusGraph {
    private Map<Integer, List<Integer>> busGraph;
    private int[][] busses;

    public BusGraph(int[][] routes) {
        this.busGraph = new HashMap<>();
        this.busses = routes;

        for(int i = 0; i < routes.length; i++) {
            addBus(i, routes[i]);
        }
    }

    public void addBus(int bus, int[] routes) {
        for (int route : routes) {
            busGraph.putIfAbsent(route, new ArrayList<Integer>());
            busGraph.get(route).add(bus);
        }
    }

    public int findShortestPath(int startRoute, int endRoute) {
        if(startRoute == endRoute) {
            return 0;
        } 

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int bussesTaken = 1;

        queue.addAll(busGraph.get(startRoute));

        while (!queue.isEmpty()) {
            int currRequests = queue.size();
            for(int i = 0; i < currRequests; i++) {
                int currentBus = queue.poll();          

                for (int route : busses[currentBus]) {
                    if(route == endRoute) return bussesTaken;
                    for(int bus : busGraph.get(route)) {
                        if(visited.contains(bus)) continue;
                        visited.add(bus);
                        queue.add(bus);
                    }
                }
            }
            bussesTaken++;
        }

        return -1;
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        BusGraph graph = new BusGraph(routes);

        return graph.findShortestPath(source, target);
    }
}
