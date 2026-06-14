import java.util.*;

public class Prim {

    static final int INF = 9999;

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

        int visited[] = new int[n];

        visited[0] = 1; // Start from vertex 0

        int edges = 0;
        int minCost = 0;

        long start = System.nanoTime();

        System.out.println("\nEdges in Minimum Spanning Tree:");

        while (edges < n - 1) {

            int min = INF;
            int u = -1;
            int v = -1;

            for (int i = 0; i < n; i++) {

                if (visited[i] == 1) {

                    for (int j = 0; j < n; j++) {

                        if (visited[j] == 0 &&
                            graph[i][j] != 0 &&
                            graph[i][j] < min) {

                            min = graph[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            System.out.println(u + " -> " + v + " : " + min);

            visited[v] = 1;
            minCost += min;
            edges++;
        }

        long end = System.nanoTime();

        System.out.println("\nMinimum Cost = " + minCost);
        System.out.println("Execution Time = " + (end - start) + " ns");

        sc.close();
    }
}
