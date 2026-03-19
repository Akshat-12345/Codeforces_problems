import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class counting_island_CSES {
    static class pair{
        int from ;
        int to ;
        public pair(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    

    public static void bfs(int i , int j , char [][] grid, boolean [][] vis){
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));

        vis[i][j] = true;

        while(!q.isEmpty()){
            pair curr = q.remove();
            int row = curr.from;
            int col = curr.to;
            
            if(row - 1 >= 0 && row-1< n && col >= 0 && col < m && grid[row-1][col] == '.' && vis[row-1][col] == false){
                q.add(new pair(row-1,col));
                vis[row-1][col] = true;
            }
            
            if(row + 1 >= 0 && row + 1< n && col >= 0 && col < m && grid[row+1][col] == '.' && vis[row+1][col] == false){
                q.add(new pair(row+1,col));
                vis[row+1][col] = true;
            }
            
            if(row >= 0 && row< n && col-1 >= 0 && col < m && grid[row][col-1] == '.' && vis[row][col-1] == false){
                q.add(new pair(row,col-1));
                vis[row][col-1] = true;
            }
            
            if(row >= 0 && row < n && col+1 >= 0 && col+1 < m && grid[row][col+1] == '.' && vis[row][col+1] == false){
                q.add(new pair(row,col+1));
                vis[row][col+1] = true;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean [][] vis = new boolean[n][m];

        int count = 0;

        for(int i = 0 ; i< n ; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '.' && vis[i][j] == false){
                    count++;
                    bfs(i,j,board,vis);
                }
            }
        }

        System.out.println(count);


    }
}
