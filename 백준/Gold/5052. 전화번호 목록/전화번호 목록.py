from collections import defaultdict

t = int(input())
for _ in range(t):
    n = int(input())

    info = defaultdict(int)
    for _ in range(n):
        p_num = input()
        info[p_num] += 1

    flag = True
    for key in info:
        acc = ""
        for num in key:
            acc += num
            if acc in info and acc != key:
                flag = False
                break

    if flag: print("YES")
    else: print("NO")