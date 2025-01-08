import java.util.*;

class Solution {
    
    Map<String, Integer> info = new HashMap<>();
    boolean[] lens = new boolean[11];
    int[] best = new int[11];
    
    public String[] solution(String[] orders, int[] course) {
        for (int c:course) {
            lens[c] = true;
        }
        
        for (String order:orders) {
            dfs(order.toCharArray(), "", 0);
        }
        
        for (String key:info.keySet()) {
            best[key.length()] = Math.max(best[key.length()], info.get(key));
        }
        
        List<String> result = new ArrayList<>();
        for (String key:info.keySet()) {
            if (best[key.length()] == info.get(key) && info.get(key) >= 2) {
                result.add(key);
            }
        }
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    void dfs(char[] arr, String comb, int idx) {
        if (lens[comb.length()]) {
            String result = convert(comb);
            info.put(result, info.getOrDefault(result, 0) + 1);
        }
        if (idx == arr.length) return;
        for (int i = idx; i < arr.length; i++) {
            dfs(arr, comb + arr[i], i + 1);
        }
    }
    
    String convert(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String result = "";
        for (char c:arr) {
            result += c;
        }
        return result;
    }
    
    void printInfo() {
        for (String key:info.keySet()) {
            System.out.println("key: " + key + ", value: " + info.get(key));
        }
    }
}