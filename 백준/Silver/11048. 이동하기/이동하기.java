import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                int value = Integer.parseInt(st.nextToken());

                int fromUp = dp[i - 1][j];
                int fromLeft = dp[i][j - 1];
                int fromDiag = dp[i - 1][j - 1];

                int best = Math.max(fromUp, Math.max(fromLeft, fromDiag));
                dp[i][j] = best + value;
            }
        }

        System.out.println(dp[N][M]);
    }
}
