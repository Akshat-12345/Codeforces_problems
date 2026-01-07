import java.math.BigInteger;
import java.util.Scanner;

public class ultra_fast_mathmatician_61A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        String m = sc.nextLine();

        BigInteger a = new BigInteger(n, 2);
        BigInteger b = new BigInteger(m, 2);

        BigInteger c = a.xor(b);

        String ans = c.toString(2);

        int len = Math.max(n.length(), m.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len - ans.length(); i++) {
            sb.append('0');
        }

        sb.append(ans);
        System.out.println(sb.toString());

        sc.close();
    }
}
