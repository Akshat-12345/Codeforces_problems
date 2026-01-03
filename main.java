import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set <Integer> s1 = new HashSet<>();
        Set <Integer> s2 = new HashSet<>();

        for(int i = 1 ; i <= n ; i++){
            s1.add(i);
        }

        int p = sc.nextInt();

        for(int i = 1 ; i <= p ; i++){
            s2.add(sc.nextInt());
        }

        int q = sc.nextInt();
        for(int i = 1 ; i <= q ; i++){
            s2.add(sc.nextInt());
        }


        if(s1.equals(s2)){
            System.out.println("I become the guy.");
        }else{
            System.out.println("Oh, my keyboard!");
        }

    }
}
