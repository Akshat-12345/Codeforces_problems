import java.util.Scanner;

public class wordManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        if(s.length()>0){
             char first = Character.toUpperCase(s.charAt(0));
             String str = first + "" + s.substring(1);
             System.out.println(str);
        }

        sc.close();
        

    }
}
