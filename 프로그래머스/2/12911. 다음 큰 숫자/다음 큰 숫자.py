def solution(n):
    def get_binary_num(nn, arr):
        a, b = divmod(nn, 2)
        arr.append(b)
        if a == 0:
            return arr
        else:
            return get_binary_num(a, arr)
    
    binary_arr = get_binary_num(n, [])
    cnt1 = binary_arr.count(1)
    answer = 0
    
    while True:
        n += 1
        binary_arr = get_binary_num(n, [])
        cnt2 = binary_arr.count(1)
        if cnt1 == cnt2:
            answer = n
            break
    
    return answer