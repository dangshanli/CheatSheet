//=======================enum================================
//define
enum Color { Red = 1, Green = 2, Blue = 4 }
//assign
let c: Color = Color.Blue;
console.log(c);
let colorName: string = Color[4];
console.log(colorName);

/**========================================================== */
//Any类型
let notSure: any = 4;
notSure = 'maybe a string instead';
notSure = false;
console.log(notSure);

// 运行时方法
// notSure.ifItExits();  //如果运行时存在这个方法，而编译时检测不出来，使用any表达这个类型是好的选择

let prettySure: Object = 4;
// prettySure.toFixed(); //使用Object如果编译时检测不出方法，则会马上编译报错

//混合类型数组
let list: any[] = [1, false, 'free'];
console.log('list[0]: ' + list[0]);

/**========================================================== */
//void类型

function warnUser(): void {
    console.log('this is my warning message');
}

warnUser();

/**========================================================== */
//never类型标识总会抛出异常的函数，任何类型不得赋值never类型，any也不行
function error(message: string): never {
    throw new Error(message);
}

/**========================================================== */
//类型断言，即类型转换
let someValue: any = 'this is a string';
//使用尖括号(<>)类型转换成string，以便调用他的length方法
let strLength: number = (<string>someValue).length;

/**========================================================== */



