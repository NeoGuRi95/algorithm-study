import re
from collections import defaultdict

def solution(str1, str2):
    str_dict1 = defaultdict(int)
    str_dict2 = defaultdict(int)

    str1 = str1.lower()
    str2 = str2.lower()
    for idx, s1 in enumerate(str1):
        if idx == len(str1) - 1: continue
        s2 = str1[idx + 1]
        if bool(re.match(r'[a-z]$', s1)) and bool(re.match(r'[a-z]$', s2)):
            str_dict1[s1 + s2] += 1
    for idx, s1 in enumerate(str2):
        if idx == len(str2) - 1: continue
        s2 = str2[idx + 1]
        if re.match(r'[a-z]$', s1) and re.match(r'[a-z]$', s2):
            str_dict2[s1 + s2] += 1
    print(str_dict1)
    print(str_dict2)
    inter_set = set()
    a, b = 0, 0
    for key, value in str_dict1.items():
        if key in str_dict2:
            a += min(str_dict1[key], str_dict2[key])
            b += max(str_dict1[key], str_dict2[key])
            inter_set.add(key)

    for key, value in str_dict1.items():
        if key in inter_set: continue
        b += value
    for key, value in str_dict2.items():
        if key in inter_set: continue
        b += value
    
    if a == 0 and b == 0:
        return 65536
    else:
        return int(a / b * 65536)