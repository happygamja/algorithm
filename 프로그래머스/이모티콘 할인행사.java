class Solution {
    int ans_b = 0;
    int ans_a = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        per(users, emoticons, emoticons.length, new int[emoticons.length], 0);
        int[] answer = {ans_b, ans_a};
        return answer;
    }
    
    public  void per(int[][] u, int[] e, int n, int[] bucket, int idx){
        if(idx == n){
            int buyer = 0;
            int amt = 0;
            for(int i = 0; i < u.length; i++){
                int tmp = 0;
                for(int j = 0; j < n; j++){
                    if(u[i][0] <= bucket[j]){                    
                        tmp += e[j] - (e[j] * ((double)bucket[j] / 100));
                    }
                }
                if(tmp >= u[i][1]){
                    buyer++;
                } else{
                    amt += tmp;
                }
            }
            if(ans_b < buyer){
                ans_b = buyer;
                ans_a = amt;
            } else {
                if(ans_b == buyer && ans_a < amt) {
                    ans_a = amt;
                }
            }
            return;
        }
        for(int i = 10; i <= 40; i += 10){
            bucket[idx] = i;
            per(u, e, n, bucket, idx + 1);
        }
    }
}