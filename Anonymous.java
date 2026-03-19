import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Anonymous {

    static class Dsu{
        int parent [];
        int rank [];
        int component = 0;
        
        public Dsu(int n){
            parent = new int[n];
            rank = new int [n];
            component = n;

            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find (int x ){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x , int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY) return;

            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }else if(rank[parentX] < rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }   
            component--;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Dsu d = new Dsu(n);

        for(int i = 0 ; i < m ; i++){
            int u = arr[i][0]-1;
            int v = arr[i][1]-1;

            d.union(u,v);
        }

        System.out.println(d.component - 1);

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n ; i++){
           if(d.find(i) == i){
             ans.add(i + 1);
           }
        }

        for(int i = 0 ; i < ans.size() - 1 ; i++){
           System.out.println(ans.get(i) + " " + ans.get(i + 1));
        }
    }
}
