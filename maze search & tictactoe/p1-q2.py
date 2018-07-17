import numpy as np

print("Welcome to the Maze! The Maze is shown as below.")
print("'1' indicates a block and '0' indicates a clear space.")

# read date from text
maze = np.genfromtxt('maze.txt', dtype=int)
print(maze)
print("--------------")

# algorithm to find the path between two point


def find_path(x, y, maze):
    if maze[x][y] == 2:
        return True
    elif (x < 0 or y < 0 or x > len(maze) - 1 or y > len(maze) - 1):
        return False
    elif maze[x][y] == 1:
        return False
    elif maze[x][y] == 3:
        return False

    # visited point
    maze[x][y] = 3

    # recursive
    if(find_path(x - 1, y, maze) or find_path(x, y - 1, maze) or find_path(x + 1, y, maze) or find_path(x, y + 1, maze)):
        return True
    return False


def maze_solver(pair_of_point):
    maze = np.genfromtxt('maze.txt', dtype=int)
    # points cannot be 1
    if(maze[pair_of_point[0][0]][pair_of_point[0][1]] == 1 or maze[pair_of_point[1][0]][pair_of_point[1][1]] == 1):
        return "NO"
    # set the end point to be 2
    maze[pair_of_point[1][0]][pair_of_point[1][1]] = 2
    # result
    if(find_path(pair_of_point[0][0], pair_of_point[0][1], maze)):
        return "YES"
    else:
        return "NO"


# five pairs of points
pair_one = [[1, 34], [15, 47]]
pair_two = [[1, 2], [3, 39]]
pair_three = [[0, 0], [3, 77]]
pair_four = [[1, 75], [8, 79]]
pair_five = [[1, 75], [39, 40]]

# get the results

print("For the five pairs of points, the results are:")
print("(1,34) -> (15,47): {}".format(maze_solver(pair_one)))
print("(1,2) -> (3,39): {}".format(maze_solver(pair_two)))
print("(0,0) -> (3,77): {}".format(maze_solver(pair_three)))
print("(1,75) -> (8,79): {}".format(maze_solver(pair_four)))
print("(1,75) -> (39,40): {}".format(maze_solver(pair_five)))
