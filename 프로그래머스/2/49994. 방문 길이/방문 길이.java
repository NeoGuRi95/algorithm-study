import java.util.*;

class Solution {
    public boolean OOB(int[] pos) {
        if (pos[0] < -5 || pos[0] > 5) {
            return true;
        }
        if (pos[1] < -5 || pos[1] > 5) {
            return true;
        }
        return false;
    }
    
    public int[] getNextPos(int[] pos, char d) {
        int[] dx = {0, 0, 1, -1}; // U D R L
        int[] dy = {1, -1, 0, 0};
        if (d == 'U') {
            return new int[] {pos[0] + dx[0], pos[1] + dy[0]};
        } else if (d == 'D') {
            return new int[] {pos[0] + dx[1], pos[1] + dy[1]};
        } else if (d == 'R') {
            return new int[] {pos[0] + dx[2], pos[1] + dy[2]};
        } else {
            return new int[] {pos[0] + dx[3], pos[1] + dy[3]};
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        int[] cur = {0, 0};
        Set<String> paths = new HashSet<>();
        for (char d : dirs.toCharArray()) {
            int[] nCur = getNextPos(cur, d);
            if (OOB(nCur) == true) continue;
            String path1 = "" + cur[0] + cur[1] + nCur[0] + nCur[1];
            String path2 = "" + nCur[0] + nCur[1] + cur[0] + cur[1];
            paths.add(path1);
            paths.add(path2);
            cur = nCur;
        }
        
        return paths.size() / 2;
    }
}