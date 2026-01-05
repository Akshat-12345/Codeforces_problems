import java.util.Scanner;

public class matrixSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] arr = new int[5][5];

        for(int i = 0; i < 5 ; i++){
            for(int j = 0; j <5 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int row = 0, col = 0;

        for(int i = 0; i < 5 ; i++){
            for(int j = 0; j <5 ; j++){
                if(arr[i][j] == 1){
                    row = i;
                    col = j;
                }
            }
        }

        int rowSwap = Math.abs(row - 2);
        int colSwap = Math.abs(col - 2);

        int total = rowSwap + colSwap;
        
        System.out.println(total);
        sc.close();
    }
}
