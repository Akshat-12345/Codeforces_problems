public class union_by_rank {
    static class Dsu{
        int parent [];
        int rank [];

        public Dsu(int n){
            parent = new int[n];
            rank = new int[n];

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

            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;

            }else if(rank[parentX] < rank[parentY]){
                parent[parentX] = parentY;
                
            }else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            // if(parentX != parentY){
            //    parent[parentY] = parentX;
            // }         
        }
    }
}
