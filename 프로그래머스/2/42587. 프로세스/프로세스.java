import java.util.*;

class Pair {
    int priority;
    int location;
    
    Pair(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        int length = priorities.length;
        
        // priorities를 내림차순으로 정렬해서 <다음으로 출력될 우선순위>를 관리
        int[] sorted = Arrays.copyOf(priorities, length);
        Arrays.sort(sorted); // 오름차순
        int maxIndex = length - 1; // sorted[maxIndex]가 현재 남은 최대 우선순위
        
        // 큐에 값, location Pair 넣기
        for (int i = 0; i < length; i++) {
            queue.add(new Pair(priorities[i], i));
        }
        
        int order = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            
            if (sorted[maxIndex] == current.priority) {
                maxIndex--;
                order++;
                
                if (location == current.location) {
                    return order;
                }
                
            } else {
                queue.add(current);
            }
        }
        
        return -1;
    }
}