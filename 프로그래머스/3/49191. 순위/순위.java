class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n+1][n+1];

        // 경기 결과 기록
        for (int[] r : results) {
            graph[r[0]][r[1]] = true;
        }

        // Floyd–Warshall
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        // 순위 판별
        for (int i = 1; i <= n; i++) {
            int win = 0;
            int lose = 0;

            for (int j = 1; j <= n; j++) {
                if (graph[i][j]) win++;
                if (graph[j][i]) lose++;
            }

            if (win + lose == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
