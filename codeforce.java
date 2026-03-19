import java.util.Scanner;

public class codeforce {
    static class pair{
        int num;
        int freq;
        public pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }

    static class SegmentTree{
        pair [] st;
        int [] nums;

        public SegmentTree(int nums[], int n) {
            this.nums = nums;
            st = new pair[4*n];
            buildTree(0,0,n-1);
        }

        public void buildTree(int i, int s , int e){
            if(s == e){
                st[i] = new pair(nums[s], 1);
                return;
            }            
            int mid = (s+e)/2;
            buildTree(2*i+1,s,mid);
            buildTree(2*i+2,mid+1,e);           
            
            pair left = st[2*i + 1];
            pair right = st[2*i + 2];

            if(left.num == right.num){
                st[i] = new pair(left.num, left.freq + right.freq);
            }else if( left.num < right.num){
                st[i] = new pair(left.num, left.freq);
            }else{
                st[i] = new pair(right.num, right.freq);
            }
        }
        
        public void update(int i, int s, int e, int idx, int val){
            if(s == e){
                st[i] = new pair(val, 1);
                return;
            }

            int mid = (s+e)/2;
            if(idx <= mid){
                update(2*i+1, s, mid, idx, val);
            }else{
                update(2*i+2, mid+1, e, idx, val);
            }

            pair left = st[2*i + 1];
            pair right = st[2*i + 2];

            if(left.num == right.num){
                st[i] = new pair(left.num, left.freq + right.freq);
            }else if( left.num < right.num){
                st[i] = new pair(left.num, left.freq);
            }else{
                st[i] = new pair(right.num, right.freq);
            }
        }

        public pair getPair(int i, int s, int e, int l , int r){
            if(e < l || s > r){
                return new pair(Integer.MAX_VALUE, 0);
            }else if( s >= l && e <= r){
                return st[i];
            }else{
                int mid = (s+e)/2;
                
                pair left = getPair(2*i+1, s, mid, l, r);
                pair right = getPair(2*i+2, mid+1, e,l,r);
                if(left.num == Integer.MAX_VALUE) return right;
                if(right.num == Integer.MAX_VALUE) return left;
                if(left.num == right.num){
                    return new pair(left.num, left.freq + right.freq);
                }else if( left.num < right.num){
                    return new pair(left.num, left.freq);
                }else{
                    return new pair(right.num, right.freq);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int [][] query = new int[m][3];

        for(int i = 0 ; i < m ; i++){
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
            query[i][2] = sc.nextInt();
        }

        SegmentTree s = new SegmentTree(arr, n);

        for(int i = 0 ; i < m ; i++){
            int type = query[i][0];

            if(type == 1){
                int idx = query[i][1];
                int val = query[i][2];
                s.update(0, 0, n-1, idx, val);
            }else if(type == 2){
                int l = query[i][1];
                int r = query[i][2]-1;
                pair ans = s.getPair(0, 0, n-1, l, r);
                System.out.println(ans.num + " " + ans.freq);
            }
        }
        
    }
}
