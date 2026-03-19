import java.util.ArrayList;
import java.util.Scanner;

public class Undirected_Weighted_Graph {

    static class Pair{
        int to;
        int weight;
        public Pair(int to, int weight){
            this.to = to;
            this.weight = weight;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){   // 0 1 10
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            Pair curr = new Pair(to,weight);
            

            Pair curr1 = new Pair(from,weight);

            adjList.get(from).add(curr);
            adjList.get(to).add(curr1);

        }
        

        

        sc.close();
    }
}