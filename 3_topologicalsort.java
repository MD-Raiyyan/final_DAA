import java.util.*;
public class top{
    static ArrayList<Integer> graph[] ;
    static int visited[] ;
    static Stack<Integer> stack = new Stack<>();
    static void dfs(int v){
        visited[v]=1;
        
        for(int x : graph[v]){
            if(visited[x]==0){
            dfs(x);
        }}
        stack.push(v);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices :");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = sc.nextInt();
        graph = new ArrayList[n];
        visited = new int[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        System.out.println("Enter the edges from to t");
        for(int i =0;i<e;i++){
            char from = sc.next().charAt(0);
            char to = sc.next().charAt(0);
            graph[from - 'A'].add(to-'A');
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }
        System.out.println("Topological sorting");
        for(int i=0;i<n;i++){
            System.out.print((char)(stack.pop()+'A')+" ");
        }
    }
}
