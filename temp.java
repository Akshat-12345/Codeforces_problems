import java.io.*;
import java.util.*;

public class temp {

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

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ');

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    // -------- GRAPH CLASSES --------
    static class Edge {
        int to;
        long wt;

        Edge(int to, long wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    static class State {
        int node;
        int used;   // 0 = discount not used, 1 = used
        long dist;

        State(int node, int used, long dist) {
            this.node = node;
            this.used = used;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            long w = fs.nextLong();
            adj.get(u).add(new Edge(v, w));
        }

        long INF = (long) 1e18;
        long[][] dist = new long[n + 1][2];

        for (int i = 1; i <= n; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.dist, b.dist)
        );

        dist[1][0] = 0;
        pq.add(new State(1, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            int used = cur.used;
            long d = cur.dist;

            if (d > dist[u][used]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.to;
                long w = e.wt;

                // Normal edge
                if (dist[v][used] > d + w) {
                    dist[v][used] = d + w;
                    pq.add(new State(v, used, dist[v][used]));
                }

                // Discount edge
                if (used == 0) {
                    long discounted = d + w / 2;
                    if (dist[v][1] > discounted) {
                        dist[v][1] = discounted;
                        pq.add(new State(v, 1, dist[v][1]));
                    }
                }
            }
        }

        System.out.println(dist[n][1]);
    }
}