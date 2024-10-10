class Robot:
    def __init__(self, cur_point, target_point, route_idx):
        self.cur_point = cur_point
        self.target_point = target_point
        self.route_idx = route_idx
        
    def move_row(self):
        if cur_point[0] < target_point[0]:
            cur_point[0] += 1
        elif cur_point[0] > target_point[0]:
            cur_point[0] -= 1
        
    def move_col(self):
        if cur_point[1] < target_point[1]:
            cur_point[1] += 1
        elif cur_point[1] > target_point[1]:
            cur_point[1] -= 1
    
    def check_point(self):
        if cur_point == target_point:
            return True
        else:
            return False
        
def solution(points, routes):
    answer = 0
    # init robots
    robots = []
    for route in routes:
        cur_point = points[route[0] - 1]
        target_point = points[route[1] - 1]
        robots.append(Robot(cur_point, target_point, 1))
    print(robots[0].cur_point)
    print(robots[0].target_point)
    print(robots[0].route_idx)
    return answer