var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var div = document.querySelector('.index');
//var没有块级作用域，只有函数作用域
function sumMatrix(matrix) {
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
var _loop_1 = function (i) {
    setTimeout(function () { console.log(i); }, 100 * i);
};
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
for (var i = 0; i < 10; i++) {
    _loop_1(i);
}
/**================================================================ */
//解构赋值
var input = [1, 2];
var first = input[0], second = input[1];
console.log('first: ' + first);
console.log('second: ' + second);
function f(_a) {
    var first = _a[0], second = _a[1];
    console.log('fir: ' + first);
    console.log('sec: ' + second);
}
f(input);
var _a = [1, 2, 3, 4], first = _a[0], rest = _a.slice(1);
console.log('rest: ' + rest);
/**================================================================ */
//对象解构
var o = {
    a: 'fpp',
    b: 23,
    c: 'bar'
};
var a = o.a, b = o.b;
console.log('a ' + a);
console.log('b ' + b);
/**=============================== */
//展开
//解构是将完整的数组或者对象打散到一个个变量中去
//展开反过来，是将一个数组或者对象装入一个更大的数组或者对象中去
var foo = [1, 2];
var bar = [3, 4];
var bothPlus = [0].concat(foo, bar, [5]);
console.log('bothPlus: ' + bothPlus);
var defaults = { food: 'spicy', price: '$$', ambiance: 'noisy' };
var search = __assign({}, defaults, { food: 'rich' });
search = __assign({ food: 'rich' }, defaults);
