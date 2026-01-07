import java.util.Scanner;

public class Calculating_Function_486A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = 0L;
        
            if(n%2 == 1){
                ans = -(n+1)/2;
            }else{
                ans = n/2;
            }
        

        System.out.println(ans);
        sc.close();
    }
}
