import java.util.Scanner;

public class Queue_in_the_school {
    public static void solve(char[] arr, int t) {
    int n = arr.length;

    while (t > 0) {

        
        char[] arr1 = arr.clone();

        for (int i = 0; i < n - 1; i++) {
            if (arr1[i] == 'B' && arr1[i + 1] == 'G') {
                
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i++;
            }
        }
        t--;
    }
}

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        s = s.toUpperCase();

        char [] arr = new char[n];
        for(int i = 0; i< n ; i++){
            arr[i] = s.charAt(i);
        }

        solve(arr,t);

        System.out.println(arr);
    }
}
