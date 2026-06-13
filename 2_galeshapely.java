import java.util.*;
public class stablematching{
    public static boolean prefers(char pref[],char men, char curr_men){
        for(char x:pref){
            if(x == men){
                return true;
            }
            if(x == curr_men){
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pairs");
        int n = sc.nextInt();
        char menpref[][] = new char[n][n];
        char womenpref[][]=new char[n][n];
        System.out.println("Enter the men's preference list");
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                menpref[i][j] = Character.toUpperCase(sc.next().charAt(0));
            }
        }
        System.out.println("Enter the women's preference list ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                womenpref[i][j] = Character.toUpperCase(sc.next().charAt(0));
            }
        }
        char womenpartner[] = new char[n];
        int menfree[]= new int[n];
        int nextChoice[] = new int[n];
        Arrays.fill(womenpartner,'-');
        int freemen = n;
        while(freemen>0){
            int menindex;
            for(menindex = 0;menindex<n;menindex++){
                if(menfree[menindex]==0){
                    break;
                }
            }
            char men = (char) ('A'+menindex);
            char women = menpref[menindex][nextChoice[menindex]];
            nextChoice[menindex]++;
            int womenindex = women -'W';
            if(womenpartner[womenindex]=='-'){
                womenpartner[womenindex]=men;
                menfree[menindex]=1;
                freemen--;
            }else{
                char currentmen = womenpartner[womenindex];
                if(prefers(womenpref[womenindex],men,currentmen)){
                    womenpartner[womenindex]=men;
                    menfree[menindex]=1;
                    menfree[currentmen - 'A']=0;
                }
            }
        }
        System.out.println("Stable matching :");
        for(int i=0 ;i<n;i++){
            System.out.println("women "+(char)('W'+i)+" --> "+womenpartner[i]);
        }
    }
}
