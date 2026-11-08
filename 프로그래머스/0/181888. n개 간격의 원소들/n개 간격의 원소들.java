class Solution {
    public int[] solution(int[] num_list, int n) {
        int ansLength = num_list.length%n==0 ? num_list.length/n : num_list.length/n + 1;
        int[] answer = new int[ansLength];
        
        for (int i=0; i<ansLength ; i++) {
            answer[i] = num_list[n*i];
        }
        
        return answer;
    }
}