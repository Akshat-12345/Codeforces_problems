import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubArray_Sum_I_CSES {

    public static int solve(int target, int[] nums) {
        int n = nums.length;

        int windowStart = 0;
        int windowEnd = 0;
        int currSum = 0;
        int count = 0;

        while (windowEnd < n) {
            currSum += nums[windowEnd];

            if (currSum == target) {
                count++;
            }

            if (currSum >= target) {
                while (currSum >= target) {
                    currSum -= nums[windowStart];
                    if (currSum == target) {
                        count++;
                    }
                    windowStart++;
                }
            }
            windowEnd++;
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

        int ans = solve(x, arr);
        System.out.println(ans);
    }
}
