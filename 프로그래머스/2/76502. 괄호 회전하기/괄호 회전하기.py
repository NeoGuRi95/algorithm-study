from collections import deque

def solution(s):
    answer = 0
    que = deque(list(s))
    for x in range(len(s)):
        flag = True
        stack = []
        for a in que:
            if a == '[' or a == '(' or a == '{': 
                stack.append(a)
            else: 
                if len(stack) == 0:
                    flag = False
                    break
                elif a == ')' and '(' != stack.pop():
                    flag = False
                    break
                elif a == ']' and '[' != stack.pop():
                    flag = False
                    break
                elif a == '}' and '{' != stack.pop():
                    flag = False
                    break
        if flag and len(stack) == 0: 
            answer += 1
        que.append(que.popleft())
        
    return answer