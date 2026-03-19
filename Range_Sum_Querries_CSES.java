import java.io.*;
import java.util.*;

public class Range_Sum_Querries_CSES {

    static class SegmentTree{
        long [] st;
        long [] nums;

        public SegmentTree(long nums[], int n) {
            this.nums = nums;
            st = new long[4*n];
            buildTree(0,0,n-1);
        }

        public void buildTree(int i, int s , int e){
            if(s == e){
                st[i] = nums[s];
                return;
            }            
            int mid = (s+e)/2;
            buildTree(2*i+1,s,mid);
            buildTree(2*i+2,mid+1,e);           
            st[i] = st[2*i+1] + st[2*i+2];
        }

        public long getSum(int i, int s, int e, int l , int r){
            if(e < l || s > r){
                return 0;
            }else if( s >= l && e <= r){
                return st[i];
            }else{
                int mid = (s+e)/2;
                
                long li = getSum(2*i+1, s, mid,l,r);
                long ri = getSum(2*i+2,mid+1,e,l,r);
                
                return li + ri;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // n aur m same line me
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // array input (same line)
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        // queries
        int[][] queries = new int[m][2];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }
        
        SegmentTree s = new SegmentTree(arr, n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            int l = queries[i][0]-1;
            int r = queries[i][1]-1;
            
            long ans = s.getSum(0, 0, n-1, l, r);
            sb.append(ans).append("\n"); 
        }
        System.out.print(sb);

    }
}