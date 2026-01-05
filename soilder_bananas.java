import java.util.Scanner;

public class soilder_bananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int dollar = sc.nextInt();
        int bananas = sc.nextInt();

        int total = k * (bananas * (bananas + 1)/2);

        int remaining_dollar = total - dollar;

        if(remaining_dollar < 0){
            System.out.println(0);
        }else{
            System.out.println(remaining_dollar);
        }
        sc.close();
        
    }
}
