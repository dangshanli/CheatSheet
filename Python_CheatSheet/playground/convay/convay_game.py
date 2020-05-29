import random
import matplotlib.pyplot as plt
import numpy as np
import matplotlib.animation as animation

# cell 状态：ON OFF，用数字表示，on-225;off-0
x = np.array([[0, 0, 225], [225, 225, 0], [0, 225, 0]])
plt.imshow(x, interpolation='nearest')
# plt.show()


x = np.random.choice([0, 225], 4*4, p=[0.1, 0.9]).reshape(4, 4)
print(x)


def addGlider(i, j, grid):
    '''创建指定数值的矩阵'''
    glider = np.array([[0, 0, 255], [255, 0, 255], [0, 255, 255]])  # 3 * 3矩阵
    grid[i:i+3, j:j+3] = glider


grid = np.zeros(9).reshape(3, 3)
addGlider(0, 0, grid)
print(grid)
