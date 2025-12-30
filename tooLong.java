import java.util.Scanner;

public class tooLong{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String [] arr = new String [n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextLine().toLowerCase();
        }
       
        for(int i = 0; i < n ; i++){
            String str = arr[i];
            int l = str.length();

            if(l > 10){
                String s = str.charAt(0) + "" + (str.length() - 2) + str.charAt(l -1);
                System.out.println(s);
            }else{
                System.out.println(str);
            }
        }

    }
}