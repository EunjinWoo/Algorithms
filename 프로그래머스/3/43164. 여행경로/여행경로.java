import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        
        List<String> answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        answer.add("ICN");
        dfs("ICN", answer, visited, tickets, 0);
        
        return answer.toArray(new String[0]);
    }
    
    public boolean dfs(String start, List<String> answer, boolean[] visited, String[][] tickets, int usedCnt) {
        if (usedCnt >= tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], answer, visited, tickets, usedCnt + 1)) {
                    return true;
                }
                
                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
        
        return false;
    }
}