# coding: utf-8


"""
⼆维矩阵中的搜索问题框架
(x, y) 为坐标位置
fill(x, y):
    fill(x-1, y)
    fill(x, y-1)
    fill(x+1, y)
    fill(x, y+1)
"""


##############################################
# FloodFill问题
def floodFill(image, sr, sc, newcolor):
    if not inarea(image, sr, sc):
        return
    visited = [[False] * len(image[0]) for _ in range(len(image))]
    oricolor = image[sr][sc]
    fill(image, sr, sc, oricolor, newcolor, visited)
    return image

def fill(image, x, y, oricolor, newcolor, visited):
    if not inarea(image, x, y):
        return
    if image[x][y] != oricolor:
        return
    if visited[x][y]:
        return
    image[x][y] = newcolor
    visited[x][y] = True
    fill(image, x - 1, y, oricolor, newcolor, visited)
    fill(image, x, y - 1, oricolor, newcolor, visited)
    fill(image, x + 1, y, oricolor, newcolor, visited)
    fill(image, x, y + 1, oricolor, newcolor, visited)

def inarea(image, x, y):
    lenx = len(image)
    leny = len(image[0])
    if 0 <= x < lenx and 0 <= y < leny:
        return True
    return False

image = [
    [1, 1, 1],
    [1, 1, 0],
    [1, 0, 1],
    [1, 0, 0]
]


##############################################
# FloodFill问题
def floodFill2(image, sr, sc, newcolor):
    if not inarea(image, sr, sc):
        return
    oricolor = image[sr][sc]
    fill2(image, sr, sc, oricolor, newcolor)
    return image

def fill2(image, x, y, oricolor, newcolor):
    if not inarea(image, x, y):
        return
    if image[x][y] != oricolor:
        return
    if image[x][y] == -1:
        return
    image[x][y] = -1
    fill2(image, x - 1, y, oricolor, newcolor)
    fill2(image, x, y - 1, oricolor, newcolor)
    fill2(image, x + 1, y, oricolor, newcolor)
    fill2(image, x, y + 1, oricolor, newcolor)
    image[x][y] = newcolor
    

newimage = floodFill(image, 1, 1, 100)
print(newimage)
newimage2 = floodFill2(image, 1, 1, 200)
print(newimage2)