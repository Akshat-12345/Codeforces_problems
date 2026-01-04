import java.util.Scanner;

public class Magnets_344A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String [] arr = new String[n];

        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextLine();
        }
        
        int group = 1;

        for(int i = 1; i < n ; i++){
            char last = arr[i].charAt(1);
            char prev = arr[i-1].charAt(1);

            if(prev != last){
                group++;
            }
        }

        System.out.println(group);

        sc.close();
    }
}
