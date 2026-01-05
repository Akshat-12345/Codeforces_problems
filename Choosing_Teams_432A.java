import java.util.Arrays;
import java.util.Scanner;

public class Choosing_Teams_432A{
    public static int solve(int [] arr , int k){
        Arrays.sort(arr);
        int team = 0;
        int count = 0;
        int n = arr.length;

        for(int i = 0; i < n ; i++){
            if(arr[i] <= 5 - k){
                count++;
            }else{
                break;
            }

            if(count == 3){
                count = 0;
                team++;
            }
        }
        return team;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0; i < n ;i++){
            arr[i] = sc.nextInt();
        }

        int teams = solve(arr,k);

        System.out.println(teams);
        sc.close();
    }
}