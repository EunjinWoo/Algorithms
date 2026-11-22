class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (String str : str_list) {
            if (str.length() != str.replace(ex, "").length()) continue;
            answer += str;
        }
        
        return answer;
    }
}