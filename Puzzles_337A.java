import java.util.Arrays;
import java.util.Scanner;

public class Puzzles_337A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int [m];

        for(int i = 0 ; i< m ; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + n - 1 < m; i++) {
            ans = Math.min(ans, arr[i + n - 1] - arr[i]);
        }


        System.out.println(ans);
        sc.close();

    }
}
