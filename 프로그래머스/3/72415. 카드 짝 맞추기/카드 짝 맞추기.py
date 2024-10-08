from itertools import permutations
from collections import defaultdict
import pprint

def solution(board, r, c):
    def calc_command_cnt(start_r, start_c, end_r, end_c):
        # 행 이동 -> 열 이동 경우
        cur_r, cur_c = start_r, start_c
        command_cnt_1 = 0
        # 행 이동
        temp_command_cnt = 0
        while cur_r != end_r:
            if cur_r < end_r:
                cur_r += 1
            elif cur_r > end_r:
                cur_r -= 1
            temp_command_cnt += 1
            if _board[cur_r][cur_c] > 0 or cur_r == 0 or cur_r == 3:
                # 카드를 만나거나 방향의 마지막 칸인 경우 ctrl 이동
                temp_command_cnt = 0
                command_cnt_1 += 1
        command_cnt_1 += temp_command_cnt
        # 열 이동
        temp_command_cnt = 0
        while cur_c != end_c:
            if cur_c < end_c:
                cur_c += 1
            elif cur_c > end_c:
                cur_c -= 1
            temp_command_cnt += 1
            if _board[cur_r][cur_c] > 0 or cur_c == 0 or cur_c == 3:
                temp_command_cnt = 0
                command_cnt_1 += 1
        command_cnt_1 += temp_command_cnt
        #################################
        # 열 이동 -> 행 이동 경우
        cur_r, cur_c = start_r, start_c
        command_cnt_2 = 0
        # 열 이동
        temp_command_cnt = 0 
        while cur_c != end_c:
            if cur_c < end_c:
                cur_c += 1
            elif cur_c > end_c:
                cur_c -= 1
            temp_command_cnt += 1
            if _board[cur_r][cur_c] > 0 or cur_c == 0 or cur_c == 3:
                temp_command_cnt = 0
                command_cnt_2 += 1
        command_cnt_2 += temp_command_cnt
        # 행 이동
        temp_command_cnt = 0
        while cur_r != end_r:
            if cur_r < end_r:
                cur_r += 1
            elif cur_r > end_r:
                cur_r -= 1
            temp_command_cnt += 1
            if _board[cur_r][cur_c] > 0 or cur_r == 0 or cur_r == 3:
                temp_command_cnt = 0
                command_cnt_2 += 1
        command_cnt_2 += temp_command_cnt
        
        return min(command_cnt_1, command_cnt_2)

    def bfs(select_order, depth, cur_pos, command_cnt, path):
        if depth == len(select_order):
            # pprint.pprint(path)
            # print('command_cnt:', command_cnt)
            # print()
            return command_cnt
        card_type = select_order[depth]
        pos1, pos2 = card_pos_dict[card_type][0], card_pos_dict[card_type][1]
        # cur_pos -> pos1 조작 횟수
        command_cnt1 = calc_command_cnt(cur_pos[0], cur_pos[1], pos1[0], pos1[1])
        # cur_pos -> pos2 조작 횟수
        command_cnt2 = calc_command_cnt(cur_pos[0], cur_pos[1], pos2[0], pos2[1])
        # pos1 -> pos2 조작 횟수
        command_cnt3 = calc_command_cnt(pos1[0], pos1[1], pos2[0], pos2[1])
        # pos2 -> pos1 조작 횟수
        command_cnt4 = calc_command_cnt(pos2[0], pos2[1], pos1[0], pos1[1])
        # 선택한 카드 제거
        _board[pos1[0]][pos1[1]] = 0
        _board[pos2[0]][pos2[1]] = 0
        # cur_pos -> pos1 -> pos2
        path.append((cur_pos, pos1, pos2))
        # print('----------------')
        # print(cur_pos, ' -> ', pos1, ': ', command_cnt1)
        # print(pos1, ' -> ', pos2, ': ', command_cnt3)
        # print('----------------')
        total_command_cnt = bfs(select_order, depth + 1, pos2, command_cnt + command_cnt1 + command_cnt3 + 2, path)
        path.pop()
        # cur_pos -> pos2 -> pos1
        path.append((cur_pos, pos2, pos1))
        # print(cur_pos, ' -> ', pos2, ': ', command_cnt2)
        # print(pos2, ' -> ', pos1, ': ', command_cnt3)
        # print('----------------')
        total_command_cnt = min(
            total_command_cnt, 
            bfs(select_order, depth + 1, pos1, command_cnt + command_cnt2 + command_cnt4 + 2, path))
        path.pop()
        # 선택한 카드 부활
        _board[pos1[0]][pos1[1]] = card_type
        _board[pos2[0]][pos2[1]] = card_type
        
        return total_command_cnt
        
    global _board, card_pos_dict
    answer = float('inf')
    _board = board
    card_pos_dict = defaultdict(list)
    # 카드 종류별 위치 저장
    for i, row in enumerate(board):
        for j, card_type in enumerate(row):
            if card_type == 0: continue
            card_pos_dict[card_type].append((i, j))
    
    # 카드 선택 순서
    card_type_list = list(card_pos_dict.keys())
    select_order_list = list(permutations(card_type_list, len(card_type_list)))
    for select_order in select_order_list:
        # print('select_order: ', select_order)
        answer = min(bfs(select_order, 0, (r, c), 0, []), answer)
        # print('answer: ', answer)
        # print('--------------------')
    
    return answer