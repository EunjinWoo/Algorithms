class Solution {   
    static boolean[] visited;
    
    private static void dfs(int v, int totalCnt, int[][] computers) {
        visited[v] = true;
        
        for (int i=0; i<totalCnt; i++) {
            if (computers[v][i] == 1 && !visited[i]) {
                dfs(i, totalCnt, computers);
            }
        }
        
        return;
    }
    
    public int solution(int n, int[][] computers) {
        int netCnt = 0;
        visited = new boolean[n];
        
        // dfs 다 돌고 나면 네트워크 하나 추가
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                
                netCnt++;
            }
        }
        
        return netCnt;
    }
}