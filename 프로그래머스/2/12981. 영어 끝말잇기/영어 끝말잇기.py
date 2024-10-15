def solution(n, words):
    answer = [0, 0]

    back_char = ""
    prev_word_set = set()
    for idx, word in enumerate(words):
        cycle_num = idx // n + 1
        parti_num = idx % n + 1 # n:3, 1 2 3 1 2 3 ...
        if word in prev_word_set:
            answer = [parti_num, cycle_num]
            break
        elif idx != 0 and word[0] != back_char:
            answer = [parti_num, cycle_num]
            break
        else:
            back_char = word[-1]
            prev_word_set.add(word)

    return answer