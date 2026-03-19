
import java.io.*;
import java.util.*;
public class Road_Construction_CSES {

    static class Dsu{
        int parent [];
        int size [];
        int maxSize = 1;
        int component = 0;
        public Dsu(int n){
            parent = new int[n];
            size = new int [n];

            for(int i = 0; i < n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
            component = n;
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

            if(parentX != parentY){
               parent[parentY] = parentX;
               size[parentX] = size[parentX] + size[parentY];

               maxSize = Math.max(maxSize,size[parentX]);
               component--;
            }         
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

        // for(int i = 0; i < m ; i++){
        //     int u = arr[i][0] - 1;
        //     int v = arr[i][1] - 1;

        //     d.union(u, v);
        //     System.out.print(d.component + " ");
        //     System.out.println(d.maxSize);

        // }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m ; i++){
            int u = arr[i][0] - 1;
            int v = arr[i][1] - 1;
        
            d.union(u, v);
            sb.append(d.component).append(" ").append(d.maxSize).append("\n");
        }
        
        System.out.print(sb);
        
    }
}
