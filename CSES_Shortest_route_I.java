import java.io.*;
import java.util.*;

public class CSES_Shortest_route_I {

    // -------- Fast Scanner --------
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

        long nextLong() throws IOException {
            int c;
            long sign = 1, val = 0;
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

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    // -------- Pair --------
    static class Pair {
        int to;
        long wt;
        Pair(int to, long wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    // -------- Dijkstra --------
    static long[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            long w = e[2];

            adj.get(u).add(new Pair(v, w)); // ✅ directed
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.wt));

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[src - 1] = 0;
        pq.add(new Pair(src - 1, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.to;
            long d = cur.wt;

            if (d > dist[node]) continue;

            for (Pair nxt : adj.get(node)) {
                if (dist[nxt.to] > d + nxt.wt) {
                    dist[nxt.to] = d + nxt.wt;
                    pq.add(new Pair(nxt.to, dist[nxt.to]));
                }
            }
        }

        return dist;
    }

    // -------- Main --------
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = fs.nextInt();
            edges[i][1] = fs.nextInt();
            edges[i][2] = fs.nextInt();
        }

        long[] ans = dijkstra(n, edges, 1);

        StringBuilder sb = new StringBuilder();
        for (long x : ans) {
            sb.append(x == Long.MAX_VALUE ? -1 : x).append(" ");
        }
        System.out.println(sb);
    }
}