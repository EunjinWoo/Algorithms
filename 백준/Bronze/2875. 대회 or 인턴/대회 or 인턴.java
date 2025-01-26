import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strNums = str.split(" ");
        int girlCount = Integer.parseInt(strNums[0]);
        int boyCount = Integer.parseInt(strNums[1]);
        int participants = Integer.parseInt(strNums[2]);

        int maxTeamCount = (girlCount / 2 < boyCount) ? (girlCount / 2) : boyCount;
        int leftPeopleCount = girlCount + boyCount - 3 * maxTeamCount;
        int removeTeamCount = (leftPeopleCount < participants) ? (participants - leftPeopleCount -1) / 3 + 1 : 0;

        System.out.println(maxTeamCount - removeTeamCount);
    }
}