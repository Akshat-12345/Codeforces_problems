import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubArray_Sum_CSES_II {
    public static long solve(int x, int [] nums){
        HashMap<Long,Long> map = new HashMap<>();
        long n = nums.length;
        long currSum = 0L;
        long count = 0L;
        map.put(0L,1L);

        for(int i = 0; i< n ; i++){
            currSum += nums[i];
            long req = currSum - x;
            if(map.containsKey(req)){
                count += map.get(req);
            }
            map.put(currSum,map.getOrDefault(currSum, 0L)+1);
        }

        return count;
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = solve(x, arr);
        System.out.println(ans);
    }
}
