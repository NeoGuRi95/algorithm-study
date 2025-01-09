import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        Map<String, String[]> infoMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        Map<String, Integer> startMap = new HashMap<>();
        for (String info:musicinfos) {
            String[] infoArr = info.split(",");
            int start = convertTime(infoArr[0]);
            int time = convertTime(infoArr[1]) - start;
            String name = infoArr[2];
            String akbo = infoArr[3];
            String[] play = convertPlay(akbo, time);
            infoMap.put(name, play);
            timeMap.put(name, time);
            startMap.put(name, start);
        }
        
        // for (String key:infoMap.keySet()) {
        //     System.out.println("name: " + key + ", akbo: " + Arrays.toString(infoMap.get(key)));
        // }
        
        String answer = "(None)";
        int maxTime = 0;
        int minStart = Integer.MAX_VALUE;
        
        int shopCnt = 0;
        for (char c:m.toCharArray()) {
            if (c == '#') shopCnt++;
        }
        String[] listen = convertPlay(m, m.length() - shopCnt);
        // System.out.println("listen: " + Arrays.toString(listen));
        
        for (String name:infoMap.keySet()) {
            String[] play = infoMap.get(name);
            if (listen.length > play.length) continue;
            
            for (int i = 0; i < play.length - listen.length + 1; i++) {
                boolean flag = true;
                for (int idx = i; idx < i + listen.length; idx++) {
                    if (!listen[idx - i].equals(play[idx])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (maxTime < timeMap.get(name)) {
                        answer = name;
                        maxTime = timeMap.get(name);
                        minStart = startMap.get(name);
                    } else if (maxTime == timeMap.get(name)) {
                        if (minStart > startMap.get(name) + i) {
                            answer = name;
                            maxTime = timeMap.get(name);
                            minStart = startMap.get(name);
                        }
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
    
    int convertTime(String str) {
        String[] time = str.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        return h * 60 + m;
    }
    
    String[] convertPlay(String str, int time) {
        String[] play = new String[time];
        int idx = 0;
        int cnt = 0;
        while (cnt < time) {
            char c = str.charAt(idx % str.length());
            char next = str.charAt((idx + 1) % str.length());
            if (next == '#') {
                play[cnt] = "" + c + next;
                idx++;
            } else {
                play[cnt] = "" + c;
            }
            
            cnt++;
            idx++;
        }
        return play;
    }
}