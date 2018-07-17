AI 2018 Spring
Name: Baosheng Feng
GWID: G22770384
Email: bsfeng@gwu.edu
Assignment: Project #1
Python: 3.6

Q1.

$ python3 p1-q1.py

In this question, tkinter was used to build the UI.
The parameter current_player was used to identify the current player X or O.
The parameter step was used to count steps. When it is 9, the game is draw.
There are eight situations that player wins the game.
For the grid, the button numbers are shown below:

123
456
789

Reset and Exit functions are also included in the program.


Q2.

$ python3 p1-q2.py

In this question, we used recursive algorithms to solve the maze question.
For one point, we just need to find whether the point is 0 or 1 or the end point or the points we have already visited.
For points we have already visited, we will mark it as 3.
For point that is 0. We just need to find the up, down, left, and right point could go to the end point. To solve this, we just need to write a simple recursive algorithm.