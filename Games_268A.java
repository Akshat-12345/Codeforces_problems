import java.util.Scanner;

public class Games_268A {
    public static int solve(int [][] arr){
        int change = 0;
        int n =  arr.length;
        for(int i = 0 ; i< n ;i++){
           int away = arr[i][1];
           for(int j = 0 ; j < n ; j++){
              int home = arr[j][0];
              if(away == home){
                change++;
              }
           }
        }
        return change;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        int [][] arr = new int [n][2];
        
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int change = solve(arr);

        System.out.println(change);
        sc.close();
    }
}
