import java.util.*;

class Solution {
    public int solution(String name) {
        HashMap<String, Integer> map = new HashMap<>();
        setAlphabetMap(map); 

        String[] nameArray = name.split("");
        int length = nameArray.length;
        
        boolean allA = true;
        
        // 문자 자체 조작 수
        int charCost = 0;
        for (String s: nameArray) {
            if (!s.equals("A")) { allA = false;}
            charCost += map.get(s);
        }
        
        if (allA) return 0;
        
        // 가장 큰 A 그룹 찾기
        int maxSequentialACnt = 0;
        int startA = -1;
        int endA = -1;
        for (int i=0; i<length; i++) {
            if (!nameArray[i].equals("A")) continue;
            
            int tempStart = i;
            int tempEnd = tempStart;
            
            while (tempEnd < length-1 && nameArray[tempEnd+1].equals("A")) {
                tempEnd++;
            }
            
            int tempACnt = tempEnd - tempStart + 1;
            
            if (tempACnt > maxSequentialACnt) {
                startA = tempStart;
                endA = tempEnd;
                
                maxSequentialACnt = tempACnt;
            }
            
            i = tempEnd;
        }
        
        // 1) -> 방향으로 쭉 : 첫 문자 뒤 A 개수
        int firstACnt = 0;
        for (int i=1; i<length; i++) {
            if (!nameArray[i].equals("A")) break;
    
            firstACnt++;
        }
        int leftTravelCost = length - 1 - firstACnt;
        
        // 2) <- 방향으로 쭉 : 맨 마지막 A 개수
        int lastACnt = 0;
        for (int i=length-1; i>=0; i--) {
            if (!nameArray[i].equals("A")) break;
            
            lastACnt++;
        }
        int rightTravelCost = length - 1 - lastACnt;
        
        // 3) -> <- 방향으로 쭉
        int rightLeftTravelCost = length-1;
        if (startA >= 1 && endA < length-1) {
            rightLeftTravelCost = 2*(startA-1) + (length-1-endA);
        }
        
        // 4) <- -> 방향으로 쭉
        int leftRightTravelCost = length-1;
        if (startA >= 1 && endA < length-1) {
            leftRightTravelCost = (startA-1) + 2*(length-1-endA);
        }
        
        // 이동 비용
        int travelCost = Math.min(
            Math.min(leftTravelCost, rightTravelCost), 
            Math.min(rightLeftTravelCost, leftRightTravelCost)
        );
        
        return charCost + travelCost;
    }
    
    private static void setAlphabetMap(HashMap<String, Integer> map) {
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        for (int i=0; i<26; i++) {
            if (i<=13) {
                map.put(alphabets[i], i);
            } else {
                map.put(alphabets[i], 26-i);
            }
        }
    }
}