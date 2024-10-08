from collections import defaultdict

def solution(gems):
    n = len(gems)
    gem_type_cnt = len(set(gems))
    gem_cnt_dict = defaultdict(int)
    gem_cnt_dict[gems[0]] = 1
    l, r = 0, 0
    answer = [0, float('inf')]
    while l < n:
        if len(gem_cnt_dict) == gem_type_cnt:
            # 기존 구간보다 더 짧은 구간이면 답 갱신
            if (answer[1] - answer[0]) > (r - l):
                answer = [l + 1, r + 1]
            # 구간을 줄임으로써 해당 단어가 존재하지 않게되면 del
            gem_cnt_dict[gems[l]] -= 1
            if gem_cnt_dict[gems[l]] == 0:
                gem_cnt_dict.pop(gems[l])
            # 구간 줄이기
            l += 1
        elif len(gem_cnt_dict) < gem_type_cnt:
            # 구간 늘리기
            r += 1
            # 탈출 조건
            if r == n: break
            gem_cnt_dict[gems[r]] += 1

    return answer