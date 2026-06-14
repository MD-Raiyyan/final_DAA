import java.util.*;
public class flyd{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int n = sc.nextInt();
        int graph[][] = new int [n][n];
        System.out.println("Enter the adjacency matrix :");
        System.out.println("(Enter 9999 for no edge vertex)");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        long start = System.nanoTime();
        for(int k=0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(graph[i][k]+graph[k][j]<graph[i][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("The distance matrix :");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j] == 9999){
                    System.out.print("INF\t");
                }else{
                    System.out.print(graph[i][j]+"\t");
                }
            }
            System.out.println();
        }
        System.out.println("the Execution time is : "+(end-start)+"ns");
    }
}
