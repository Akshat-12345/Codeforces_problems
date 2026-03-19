import java.io.*;
import java.util.*;

public class Building_Roads_CSES {

    // ---------- FAST SCANNER ----------
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
    // ----------------------------------

    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] vis;

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neigh : adj.get(node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new boolean[n + 1];
        ArrayList<Integer> reps = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                reps.add(i);
                bfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(reps.size() - 1).append('\n');
        for (int i = 1; i < reps.size(); i++) {
            sb.append(reps.get(i - 1)).append(" ").append(reps.get(i)).append('\n');
        }
        System.out.print(sb.toString());
    }
}