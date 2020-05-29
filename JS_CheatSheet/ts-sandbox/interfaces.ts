const div = document.querySelector('.index');

interface LabelledValue {
    label: string;
    rotate: number;
}

function printLabel(LabelledValue: LabelledValue) {
    console.log(LabelledValue.label);
}

let myObj = { size: 10, label: 'size 10 object', rotate: 233 };
printLabel(myObj);

/**========================================= */
//可选属性 尾巴处带?表示可选属性
//一般真正传入的参数包含的属性一定要大于预设的接口属性
//但是如果接口的属性声明为可选属性，那么那个属性对于入参来说就是可有可无了
interface SquareConfig {
    color?: string;
    width?: number;
}

function createSquare(config: SquareConfig): { color: string; area: number } {
    let newSquare = { color: 'white', area: 100 };
    if (config.color)
        newSquare.color = config.color;
    if (config.width) {
        newSquare.area = config.width * config.width;
    }
    return newSquare;
}

let mySquare = createSquare({ color: 'black' });

/**==================================================== */
//readonly属性
//一旦被首次赋值以后，就不可更改
interface Point {
    readonly x: number;
    readonly y: number;
}

let p1: Point = { x: 10, y: 20 };
// p1.x = 5;//在赋值给readonly属性就会报错

let a: number[] = [1, 2, 3, 4];
let ro: ReadonlyArray<number> = a;
// ro[0] =12;//readonly数组元素是不可改变的
// ro.push(5);//调用相关的方法都不行
// a = ro;//a和ro不可赋值，不可变数组和一般数组是不同类型

