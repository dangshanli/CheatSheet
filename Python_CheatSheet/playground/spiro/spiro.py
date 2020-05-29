from datetime import datetime
import argparse
from PIL import Image
import random
import turtle
import math


class Spiro():
    # 绘制spiro曲线的类
    def __init__(self, xc, yc, col, R, r, l):
        '''构造函数'''
        self.t = turtle.Turtle()
        self.t.shape('turtle')

        self.step = 5
        self.drawingComplete = False
        self.setparams(xc, yc, col, R, r, l)  # 初始化成员变量
        self.restart()

    def setparams(self, xc, yc, col, R, r, l):
        '''xc横坐标 yc纵坐标 col颜色 R大圆半径 r小圆半径 l=PC/r'''
        self.xc = xc
        self.yc = yc
        self.col = col
        self.R = int(R)
        self.r = int(r)
        self.l = float(l)
        gcdVal = math.gcd(self.r, self.R)
        self.nRot = self.r // gcdVal
        self.k = r/float(R)
        self.t.color(*col)
        self.a = 0  # current angle

    def restart(self):
        '''绘画准备'''
        self.drawingComplete = False
        self.t.showturtle()
        self.t.up()
        R, k, l = self.R, self.k, self.l
        a = 0.0  # 初始化角度为0
        # 设置原点
        x = R*((1-k)*math.cos(a) + l*k*math.cos((1-k)*a/k))
        y = R*((1-k)*math.sin(a) - l*k*math.sin((1-k)*a/k))
        self.t.setpos(self.xc+x, self.yc+y)
        self.t.down()

    def draw(self):
        '''绘制图形'''
        R, k, l = self.R, self.k, self.l
        for i in range(0, 365*self.nRot+1, self.step):
            a = math.radians(i)
            x = R*((1-k)*math.cos(a) + l*k*math.cos((1-k)*a/k))
            y = R*((1-k)*math.sin(a) - l*k*math.sin((1-k)*a/k))
            self.t.setpos(self.xc+x, self.yc+y)
        self.t.hideturtle()  # 隐藏小乌龟

    def update(self):
        '''这他妈到底有啥用'''
        if self.drawingComplete:
            return
        self.a += self.step
        R, k, l = self.R, self.k, self.l
        a = math.radians(self.a)
        x = R*((1-k)*math.cos(a) + l*k*math.cos((1-k)*a/k))
        y = R*((1-k)*math.sin(a) - l*k*math.sin((1-k)*a/k))
        self.t.setpos(self.xc+x, self.yc+y)

        if self.a >= 365*self.nRot:
            self.drawingComplete = True
            self.t.hideturtle()

    def clear(self):
        self.t.clear()


class SpiroAnimator():
    # 同时绘制多个曲线图
    def __init__(self, N):
        self.deltaT = 10
        self.width = turtle.window_width()
        self.height = turtle.window_height()
        self.spiros = []
        # 创建N个spiro对象
        for i in range(N):
            rparams = self.genRandomParams()
            spiro = Spiro(*rparams)
            self.spiros.append(spiro)
        turtle.ontimer(self.update, self.deltaT)

    def genRandomParams(self):
        '''生成随机参数'''
        width, height = self.width, self.height
        R = random.randint(50, min(width, height)//2)
        r = random.randint(10, 9*R//10)
        xc = random.randint(-width//2, width//2)
        yc = random.randint(-height//2, height//2)
        col = (random.random(), random.random(), random.random())
        l = random.uniform(0.1, 0.9)
        return (xc, yc, col, R, r, l)

    def restart(self):
        '''清理绘画，重新设定参数，绘制准备'''
        print('toggle restart')
        for spiro in self.spiros:
            spiro.clear()
            rparams = self.genRandomParams()
            spiro.setparams(*rparams)
            spiro.restart()

    def update(self):
        '''逐个调用spiro对象的update()'''
        nComplete = 0
        for spiro in self.spiros:
            spiro.update()
            if spiro.drawingComplete:
                nComplete += 1
        if nComplete == len(self.spiros):
            self.restart()
        turtle.ontimer(self.update, self.deltaT)  # 递归调用

    def toggleTurtles(self):
        '''触发turtle开关'''
        for spiro in self.spiros:
            if spiro.t.isvisible():
                spiro.t.hideturtle()
            else:
                spiro.t.showturtle()


def saveDrawing():
    # 保存图片,路径问题搞不定
    prefix = 'D:\\Py_Projects\\test_files\\'
    turtle.hideturtle()
    dateStr = (datetime.now()).strftime('%d%b%Y-%H%M%S')
    filename = 'spiro-'+dateStr
    print('保存图片为{}.eps/png'.format(filename))
    canvas = turtle.getcanvas()
    f = prefix+filename+'.eps'
    canvas.postscript(file=f)
    img = Image.open(prefix+filename+'.eps')
    img.save(prefix+filename+'.png', 'png')
    turtle.showturtle()


def mian():
    print('generating spirograph...')
    parser = argparse.ArgumentParser(description='something...')
    parser.add_argument('--sparams', nargs=3, dest='sparams', required=False,
                        help='the three args in sparams: R r l.')
    args = parser.parse_args()
    turtle.setup(width=0.8)
    turtle.shape('turtle')
    turtle.title('spirographs!')
    turtle.onkey(saveDrawing, 's')
    turtle.listen()

    turtle.hideturtle()

    if args.sparams:
        # 需要注意的是，默认下得到的参数类型都是str，如有需要则必须手动转型
        params = [float(x) for x in args.sparams]
        col = (0, 0, 0)  # 黑色笔尖
        spiro = Spiro(0, 0, col, *params)
        spiro.draw()
    else:
        spiroAnim = SpiroAnimator(4)
        # 绑定 t space按键
        turtle.onkey(spiroAnim.toggleTurtles, 't')
        turtle.onkey(spiroAnim.restart, 'space')
    turtle.mainloop()


if __name__ == '__main__':
    # spiro = Spiro(0, 0, ("red", "green"), 220, 65, 0.8)
    # spiro.draw()
    # turtle.mainloop()

    # sanime = SpiroAnimator(3)
    # turtle.mainloop()

    mian()
