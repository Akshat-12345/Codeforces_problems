import java.util.*;
public class Bakery {
    class pair{
        int to;
        int wt;
        public pair(int to, int wt){
            this.to = to;
            this.wt = wt;
        }
    }

    public static int bfs (int i , ArrayList<ArrayList<pair>> adj, int [] vis){
        int n = adj.size();

        int[] dist = new int[adj.size()];
        Arrays.fill(dist, -1);

        Queue<pair> q = new LinkedList<>();

        for(int j = 0; j < n; j++){
            if(vis[j] == 1){
                q.add(j);
                dist[j] = 0; 
            }
        }


        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        int [][] arr = new int [m][3];
        for(int i = 0; i < m ; i++){
           arr[i][0] = sc.nextInt();
           arr[i][1] = sc.nextInt();
           arr[i][2] = sc.nextInt();
        }

        int [] storage = new int[k];
        
        for(int i = 0; i < m ; i++){
           storage[i] = sc.nextInt();        
        }
        
        ArrayList<ArrayList<pair>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){   // 0 1 10
            int from = arr[i][0];
            int to = arr[i][1];
            int weight = arr[i][2];

            pair curr = new pair(to,weight);
            pair curr1 = new pair(from,weight);

            adjList.get(from).add(curr);
            adjList.get(to).add(curr1);

        }

        int [] vis = new int[n];
        int s = bfs(0,adjList,vis);

        System.out.println(s);
        sc.close();
    }
}
