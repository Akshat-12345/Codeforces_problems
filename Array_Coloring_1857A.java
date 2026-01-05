import java.util.Scanner;

public class Array_Coloring_1857A {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();

        for(int i = 0 ; i < t ; i++){
            int n = sc.nextInt();
            int [] arr = new int [n];

            for(int j = 0 ; j < n; j++){
                arr[j] = sc.nextInt();
            }
            int count = 0;
            for(int k = 0; k < n ; k++ ){
                if(arr[k]%2 == 1){
                    count++;
                }
            }

            if(count% 2 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

        sc.close();
   } 
}
