import java.util.*;
public class Panoramix_Prediction_80A {
    public static boolean prime(int n){
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                count++;
            }
            if(count > 2){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count  = 0;

        for(int i = n + 1 ; i <= m ; i++){
            if(prime(i)){
                count++;
            }
        }

        if(count == 1 && prime(m)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        sc.close();
    }
}
