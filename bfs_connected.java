import java.util.*;
class bfs_connected {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        int n = adj.size();
        
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0] = true;
        arr.add(0);
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int i : adj.get(node)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    arr.add(i);
                }
            }
        }
        
        return arr;
    }
}