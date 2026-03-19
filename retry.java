import java.util.Scanner;

public class retry {
    static class SegmentTree{
        int [] st;
        int [] nums;

        public SegmentTree(int nums[], int n) {
            this.nums = nums;
            st = new int[4*n];
            buildTree(0,0,n-1);
        }

        public void buildTree(int i, int s , int e){
            if(s == e){
                if(nums[s] % 2 == 1){
                   st[i] = 1;
                }else{
                   st[i] = 0;
                }
                return;
            }            
            int mid = (s+e)/2;
            buildTree(2*i+1,s,mid);
            buildTree(2*i+2,mid+1,e);           
            st[i] = st[2*i+1] + st[2*i+2];
        }

        public int getOdd(int i, int s, int e, int l , int r){
            if(e < l || s > r){
                return 0;
            }else if( s >= l && e <= r){
                return st[i];
            }else{
                int mid = (s+e)/2;
                
                int li = getOdd(2*i+1, s, mid,l,r);
                int ri = getOdd(2*i+2,mid+1,e,l,r);
                
                return li + ri;
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

        int [][] query = new int[m][2];

        for(int i = 0 ; i < m ; i++){
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }

        int [][] ans = new int [m][2];
        SegmentTree s = new SegmentTree(arr, n);

        for(int i = 0; i < m ; i++){
           int l = query[i][0]- 1;
           int r = query[i][1]- 1;
           int total = r-l+1;
           ans[i][0] = s.getOdd(0, 0, n-1, l, r);
           ans[i][1] = total - ans[i][0];
        }
        
        System.out.println("O" + " " + "E");
        for(int i = 0; i < m ; i++){
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }

    }
}
