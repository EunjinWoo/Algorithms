class Solution {
    public int[] solution(int[] num_list) {
        int oddCount = 0;
        int evenCount = 0;
        int[] answer = new int[2];
        
        for (int num : num_list) {
            if(num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        answer[0] = evenCount;
        answer[1] = oddCount;
        
        return answer;
    }
}