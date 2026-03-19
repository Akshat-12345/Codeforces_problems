import java.util.PriorityQueue;
import java.util.Scanner;

public class Hack_With_Infy_Food_Stamps {
    static class pair{
        long val;
        int idx;
        int freq;
        public pair(long val, int idx, int freq){
            this.val = val;
            this.idx = idx;
            this.freq = freq;
        }
    }
    public static long solve(int n , int m , long [] arr, long [] d){
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Long.compare(b.val, a.val));

        for(int i = 0 ; i < n ; i++){
            pq.add(new pair(arr[i], i, 1));
        }

        long ans = 0;

        for(int i = 0 ; i < m  ;i++){
            pair curr = pq.poll();

            if(curr.val <= 0){
                break;
            }

            ans += curr.val;

            int count = curr.freq + 1;
            int idx = curr.idx;
            long value = curr.val - d[idx];

            pq.add(new pair(value, idx, count));
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long [] arr = new long [n];
        long [] d = new long[n];

        for(int i = 0 ; i< n ; i++){
            arr[i] = sc.nextLong();
        }

        for(int i = 0; i < n ;i++){
            d[i] = sc.nextLong();
        }

        long ans = solve(n,m,arr,d);
        System.out.println(ans);
    }
}