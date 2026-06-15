import java.util.*;
public class horspool{
    static int[] shifttable(String pattern){
        int table[] = new int[256];
        int m = pattern.length();
        for(int i=0;i<256;i++){
            table[i]=m;
        }
        for(int i=0;i<m;i++){
            table[pattern.charAt(i)]=m-1-i;
        }
        return table;
    } 
    static int hor(String text,String pattern){
        int table[] = shifttable(pattern);
        int n = text.length();
        int m=pattern.length();
        int i=m-1;
        while(i<n){
            int k=0;
            while(k<m && pattern.charAt(m-1-k)==text.charAt(i-k)){
                k++;
            }
            if(k==m){
                return i-m+1;
            }
            i = i+table[text.charAt(i)];
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text :");
        String text = sc.nextLine();
        System.out.println("Enter the pattern :");
        String pattern = sc.nextLine();
        int pos = hor(text,pattern);
        if(pos==-1){
            System.out.println("pattern not found");
        }else{
            System.out.println("pattern found at :"+pos);
        }
    }
}
