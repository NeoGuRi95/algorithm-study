import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        List<Room> roomList = new ArrayList<>();
        for (int a = 0; a < p; a++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            Member newMember = new Member(level, id);
            if (roomList.isEmpty()) { // 방이 아예 없을 경우
                Room newRoom = new Room(level, newMember);
                roomList.add(newRoom);
            } else {
                for (int i = 0; i < roomList.size(); i++) {
                    Room room = roomList.get(i);
                    if (room.minLevel <= level && level <= room.maxLevel && room.memberList.size() < m) {
                        room.memberList.add(newMember);
                        break;
                    } else if (i == roomList.size() - 1) {
                        Room newRoom = new Room(level, newMember);
                        roomList.add(newRoom);
                        break;
                    }
                }
            }
        }

        for (Room room:roomList) {
            room.memberList.sort(Comparator.comparing(member -> member.id));
            if (room.memberList.size() == m) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            for (Member member: room.memberList) {
                bw.write(String.format("%d %s\n", member.level, member.id));
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static class Room {
        int maxLevel;
        int minLevel;
        List<Member> memberList = new ArrayList<>();

        Room(int level, Member member) {
            this.maxLevel = level + 10;
            this.minLevel = level - 10;
            this.memberList.add(member);
        }
    }

    public static class Member {
        int level;
        String id;

        Member(int level, String id) {
            this.level = level;
            this.id = id;
        }
    }
}
