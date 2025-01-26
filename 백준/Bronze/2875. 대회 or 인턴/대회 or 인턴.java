import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strNums = str.split(" ");
        int N = Integer.parseInt(strNums[0]);
        int M = Integer.parseInt(strNums[1]);
        int K = Integer.parseInt(strNums[2]);

        int maxTeamCount = (N / 2 < M) ? (N / 2) : M;
        int leftPeopleCount = N + M - 3 * maxTeamCount;
        int removeTeamCount = (leftPeopleCount < K) ? (K - leftPeopleCount -1) / 3 + 1 : 0;

        System.out.println(maxTeamCount - removeTeamCount);
    }
}
