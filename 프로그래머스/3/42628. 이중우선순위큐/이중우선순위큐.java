import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (String op : operations) {
            String[] opArr = op.split(" ");
            if (opArr[0].equals("I")) {
                minQue.add(Integer.parseInt(opArr[1]));
                maxQue.add(Integer.parseInt(opArr[1]));
            } else if (opArr[1].equals("1") && !maxQue.isEmpty()) {
                int num = maxQue.poll();
                minQue.remove(num);
            } else if (opArr[1].equals("-1") && !minQue.isEmpty()) {
                int num = minQue.poll();
                maxQue.remove(num);
            }
        }
        
        int min = 0, max = 0;
        if (!minQue.isEmpty()) min = minQue.poll();
        if (!maxQue.isEmpty()) max = maxQue.poll();
        
        int[] answer = {max, min};
    
        return answer;
    }
}