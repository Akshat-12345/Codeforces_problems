import java.util.Arrays;
import java.util.Scanner;

public class Twins_160A {
    public static int solve(int [] arr){
        int  n = arr.length;

        for(int i = 0 ; i < n ; i++){
            if(arr[i] > arr[n-1] - arr[i]){
                return i;
            }
        }

        return -1;
    }

    public static void reverse(int [] arr){
         int i = 0;
         int j = arr.length-1;

         while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
         }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0; i < n ;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        reverse(arr);
        int [] prefix= new int [n+1];
        prefix[0] = 0;

        for(int  i = 1 ; i <= n ; i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
       
        int total = solve(prefix);
        System.out.println(total);

        sc.close();
    }
}
