class Solution {
    public int[] solution(int n) {
        int arrLen = (n+1)/2;
        int[] answer = new int[arrLen];
        
        for (int i=1; i<arrLen+1; i++) {
            answer[i-1] = 2*i - 1;
        }
        
        return answer;
    }
}