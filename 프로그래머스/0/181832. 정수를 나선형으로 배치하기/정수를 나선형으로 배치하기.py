def solution(n):
    answer = [[0] * n for _ in range(n)]
    x, y = 0, 0
    d = 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    for i in range(1, n ** 2 + 1):
        answer[x][y] = i
        nx = x + dx[d]
        ny = y + dy[d]
        if 0 <= nx < n and 0 <= ny < n and answer[nx][ny] == 0:
            x = nx
            y = ny
        else:
            d = (d + 1) % 4
            x = x + dx[d]
            y = y + dy[d]

    return answer