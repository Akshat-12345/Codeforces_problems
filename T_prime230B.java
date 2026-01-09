import java.util.Arrays;
import java.util.Scanner;

public class T_prime230B {
    public static int n = 1000000;
    public static long [] arr1 = new long [n+1];
    public static void sieve() {
        // if (n < 2) return false;
        // for (long i = 2; i * i <= n; i++) {
        //     if (n % i == 0) return false;
        // }

        // return true
        
        Arrays.fill(arr1,1);
        arr1[0] = arr1[1] = 0;

        for(int i = 2 ; i * i <= n ; i++){
            if(arr1[i] == 1){
                for(int j = i*i ; j<= n ;j= j + i){
                    arr1[j] = 0;
                }
            }
        }
    }

    public static boolean isPrime(long n){
        if(arr1[(int)n] == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sieve();
        long  [] arr = new long [n];

        for(int  i = 0; i< n ; i++){
            arr[i] = sc.nextLong();
        }
        
        for(int i = 0 ; i< n ;i++ ){
            long x = (long)Math.sqrt(arr[i]);
            if(isPrime(x) && x*x == arr[i]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
