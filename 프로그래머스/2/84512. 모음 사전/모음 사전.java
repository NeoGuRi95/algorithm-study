class Solution {
    int answer = 0;
    boolean flag = false;
    char[] alphaArr = {'A', 'E', 'I', 'O', 'U'};
    
    public void dfs(String targetWord, String word) {
        if (word.equals(targetWord)) {
            flag = true;
            return;
        }
        if (word.length() == 5) return;
        for (char alpha : this.alphaArr) {
            this.answer += 1;
            dfs(targetWord, word + alpha);
            if (flag == true) return;
        }
    }
    
    public int solution(String word) {
        dfs(word, "");
        return this.answer;
    }
}