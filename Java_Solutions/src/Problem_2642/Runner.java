package Problem_2642;

public class Runner {
    public static void main(String[] args) {
        Graph graph = new Graph(5, new int[][]{{0, 2 ,5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});

        int result = graph.shortestPath(3, 2);
        int result2 = graph.shortestPath(0, 3);

        graph.addEdge(new int[]{1, 3, 4});
        
        int result3 = graph.shortestPath(0, 3);

        System.out.println("Result 1: " + result);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
    }
}

