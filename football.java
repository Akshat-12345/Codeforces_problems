import java.util.*;
public class football {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        String s = sc.nextLine();

        int n  = s.length();
        int count = 1;
        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                ans = Math.max(ans,count);
                count = 1;
            }
        }
        
        ans = Math.max(ans, count);
        if(ans >= 7){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
        sc.close();
    }
}
