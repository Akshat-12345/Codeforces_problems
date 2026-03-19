import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class monster {
    static class pair{
        int from;
        int to;
        public pair(int from,int to){
            this.from = from;
            this.to = to;
        }
    }

    static int [] rows = {-1,1,0,0};
    static int [] cols = {0,0,-1,1};

    public static int bfs(Queue<pair> q, boolean [][] vis, char [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        while(!q.isEmpty()){
            int size = q.size();
            max++;
            while(size > 0){
               pair curr = q.remove();
               for(int i = 0; i < 4 ;i++){
                  int row = curr.from + rows[i];
                  int col = curr.to + cols[i];

                  if(row >= 0 && row < n && col >= 0 && col < m && (grid[row][col] == '.' || grid[row][col] == '.' || grid[row][col] == 'M' )  && vis[row][col] == false){
                     q.add(new pair(row,col));
                     vis[row][col] = true;
                  }
               }
               size--;
            }
        }
        return max;

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char [][] grid = new char[n][m];

        for(int i = 0 ; i < n ; i++){
            String s = sc.next();
            for(int j = 0 ; j< m ; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        boolean [][] vis = new boolean[n][m];

        Queue<pair> q = new LinkedList<>();
        Queue<pair> q1 = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == 'M'){
                    q.add(new pair(i,j));
                }
            }
        }

        int monsterTime = bfs(q,vis,grid);

        boolean [][] vis1 = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == 'A'){
                    q1.add(new pair(i,j));
                    int playerTime = bfs(q1,vis1,grid);
                    break;
                }
            }
        }

        sc.close();
    }
}
