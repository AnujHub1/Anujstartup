import java.text.Collator;
import java.util.*;

public class ChocalProblem {
    public static void main(String[] args) {
        int n=4,m=6;
        Integer costver[] = { 2, 1, 3, 1, 4 };;
        Integer costHor[] = { 4, 1, 2};
        Arrays.sort(costver, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0;
        int v=0;
        int hp=1,vp=1;
        int cost =0;
        while (h<costHor.length && v<costver.length){
            if(costver[v]<=costHor[h]){
                cost += (costHor[h]*vp);
                hp++;
                h++;
            }else{
                cost +=(costver[v]*hp);
                vp++;
                v++;
            }
        }
        while (h<costHor.length){
            cost += (costHor[h]*vp);
            hp++;
            h++;
        }
        while (v<costver.length){
            cost += (costver[v]*hp);
            vp++;
            v++;
        }

        System.out.println(cost);
    }
}
