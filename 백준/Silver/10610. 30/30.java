import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        String[] strNumArr = N.split("");
        int[] numArr = Arrays.stream(strNumArr).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        boolean isZeroExists = false;

        for (int num : numArr) {
            if (num == 0) isZeroExists = true;
            sum += num;
        }

        if (isZeroExists && (sum%3)==0) {
            Arrays.sort(numArr); // 오름차순 정렬
            StringBuilder answer = new StringBuilder();
            for (int i = numArr.length - 1; i>=0; i--) {
                answer.append(numArr[i]);
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }
}