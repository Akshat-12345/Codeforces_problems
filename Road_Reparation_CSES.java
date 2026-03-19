// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.Scanner;

// public class main {
//     static class pair {
//         int to;
//         int wt;
//         public pair (int to, int wt){
//             this.to = to;
//             this.wt = wt;
//         }
//     }

//     public static long solve(int n , int [][] arr){
//         long minCost = 0;

//         ArrayList<ArrayList<pair>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int[] e : arr) {
//             int u = e[0]-1;
//             int v = e[1]-1;
//             int w = e[2];
//             adj.get(u).add(new pair(v, w));
//             adj.get(v).add(new pair(u, w));
//         }

//         boolean[] visited = new boolean[n];

//         PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);

//         pq.add(new pair(0, 0));

//         while(!pq.isEmpty()){
//             pair curr = pq.poll();
//             int currNode = curr.to;
//             int currVal = curr.wt;

//             if(visited[currNode]){
//                 continue;
//             }

//             visited[currNode] = true;
//             minCost += currVal;

//             for(int i = 0 ; i < adj.get(currNode).size() ; i++){
//                   pair x = adj.get(currNode).get(i);
//                   if(!visited[x.to]){
//                     pq.add(new pair(x.to,x.wt));
//                   }
//             }

            
//         }
         
//         for(int i = 0 ; i < n ; i++){
//             if(!visited[i]){
//                 return Long.MAX_VALUE;
//             }
//         }
//         return minCost;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         int [][] arr = new int [m][3];

//         for(int i = 0 ; i < m ; i++){
//             arr[i][0] = sc.nextInt();
//             arr[i][1] = sc.nextInt();
//             arr[i][2] = sc.nextInt();
//         }

//         long ans = solve(n,arr);

//         if(ans == Long.MAX_VALUE){
//             System.out.println("IMPOSSIBLE");
//         }else{
//             System.out.println(ans);
//         }
//     }
// }



import java.io.*;
import java.util.*;

public class Road_Reparation_CSES {
    static class pair {
        int to;
        int wt;

        public pair(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    public static long solve(int n, int[][] arr) {
        long minCost = 0;

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : arr) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            int w = e[2];

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.add(new pair(0, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int currNode = curr.to;
            int currVal = curr.wt;

            if (visited[currNode]) continue;

            visited[currNode] = true;
            minCost += currVal;

            for (pair x : adj.get(currNode)) {
                if (!visited[x.to]) {
                    pq.add(new pair(x.to, x.wt));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return Long.MAX_VALUE;
            }
        }

        return minCost;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        long ans = solve(n, arr);

        if (ans == Long.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }
    }
}