import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;


public class Dragons_230A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int power = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int [n][2];

        for(int i = 0 ; i < n ; i++){
            for(int j= 0; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        boolean flag = true;

        for(int i = 0; i < n ; i++){
            int dragPower = arr[i][0];
            int winPower = arr[i][1];

            if(dragPower < power){
                power += winPower;
            }else{
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        sc.close();
    }
}
