import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
 
 
 
public class Solution {
 
    public static void name(String[][] relation) {
 
        List<Integer> list = new LinkedList<>();
        int row = relation.length;
        int col = relation[0].length;
 
        /*****************
         * 연관된 조합 찾기 for Sort
         * ex)
         * 
         *  A        B         C          AB     BC         CA         ABC
         * 001     010     100      011     110     101     111
         *  1        2        3         2          3       3       3
         *  A와 연관 1, B와 2 C와 연관 3
         *****************/
        FuncPrioity pri = (x) ->{
            int ret = 0;
                while(x != 0) {
                    if((x & 1) == 1) {
                        ret++;
                        x = x >> 1;
                    }
                }
            return ret;
        };
        
        /*****************
         *  후보키 찾기
         *         
         *  튜플을 모두 비교한다. (like 서로 번갈아 악수하는 경우)
         *  
         *****************/
        FuncCandidate rda = (r,c,comb) ->{
 
            for(int i = 0; i < r-1 ; i++) {
                for(int j = i+1; j < r ; j++) {
                        boolean isSame = true;
 
                    for(int k = 0; k < c ;k ++) {
 
                        if((comb & 1 << k) == 0) continue;
                        if(!relation[i][k].equals(relation[j][k])) {
                            isSame = false;
                            break;
                        }
                    }
                    
                    if(isSame) return false; // 같으므로 후보키 아님
                }
            }
            return true;
        };
 
 
        IntStream
            .range(1, 1<<col)
            .forEach(i->{
 
                if(rda.isCandidate(row, col, i)) {
                    list.add(i);
                }
        });        
 
        list.stream()
            .sorted((x,y)->{ 
                int prix = pri.prio(x);
                int priy = pri.prio(y);
 
                if(prix > priy) {
                    return 1;
 
                }else if(priy < priy) {
 
                    return -1;
                }else {
 
                    return 0;
                }
            });
 
        int ans = 0;
        while(!list.isEmpty()) {
        
            int first = list.remove(0);
            ans ++;
 
            list.removeIf(i->(first & i)==first);
        } // 유일성을 위해서 조합이 만들어질경우 제거한다.      
        System.out.println(ans);
    }
}
 
 
 
@FunctionalInterface
interface FuncCandidate{
    boolean isCandidate(int row,int col, int combi);
}
 
@FunctionalInterface
interface FuncPrioity{
    int prio(int x);
}
 