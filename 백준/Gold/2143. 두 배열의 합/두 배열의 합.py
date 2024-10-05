from bisect import bisect_left, bisect_right

t = int(input())
n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

prefix_sum_a = []
for i in range(n):
    summ = A[i]
    prefix_sum_a.append(summ)
    for j in range(i + 1, n):
        summ += A[j]
        prefix_sum_a.append(summ)

prefix_sum_b = []
for i in range(m):
    summ = B[i]
    prefix_sum_b.append(summ)
    for j in range(i + 1, m):
        summ += B[j]
        prefix_sum_b.append(summ)

ans = 0
prefix_sum_b.sort()
for prefix_a in prefix_sum_a:
    target = t - prefix_a
    lower_bound = bisect_left(prefix_sum_b, target)
    upper_bound = bisect_right(prefix_sum_b, target)
    ans += upper_bound - lower_bound

print(ans)
