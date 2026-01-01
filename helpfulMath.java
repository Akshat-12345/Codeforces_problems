import java.util.*;
public class helpfulMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] arr = s.split("\\+");
        int [] nums = new int [arr.length];
        for(int i = 0 ; i < arr.length ; i++){
             nums[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(nums);

        String str = String.valueOf(nums[0]);

        for(int i = 1 ; i < arr.length ; i++){
             str = str +"+" + String.valueOf(nums[i]);
        }

        System.out.println(str);
    }
}
