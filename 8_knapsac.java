import java.util.*;
public class knapsack{
    public static void main(String[] args){
        Scanner sc  =new Scanner(System.in);
        System.out.println("Enter the number of items:");
        int n = sc.nextInt();
        int values[] =new int[n];
        int weigth[] = new int[n];
        System.out.println("Enter the value of values");
        for(int i=0;i<n;i++){
            values[i] = sc.nextInt();
        }
        System.out.println("Enter the weigth ;");
        for(int i=0;i<n;i++){
            weigth[i]=sc.nextInt();
        }
        System.out.println("Enter the knapsack capacity ");
        int w = sc.nextInt();
        int dp[][] = new int [n+1][w+1];
        long start = System.nanoTime();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(weigth[i-1]<=j){
                    dp[i][j]=Math.max(values[i-1]+dp[i-1][j-weigth[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
            }}
        }
        long end = System.nanoTime();
        System.out.println("Maximum profit : "+dp[n][w]);
        System.out.println("Execution time :"+ (end-start)+ " ns");
    }
}
