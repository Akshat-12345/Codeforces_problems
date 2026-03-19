import java.io.*;
import java.util.*;

public class Dynamic_Range_Sum_Query_CSES {

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
            int mid = (s+e) >> 1;
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
                int mid = (s+e) >> 1;
                
                long li = getSum(2*i+1, s, mid,l,r);
                long ri = getSum(2*i+2,mid+1,e,l,r);
                
                return li + ri;
            }
        }

        public void update(int i , int s, int e , int idx , long val){
            if(s == e){
                st[i] = val;
                return;
            }
            
            int mid = (s+e)/2;
            if(idx <= mid){
                update(2*i+1, s, mid, idx, val);
            }else{
                update(2*i+2, mid+1, e, idx, val);
            }

            st[i] = st[2*i+1] + st[2*i+2];
        }
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        
        SegmentTree s = new SegmentTree(arr, n);
        StringBuilder sb = new StringBuilder();
 
        for(int i = 0; i < m; i++) {
            StringTokenizer sts = new StringTokenizer(br.readLine());
            
            int type = Integer.parseInt(sts.nextToken());
        
            if(type == 1) {
                int k = Integer.parseInt(sts.nextToken())-1;
                long u = Long.parseLong(sts.nextToken());
        
                // yahan handle karo update
                s.update(0,0, n-1, k, u);
            } 
            else {
                int a = Integer.parseInt(sts.nextToken())-1;
                int b = Integer.parseInt(sts.nextToken())-1;
                // yahan handle karo query
                long ans = s.getSum(0, 0, n-1,a,b);
                sb.append(ans).append("\n"); 
            }
        }
        System.out.print(sb.toString());
    }
}