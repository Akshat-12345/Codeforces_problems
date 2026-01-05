import java.util.Scanner;

public class elephant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 1;
        while(x > 5){
            x = x - 5;
            count++;
        }

        System.out.println(count);
        sc.close();
    }
}
