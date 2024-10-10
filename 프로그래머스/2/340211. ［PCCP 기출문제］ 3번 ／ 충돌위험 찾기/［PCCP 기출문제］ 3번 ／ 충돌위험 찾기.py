class Robot:
    def __init__(self, robot_idx, cur_point, target_point, route_idx):
        self.robot_idx = robot_idx
        self.cur_point = cur_point
        self.target_point = target_point
        self.route_idx = route_idx
        self.is_end = False
        
    def move(self):
        if self.cur_point[0] < self.target_point[0]:
            self.cur_point[0] += 1
        elif self.cur_point[0] > self.target_point[0]:
            self.cur_point[0] -= 1
        elif self.cur_point[1] < self.target_point[1]:
            self.cur_point[1] += 1
        elif self.cur_point[1] > self.target_point[1]:
            self.cur_point[1] -= 1
    
    def update_point(self, routes, points):
        route = routes[self.robot_idx]
        if self.cur_point == self.target_point:
            self.route_idx += 1
            if self.route_idx < len(route):
                self.target_point = points[route[self.route_idx] - 1][:]
            else:
                self.is_end = True

from collections import defaultdict
        
def solution(points, routes):
    # init robots
    robots = []
    for idx, route in enumerate(routes):
        cur_point = points[route[0] - 1][:]
        target_point = points[route[1] - 1][:]
        robots.append(Robot(idx, cur_point, target_point, 1))

    answer = 0
    while robots:
        robot_point_dict = defaultdict(int)
        # check robots point
        for robot in robots:
            robot_point_dict[tuple(robot.cur_point)] += 1
        # count collision
        for point, cnt in robot_point_dict.items():
            if cnt > 1:
                answer += 1
        new_robots = []
        # update robots point
        for robot in robots:
            robot.update_point(routes, points)
            if robot.is_end is False:
                new_robots.append(robot)
        # move robots
        robots = new_robots
        for robot in robots:
            robot.move()

    return answer