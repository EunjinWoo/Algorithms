import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        
        String[] answer = new String[tickets.length + 1];
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        answer[0] = "ICN";
        dfs("ICN", answer, visited, tickets, 0);
        
        return answer;
    }
    
    public boolean dfs(String start, String[] answer, boolean[] visited, String[][] tickets, int usedCnt) {
        if (usedCnt  == tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                
                visited[i] = true;
                answer[usedCnt + 1] = tickets[i][1];
                
                if (dfs(tickets[i][1], answer, visited, tickets, usedCnt + 1)) {
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}
