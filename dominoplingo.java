import java.util.Scanner;

public class dominoplingo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int total = m*n;
        int ans = total/2;

        System.out.println(ans);
    }
}
