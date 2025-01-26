import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cows = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        int N = scanner.nextInt();
        scanner.nextLine();
        int changePosCount = 0;

        for (int i=0 ; i<N; i++) {
            String inputStr = scanner.nextLine();
            String[] inputStrArr = inputStr.split(" ");
            int cowNum = Integer.parseInt(inputStrArr[0]) - 1;
            int cowPos = Integer.parseInt(inputStrArr[1]);

            if (cows[cowNum] == -1) {
                cows[cowNum] = cowPos;
            } else if (cows[cowNum] != cowPos){
                cows[cowNum] = cowPos;
                changePosCount++;
            }
        }

        System.out.print(changePosCount);
    }
}