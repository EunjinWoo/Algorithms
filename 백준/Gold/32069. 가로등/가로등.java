import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long L = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int distance = 0;
        int prevLength = 0;
        int length = 0;

        ArrayList<int[]> vdList = new ArrayList<>(); // value-distance List
        HashMap<Integer, Integer> vdMap = new HashMap<>(); // value-distance Map

        // A_N까지 다 담기 일단 distance는 0으로
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            vdList.add(new int[]{value, 0});
            vdMap.put(value, 0);
        }
        length = vdList.size();

        while (length <= K) {
            // distance 1부터 쭉 추가
            distance++;

            // 이전 새 distance(현재 distance - 1)로 추가된 녀석들을 기반으로 새로운 distance로 값(value)를 집어넣음
            for (int i = prevLength; i < length; i++) {
                for (int p = 0; p < 2; p++) {
                    int delta = (p==0) ? 1 : -1;
                    int target = vdList.get(i)[0] + delta;
                    if (!vdMap.containsKey(target) && target > -1 && target <= L) { // value가 중복된 값은 넣지 않음
                        vdList.add(new int[]{target, distance});
                        vdMap.put(target, distance);

                        if (vdList.size() >= K) break; // K개까지만 추가
                    }
                }
                if (vdList.size() >= K) break;
            }

            // prevLength ~ length-1까지가 새로 추가된 녀석들
            prevLength = length;
            length = vdList.size();

            if (vdList.size() >= K) break;
        }

        // dvList에서 K개 distance 가장 작은 순(앞에서부터)으로 출력함
        for (int i = 0; i < K; i++) {
            System.out.println(vdList.get(i)[1]);
        }
    }
}