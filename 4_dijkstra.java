import java.util.*;

public class Dijkstra {

    static final int INF = 9999;

    static void printPath(int parent[], int v) {
        if (v == -1)
            return;

        printPath(parent, parent[v]);
        System.out.print(v + " ");
    }

    static void dijkstra(int graph[][], int source) {

        int n = graph.length;

        int dist[] = new int[n];
        int visited[] = new int[n];
        int parent[] = new int[n];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);

        dist[source] = 0;

        // Main Algorithm
        for (int i = 0; i < n - 1; i++) {

            int min = INF;
            int u = -1;

            // Find minimum distance unvisited vertex
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            // Mark as visited
            visited[u] = 1;

            // Update distances
            for (int v = 0; v < n; v++) {

                if (visited[v] == 0 &&
                    graph[u][v] != 0 &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Print Result
        System.out.println("\nVertex\tCost\tPath");

        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t" + dist[i] + "\t");
            printPath(parent, i);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        long start = System.nanoTime();

        dijkstra(graph, source);

        long end = System.nanoTime();

        System.out.println("\nExecution Time = " + (end - start) + " ns");

        sc.close();
    }
}
