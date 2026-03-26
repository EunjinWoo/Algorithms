import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static ArrayList<Pos> empty = new ArrayList<>();
    static boolean found = false;

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        // 각 칸에 들어갈 수 있는 인덱스들을 뽑고,
        // [0][1].. -> row가 작은게 더 작은 거.
        // row가 같으면 col이 작은 거부터 가장 작은 숫자를 넣어봄
        // 작은 거 부터 넣어보고 안되면 백트래킹..
        // 그러다 마지막거까지 다 채우면 끝

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0'; // 형변환
                if (board[i][j] == 0) {
                    empty.add(new Pos(i, j));
                }
            }
        }

        dfs(0);
    }

    static void dfs(int idx) {
        if (idx == empty.size()) { // 0 없을때까지(끝까지) 다 넣었을때
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append('\n');
            }
            System.out.print(sb);
            found = true;
            return;
        }

        Pos cur = empty.get(idx);
        int r = cur.r;
        int c = cur.c;
        for (int num = 1; num <= 9; num++) {
            if (canPut(r, c, num)) {
                // 넣을 수 있으면 넣고 dfs 나머지 쭉
                board[r][c] = num;
                dfs(idx + 1);
                if (found) return;

                // 못 찾으면 0으로 다시 돌림
                board[r][c] = 0;
            }
        }
    }

    static boolean canPut(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) return false; // 그 행에 넣을 수 있는지 검사
            if (board[i][c] == num) return false; // 그 열에 넣을 수 있는지 검사
        }

        // 3*3 박스에 넣을 수 있는지 검사
        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
