class Solution {
    public int solution(String my_string, String target) {
        return my_string.length() == my_string.replace(target, "").length() ? 0 : 1;
    }
}