def solution(diffs, times, limit):
    def validate(level):
        acc_t, t_prev = 0, 0
        for i, diff in enumerate(diffs):
            if diff < level:
                acc_t += times[i]
            else:
                acc_t += (diff - level) * (t_prev + times[i]) + times[i]
            t_prev = times[i]
            if acc_t > limit:
                return False
        # print('acc_time: ', acc_t)
        return True
    
    def bisect_search():
        l, r = min(diffs), max(diffs)
        while l < r:
            level = l + (r - l) // 2
            res = validate(level)
            if res is True:
                # decrease level
                r = level
            else:
                # increase level
                l = level + 1
        return l
        
    answer = bisect_search()
    return answer