import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Character> reqSkillMap = new HashMap<>();
        char[] skillArr = skill.toCharArray();
        for (int i = 1; i < skillArr.length; i++) {
            reqSkillMap.put(skillArr[i], skillArr[i - 1]);
        }
        
        for (String skillTree : skill_trees) {
            char[] skillTreeArr = skillTree.toCharArray();
            boolean[] visited = new boolean[26];
            boolean flag = false;
            for (char s : skillTreeArr) {
                if (reqSkillMap.containsKey(s)) {
                    char prevSkill = reqSkillMap.get(s);
                    if (!visited[prevSkill - 'A']) {
                        flag = true;
                        break;
                    }
                }
                visited[s - 'A'] = true;
            }
            if (!flag) answer++;
        }
        
        return answer;
    }
}