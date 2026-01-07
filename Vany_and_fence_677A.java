import java.util.Scanner;

public class Vany_and_fence_677A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();

        int [] arr = new int [n];

        for(int i = 0 ; i< n ; i++){
            arr[i] = sc.nextInt();
        }
        
        int count = 0;
        for(int i = 0 ; i< n ; i++){
            if(arr[i] > h){
                count++;
            }
        }

        int total = (arr.length - count) + count*2;

        System.out.println(total);
        sc.close();
    }
}
