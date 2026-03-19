public class dsu {
    static class Dsu{
        int parent [];
        public Dsu(int n){
            parent = new int[n];
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

            if(parentX != parentY){
               parent[y] = x;
            }         
        }
    }
}
