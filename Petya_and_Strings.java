import java.util.Scanner;

public class Petya_and_Strings {
    public static int check(String s1, String s2){

        int n = s1.length();

        for(int i = 0 ; i < n ; i++){
            char a1 = s1.charAt(i);
            char a2 = s2.charAt(i);
            if( a1 != a2){
               if(a1 > a2){
                  return 1;
               }else{
                  return -1;
               }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int n = s1.length();

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int m = check(s1, s2);

        System.out.println(m);

    }
}
