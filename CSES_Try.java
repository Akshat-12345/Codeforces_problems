
import java.io.*;
import java.util.*;

public class  CSES_Try{

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
        }

        public long getEle(int i, int s, int e, int k){
            if(s == e){
                return st[i];
            }
            
            int mid = (s+e)/2;
            if(k <= mid){
               return getEle(2*i+1, s, mid,k);
            }else{
                return getEle(2*i+2,mid+1,e,k);
            }
        }
        
        public void update(int i, int s, int e, int l, int r, int u){
            if(e < l || s > r){
                return;
            }else if(s >= l && e<= r && s == e){
                st[i] += u;
            }else{
                int mid = (s+e)/2;
                update(2*i+1, s, mid,l,r,u);
                update(2*i+2,mid+1,e,l,r,u);              
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
        
        
        SegmentTree s = new SegmentTree(arr, n);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            StringTokenizer sts = new StringTokenizer(br.readLine());
            
            int type = Integer.parseInt(sts.nextToken());
        
            if(type == 1) {
                int a = Integer.parseInt(sts.nextToken())-1;
                int b = Integer.parseInt(sts.nextToken())-1;
                int u = Integer.parseInt(sts.nextToken());
        
                // yahan handle karo update
                s.update(0,0, n-1, a, b, u);
            } 
            else {
                int k = Integer.parseInt(sts.nextToken())-1;
        
                // yahan handle karo query
                long ans = s.getEle(0, 0, n-1,k);
                sb.append(ans).append("\n"); 
            }
        }
        
        System.out.print(sb);

    }
}