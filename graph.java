import java.util.ArrayList;
import java.util.Scanner;

public class graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        // int [][] adj = new int[n][n];

        // for(int i = 0; i<e ; i++){
        //     int from = sc.nextInt();
        //     int to = sc.nextInt();
        //     int weight = sc.nextInt();

        //     adj[from][to] = weight;
        // }

        // for(int i = 0 ; i< n ; i++){
        //     for(int j = 0; j < n ; j++){
        //         System.out.println(adj[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0 ; i< n; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 0 ; i< e ; i++){
            int from  = sc.nextInt();
            int to = sc.nextInt();

            arr.get(from).add(to);
            arr.get(to).add(from);
        }

    }
}
