import java.util.Scanner;

public class HQ_133A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == 'H'){
                 flag = true;
                 break;
            }
            if(s.charAt(i) == 'Q'){
                 flag = true;
                 break;
            }
            if(s.charAt(i) == '9'){
                 flag = true;
                 break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        sc.close();
    }
}
