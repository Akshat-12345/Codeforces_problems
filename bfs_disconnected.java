import java.util.*;
class bfs_disconnected {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        int n = adj.size();
        boolean [] visited = new boolean[n];
        
        for(int i = 0; i < n ; i++){
            if(!visited[i]){
                solve(i,adj,arr,visited);
            }
        }
        
        return arr;
    }
    
    public void solve(int start, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> arr, boolean [] visited){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;
        arr.add(start);
        
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

    }
}