import java.util.;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        PriorityQueuePair pq_d = new PriorityQueuePair(
            new ComparatorPair(){
                public int compare(Pair p1, Pair p2){
                    return Integer.compare(p2.d, p1.d);
                }
            }
        );
        PriorityQueuePair pq_p = new PriorityQueuePair(
            new ComparatorPair(){
                public int compare(Pair p1, Pair p2){
                    return Integer.compare(p2.d, p1.d);
                }
            }
        );
        
        for(int i = 0; i  n; i++){
            if(deliveries[i] != 0){
                pq_d.add(new Pair(i + 1, deliveries[i]));
            }
            if(pickups[i] != 0){
                pq_p.add(new Pair(i + 1, pickups[i]));
            }
        }
        
        while(!pq_d.isEmpty()  !pq_p.isEmpty()){
            int d = 0;
            int c = 0;
            
            while(!pq_d.isEmpty() && c  cap){
                Pair tmp = pq_d.poll();
                if(d  tmp.d){
                    d = tmp.d;
                }
                if(c + tmp.c  cap){
                    pq_d.add(new Pair(tmp.d, (c + tmp.c) - cap));
                    c = cap;
                } else{
                    c += tmp.c;
                }
            }
            
            c = 0;
            while(!pq_p.isEmpty() && c  cap){
                Pair tmp = pq_p.poll();
                if(d  tmp.d){
                    d += tmp.d - d;
                }
                if(c + tmp.c  cap){
                    pq_p.add(new Pair(tmp.d, (c + tmp.c) - cap));
                    c = cap;
                } else{
                    c += tmp.c;
                }
            }
            
            answer += d  2;
        }
        return answer;
    }
    
    public class Pair{ 
        int d;
        int c;
        public Pair(int d, int c){
            this.d = d;
            this.c = c;
        }
    }
}
