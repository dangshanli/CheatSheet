import turtle
import math

def drawcircle(x, y, r):
    # up:抬起笔 down:落下笔
    turtle.up()
    turtle.setpos(x+r, y)
    turtle.down()

    for i in range(0, 365, 5):
        a = math.radians(i)
        turtle.setpos(x + r*math.cos(a), y+r*math.sin(a))
drawcircle(100,100,50)
turtle.mainloop()#保持视窗开启
