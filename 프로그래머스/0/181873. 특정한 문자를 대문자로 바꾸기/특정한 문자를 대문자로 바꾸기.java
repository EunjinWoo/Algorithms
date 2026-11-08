class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        for (int i=0; i<my_string.length(); i++) {
            answer += String.valueOf(my_string.charAt(i)).equals(alp) 
                ? alp.toUpperCase()
                : String.valueOf(my_string.charAt(i));
        }
        
        return answer;
    }
}