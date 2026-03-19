import java.io.*;
import java.util.*;

public class Building_Teams_CSES{

    // -------- FAST SCANNER --------
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;

            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
    // -------- FAST SCANNER END --------

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] team = new int[n + 1]; // 0 = unvisited, 1 or 2 = teams

        for (int i = 1; i <= n; i++) {
            if (team[i] == 0) {
                if (!bfs(i, adj, team)) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(team[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] team) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        team[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : adj.get(node)) {
                if (team[nei] == 0) {
                    team[nei] = 3 - team[node];
                    q.add(nei);
                } else if (team[nei] == team[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}