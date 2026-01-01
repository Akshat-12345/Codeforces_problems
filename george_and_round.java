import java.util.*;

public class george_and_round {

    public static int solve(int [] arr, int [] george){
        Arrays.sort(arr);
        Arrays.sort(george);
        
        int n = arr.length;
        int m = george.length;

        int count = 0;
        int i = 0;
        int j = 0;
        while ( i < n &&  j < m) {
            if(arr[i] <= george[j]){
                 count++;
                 i++;
                 j++;
            }else{
                j++;
            }           
        }

        int total = n - count;

        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int m =  sc.nextInt();

        int [] arr = new int [n];
        int [] george = new int [m];

        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m ; i++){
            george[i] = sc.nextInt();
        }

        int total = solve(arr,george);
        
        System.out.println(total);
        
    }
}
