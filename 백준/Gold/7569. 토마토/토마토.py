from collections import deque

m, n, h = map(int, input().split())

box = [[[] for _ in range(n)] for _ in range(h)]
que = deque()
for i in range(h):
    for j in range(n):
        row = list(map(int, input().split()))
        xList = list(filter(lambda x: row[x] == 1, range(len(row))))
        # 시작 노드 좌표 저장
        for x in xList:
            # h, n, m, day
            que.append((i, j, x, 0))
        box[i][j] = row

dirs = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]
maxDay = 0
while len(que) > 0:
    a = que.popleft()
    # 방문 표시
    box[a[0]][a[1]][a[2]] = 1
    for d in dirs:
        hd = a[0] + d[0]
        nd = a[1] + d[1]
        md = a[2] + d[2]
        # 이동하려는 노드가 박스의 범위를 벗어날 경우
        if hd < 0 or hd == h:
            continue
        if nd < 0 or nd == n:
            continue
        if md < 0 or md == m:
            continue
        # 이미 방문한 노드이거나 막혀있는 경우
        if box[hd][nd][md] == 1 or box[hd][nd][md] == -1:
            continue
        # 방문 표시
        box[hd][nd][md] = 1
        que.append((hd, nd, md, a[3] + 1))
        # 현재 노드까지 몇 일인지 저장
        if a[3] + 1 > maxDay:
            maxDay = a[3] + 1

# 닿지 못한 노드가 있는지 확인
for i in range(h):
    for j in range(n):
        for item in box[i][j]:
            if item == 0: maxDay = -1

print(maxDay)