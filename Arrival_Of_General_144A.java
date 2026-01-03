import java.util.Scanner;

public class Arrival_Of_General_144A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int []arr = new int [n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        int maxPosition = 0;
        int minPosition = 0;

        for(int i = 0; i < n ; i++){
            if(arr[i] > maxElement){
                maxElement = arr[i];
                maxPosition = i;
            }

            if(arr[i] <= minElement){
                minElement = arr[i];
                minPosition = i;
            }
        }
        int total = 0;
        if(maxPosition > minPosition){
            total = (maxPosition - 0) + ((n - 1) - minPosition - 1);
        }else{
            total = (maxPosition - 0) + ((n - 1) - minPosition);
        }

        System.out.println(total);
        sc.close();

    }
}
