import java.util.Scanner;

public class Books_279B {
    public static int solve(int target, int[] nums) {
        int n = nums.length;

        int windowStart = 0;
        int windowEnd = 0;
        int maxLen = Integer.MIN_VALUE;
        int currSum = 0;

        while(windowEnd < n){
           currSum += nums[windowEnd];

           if(currSum > target){
             while(currSum > target){
                currSum -= nums[windowStart];
                windowStart++;
             }
           }
           int len = windowEnd - windowStart + 1;
           maxLen = Math.max(maxLen,len);
           windowEnd++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        
        int [] arr = new int [n];
        for(int i = 0; i < n ; i++){
           arr[i] = sc.nextInt();
        }

        int len = solve(t,arr);

        System.out.println(len);
    }
}