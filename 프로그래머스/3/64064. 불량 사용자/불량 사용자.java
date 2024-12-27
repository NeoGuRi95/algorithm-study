import java.util.*;

class Solution {
    
    Set<Set<String>> answerSet = new HashSet<>();
    String[] userArr;
    String[] bannedArr;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.userArr = user_id;
        this.bannedArr = banned_id;
        
        dfs(0, new HashSet<>());
        
        return answerSet.size();
    }
    
    public void dfs(int bannedIdx, Set<String> set) {
        if (bannedIdx == bannedArr.length) {
            // 기존 세트가 중복되었는지 체크 후 추가
            answerSet.add(new HashSet<>(set));
            return;
        }
        
        String bannedId = bannedArr[bannedIdx];
        
        for (String userId : userArr) {
            if (set.contains(userId)) continue;
            if (check(userId, bannedId)) {
                set.add(userId);
                dfs(bannedIdx + 1, new HashSet<>(set));
                set.remove(userId);
            }
        }
    }
    
    public boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        return true;
    }
}
