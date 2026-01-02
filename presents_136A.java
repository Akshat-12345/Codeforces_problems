import java.util.*;


public class presents_136A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int [] arr = new int [n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        HashMap <Integer,Integer> map = new HashMap<>();
        
        for(int i = 1 ; i <= n ; i++){
            map.put(arr[i-1] , i);
        }

        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = map.get(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
