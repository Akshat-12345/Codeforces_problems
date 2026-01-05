import java.util.Scanner;

public class dubStep_208A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String result = s.replaceAll("(WUB)+", " ").trim();
        System.out.println(result);

        sc.close();
    }
}

