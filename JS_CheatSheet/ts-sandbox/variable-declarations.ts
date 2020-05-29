const div = document.querySelector('.index');

//var没有块级作用域，只有函数作用域
function sumMatrix(matrix: number[][]) {
    var sum = 0;
    //两个循环的i指向同一个变量，导致加和只做了一次
    for (var i = 0; i < matrix.length; i++) {
        var currentRow = matrix[i];
        for (var i = 0; i < currentRow.length; i++) {
            sum += currentRow[i];
        }
    }

    return sum;
}
var sun = sumMatrix([[1, 2, 3], [1, 2, 3], [1, 2, 3]]);
div.textContent = sun;

//怪异的捕获变量方式
/** 
 * for (var i = 0; i < 10; i++) {
    setTimeout(function () { console.log(i); }, 100 * i);
}*/

//修复版本，立即执行函数
// for (var i = 0; i < 10; i++) {
//     // capture the current state of 'i'
//     // by invoking a function with its current value
//     (function (i) {
//         setTimeout(function () { console.log(i); }, 100 * i);
//     })(i);
// }

for (let i = 0; i < 10; i++) {
    setTimeout(function () { console.log(i); }, 100 * i);
}

/**================================================================ */
//解构赋值
let input = [1, 2];
let [first, second] = input;
console.log('first: ' + first);
console.log('second: ' + second);

function f([first, second]: [number, number]) {
    console.log('fir: ' + first);
    console.log('sec: ' + second);
}
f(input);

let [first, ...rest] = [1, 2, 3, 4];
console.log('rest: ' + rest);

/**================================================================ */
//对象解构
let o = {
    a: 'fpp',
    b: 23,
    c: 'bar'
}

let { a, b } = o;
console.log('a ' + a)
console.log('b ' + b)

/**=============================== */
//展开
//解构是将完整的数组或者对象打散到一个个变量中去
//展开反过来，是将一个数组或者对象装入一个更大的数组或者对象中去
let foo = [1, 2];
let bar = [3, 4];
let bothPlus = [0, ...foo, ...bar, 5];
console.log('bothPlus: ' + bothPlus);

let defaults = { food: 'spicy', price: '$$', ambiance: 'noisy' };
let search = {...defaults,food:'rich'};
search = {food:'rich',...defaults};


