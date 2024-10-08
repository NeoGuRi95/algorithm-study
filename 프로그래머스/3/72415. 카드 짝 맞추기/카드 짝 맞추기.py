from itertools import permutations
from collections import defaultdict
import pprint

def solution(board, r, c):
    def calc_command_cnt(start_r, start_c, end_r, end_c):
        temp_command_cnt = 0
        # 행 이동 횟수
        row_command_cnt = 0
        while start_r != end_r:
            if start_r > end_r:
                # 위 이동
                start_r -= 1
            elif start_r < end_r:
                # 아래 이동
                start_r += 1
            if _board[start_r][start_c] > 0:
                row_command_cnt += 1
                temp_command_cnt = 0
            else:
                temp_command_cnt += 1
        if row_command_cnt > 0:
            row_command_cnt += temp_command_cnt
        else:
            row_command_cnt = 1
        # 열 이동 횟수
        col_command_cnt = 0
        temp_command_cnt = 0
        while start_c != end_c:
            if start_c > end_c:
                # 왼쪽 이동
                start_c -= 1
            elif start_c < end_c:
                # 오른쪽 이동
                start_c += 1
            if _board[start_r][start_c] > 0:
                col_command_cnt = 1
                temp_command_cnt = 0
            else:
                temp_command_cnt += 1
        if col_command_cnt > 0:
            col_command_cnt += temp_command_cnt
        else:
            col_command_cnt = 1
        
        return row_command_cnt + col_command_cnt

    def bfs(select_order, depth, cur_pos, command_cnt):
        print('----------------')
        print('depth: ', depth)
        print('cur_pos: ', cur_pos)
        print('command cnt: ', command_cnt)
        if depth == len(select_order):
            print('return command cnt: ', command_cnt)
            return command_cnt
        card_type = select_order[depth]
        pos1, pos2 = card_pos_dict[card_type][0], card_pos_dict[card_type][1]
        print('pos1, pos2: ', pos1, pos2)
        # cur_pos -> pos1 조작 횟수
        command_cnt1 = calc_command_cnt(cur_pos[0], cur_pos[1], pos1[0], pos1[1])
        # cur_pos -> pos2 조작 횟수
        command_cnt2 = calc_command_cnt(cur_pos[0], cur_pos[1], pos2[0], pos2[1])
        # pos1 -> pos2 조작 횟수(pos2 -> pos1 조작 횟수 동일)
        command_cnt3 = calc_command_cnt(pos1[0], pos1[1], pos2[0], pos2[1])
        # 선택한 카드 제거
        _board[pos1[0]][pos1[1]] = 0
        _board[pos2[0]][pos2[1]] = 0
        # cur_pos -> pos1 -> pos2
        print('cur_pos -> pos1: ', command_cnt1)
        print('pos1 -> pos2: ', command_cnt3)
        total_command_cnt = bfs(select_order, depth + 1, pos2, command_cnt + command_cnt1 + command_cnt3 + 2)
        # cur_pos -> pos2 -> pos1
        print('cur_pos -> pos2: ', command_cnt2)
        print('pos2 -> pos1: ', command_cnt3)
        total_command_cnt = min(
            total_command_cnt, 
            bfs(select_order, depth + 1, pos2, command_cnt + command_cnt2 + command_cnt3 + 2))
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
        print('select_order: ', select_order)
        answer = min(bfs(select_order, 0, (r, c), 0), answer)
        print('answer: ', answer)
        print('--------------------')
    
    return answer