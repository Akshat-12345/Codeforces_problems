
import java.util.*;

public class Serja_And_Dima_381A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> pq = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            pq.addLast(sc.nextInt());
        }
        
        int serja = 0;
        int dima = 0;
        boolean flag = true;

        for(int i = 0; i < n ; i++){
            int taken = 0;
            if(pq.peekFirst() > pq.peekLast()){
                taken = pq.removeFirst();
            }else{
                taken = pq.removeLast();
            }

            if(flag){
                serja += taken;
            }else{
                dima += taken;
            }
            flag = !flag;
        }
        
        System.out.println(serja);
        System.out.println(dima);

        sc.close();
    }
}