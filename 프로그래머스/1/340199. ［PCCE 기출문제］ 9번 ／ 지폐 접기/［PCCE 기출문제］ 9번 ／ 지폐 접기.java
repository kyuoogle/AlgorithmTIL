class Solution {
    public int solution(int[] wallet, int[] bill) {
        int ans = 0;
        // 지갑의 큰 쪽 작은 쪽 구분
        int maxWallet = Math.max(wallet[0], wallet[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);
        
        while(Math.min(bill[0], bill[1]) > minWallet || Math.max(bill[0], bill[1]) > maxWallet) {
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }
            ans++;
        }
        
        return ans;
    }
}