import sys

n = int(sys.stdin.readline())
arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))
arr.append([0, 0])

# dp[i]: i일까지 얻을 수 있는 최대 수익
dp = [0] * (n + 1)
for idx, [ti, pi] in enumerate(arr):
    dp[idx] = max(dp[idx - 1], dp[idx])
    if idx + ti > n: continue
    dp[idx + ti] = max(dp[idx + ti], dp[idx] + arr[idx][1])

print(dp[-1])