def solution(arr):
    answer = 0
    arr.sort()
    maxx = arr[-1]
    multiple = 1
    while True:
        LCM = maxx * multiple
        flag = True
        for num in arr:
            if LCM % num > 0:
                flag = False
                break
        if flag is True:
            break
        else:
            multiple += 1
    return LCM