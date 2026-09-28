import java.util.*;

public class CampusGraph {
    private int numVertices;
    private int[][] adjMatrix;
    private String[] locations;

    public CampusGraph(String[] locations) {
        this.locations = locations;
        this.numVertices = locations.length;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight;
    }

    public void dijkstra(int startVertex) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = getMinDistanceVertex(distances, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE
                        && distances[u] + adjMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjMatrix[u][v];
                }
            }
        }

        printShortestPaths(startVertex, distances);
    }

    private int getMinDistanceVertex(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printShortestPaths(int startVertex, int[] distances) {
        System.out.println("\n--- Shortest Paths from " + locations[startVertex] + " (Dijkstra) ---");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("To " + locations[i] + " : " + (distances[i] == Integer.MAX_VALUE ? "Unreachable" : distances[i] + " meters"));
        }
    }
}