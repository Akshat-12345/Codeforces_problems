import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Triangulation1140A {

    static long [][] dp;

    public static long solve(int s , int e){
        if( e - s < 2){
            return 0;
        }
        if(dp[s][e] != -1){
            return dp[s][e];
        }

        long ans = Long.MAX_VALUE;

        for(int i = s + 1 ; i < e ; i++){
            long total = solve(s,i) + solve(i, e) + (long)s*i*e;
            ans = Math.min(ans, total);
        }

        dp[s][e] = ans;

        return dp[s][e];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1][n+1];

        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(1,n));

        sc.close();
    }
}
