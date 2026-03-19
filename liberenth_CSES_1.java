import java.io.*;
import java.util.*;

public class liberenth_CSES_1 {

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = fs.next().toCharArray();
        }

        boolean[][] vis = new boolean[n][m];
        char[][] parent = new char[n][m];

        int sx = 0, sy = 0, ex = 0, ey = 0;

        // Find A and B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    sx = i; sy = j;
                }
                if (grid[i][j] == 'B') {
                    ex = i; ey = j;
                }
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sx, sy));
        vis[sx][sy] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] dir = {'U', 'D', 'L', 'R'};

        // BFS
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (vis[nx][ny] || grid[nx][ny] == '#') continue;

                vis[nx][ny] = true;
                parent[nx][ny] = dir[i];
                q.add(new Pair(nx, ny));
            }
        }

        // If B not reachable
        if (!vis[ex][ey]) {
            System.out.println("NO");
            return;
        }

        // Reconstruct path
        StringBuilder path = new StringBuilder();
        int x = ex, y = ey;

        while (x != sx || y != sy) {
            char c = parent[x][y];
            path.append(c);

            if (c == 'U') x++;
            else if (c == 'D') x--;
            else if (c == 'L') y++;
            else if (c == 'R') y--;
        }

        path.reverse();

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }

    // Fast Input
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}