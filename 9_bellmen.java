import java .util.*;
public class bellmen{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges ");
        int e = sc.nextInt();
        int edge[][] = new int [e][3];
        System.out.println("Enter the source vertex ");
        int source = sc.nextInt();
        System.out.println("Enter the source , destination and weight of the edges ");
        for(int i=0;i<e;i++){
            edge[i][0] =sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2]= sc.nextInt();
        }
        int dist[] = new int[n];
        Arrays.fill(dist,9999);
        dist[source] = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<e;j++){
                int u = edge[j][0];
                int v = edge[j][1];
                int w =edge[j][2];
                if(dist[u]!= 9999 && dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }
        boolean negativecycle=false;
        for(int j=0;j<e;j++){
            int u = edge[j][0];
            int v = edge[j][1];
            int w = edge[j][2];
            if(dist[u]!= 9999 && dist[u]+w<dist[v]){
                negativecycle = true;
                break;
            }
        }
        if(negativecycle){
            System.out.println("Negative Weight Cycle Detected");
        }else{
            System.out.print("vertex\t distance\n");
            for(int i=0;i<n;i++){
                System.out.println(i+"\t"+dist[i]);
            }
            }
        }
}
