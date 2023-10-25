import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] t = new int[26];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        StringTokenizer st;
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i]);
            int type = st.nextToken().charAt(0) - 'A';
            int month = Integer.parseInt(st.nextToken());
            t[type] = month;
        }
        
        st = new StringTokenizer(today, ".");
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String p = st.nextToken();
            int type = st.nextToken().charAt(0) - 'A';
            
            st = new StringTokenizer(p, ".");
            int tmpy = Integer.parseInt(st.nextToken());
            int tmpm = Integer.parseInt(st.nextToken());
            int tmpd = Integer.parseInt(st.nextToken());
            
            if(tmpm + t[type] > 12){
                tmpy += (tmpm + t[type]) / 12;
                tmpm = (tmpm + t[type]) % 12;
            }
            else {
                tmpm += t[type];
            }
            
            tmpd--;
            if(tmpd < 1){
                tmpm--;
                tmpd = 28;
            }
            if(tmpm < 1){
                tmpy--;
                tmpm = 12;
            }
            
            if(tmpy < y || (tmpy == y && tmpm < m) || (tmpy == y && tmpm == m && tmpd < d)){
                ans.add(i);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i) + 1;
        }
        return answer;
    }
    
    public class date {
        int y;
        int m;
        int d;
        public date(int y, int m, int d){
            this.y = y;
            this.m = m;
            this.d = d;
        }
    }
}