class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int arrlen = num2 - num1 + 1;
        int[] answer = new int[arrlen];
        for (int i = 0; i < arrlen ; i++) {
            answer[i] = numbers[i +  num1];
        }
        return answer;
    }
}