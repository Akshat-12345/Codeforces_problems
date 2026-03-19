import java.io.*;
import java.util.*;

public class Range_Update_Query_CSES {

    static class SegmentTree {
        long[] lazy;

        public SegmentTree(int n) {
            lazy = new long[4 * n];
        }

        public void update(int i, int s, int e, int l, int r, int val) {

            if (s > r || e < l) return;

            if (s >= l && e <= r) {
                lazy[i] += val;
                return;
            }

            int mid = (s + e) >> 1;
            update(2 * i + 1, s, mid, l, r, val);
            update(2 * i + 2, mid + 1, e, l, r, val);
        }

        public long query(int i, int s, int e, int idx) {

            if (s == e) {
                return lazy[i];
            }

            int mid = (s + e) >> 1;

            if (idx <= mid) {
                return lazy[i] + query(2 * i + 1, s, mid, idx);
            } else {
                return lazy[i] + query(2 * i + 2, mid + 1, e, idx);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        SegmentTree seg = new SegmentTree(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            StringTokenizer sts = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(sts.nextToken());

            if (type == 1) {
                int l = Integer.parseInt(sts.nextToken()) - 1;
                int r = Integer.parseInt(sts.nextToken()) - 1;
                int u = Integer.parseInt(sts.nextToken());

                seg.update(0, 0, n - 1, l, r, u);

            } else {
                int k = Integer.parseInt(sts.nextToken()) - 1;

                long ans = arr[k] + seg.query(0, 0, n - 1, k);
                sb.append(ans).append("\n");
            }
        }

        System.out.print(sb);
    }
}
