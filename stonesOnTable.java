import java.util.Scanner;

public class stonesOnTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int count = 0;
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
               count++;
            }
        }
        
        System.out.println(count);

    }
}
