import java.util.HashMap;
import java.util.Scanner;

public class Build_The_Contest {
    // public static String solve(int n, int[] nums) {
    //     int m = nums.length;

    //     HashSet<Integer> set = new HashSet<>();
    //     HashSet<Integer> set1 = new HashSet<>();

    //     for(int i = 1 ; i <= n ;i++){
    //         set.add(i);
    //     }
        
    //     StringBuilder sb = new StringBuilder("");

    //     int windowEnd = 0;

    //     while(windowEnd < m){
    //        set1.add(nums[windowEnd]);

    //        if( set1.size() == n){              // set1.equals(set)
    //          sb.append(1);
    //          set1.clear();
    //        }else{
    //          sb.append(0);
    //        }

    //        windowEnd++;
    //     }

    //     return sb.toString();
    // }

    public static String solve(int n, int[] nums) {
        int m = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();    
        StringBuilder sb = new StringBuilder("");
        
        // int i = 0;
        // while(map.size() != n - 1 && i < m){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     sb.append(0);
        //     i++;
        // }
        // sb.append(1);

        int windowEnd = 0;

        while(windowEnd < m){
          map.put(nums[windowEnd],map.getOrDefault(nums[windowEnd],0)+1);
          if(map.size() == n){
             sb.append(1);
             for(int x = 1 ; x <= n ; x++){     //int x : map.keySet()  technical error dega clash hoga
                if(map.get(x)== 1){
                    map.remove(x);
                }else{
                    map.put(x,map.get(x)-1);
                }
             }
           }else{
             sb.append(0);
           }

           windowEnd++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int [] arr = new int [m];
        for(int i = 0; i < m ; i++){
           arr[i] = sc.nextInt();
        }

        String s = solve(n,arr);

        System.out.println(s);
    }
}
