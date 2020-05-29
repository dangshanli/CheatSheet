
Function.prototype.method = function (name, func) {
    if (!this.prototype[name]) {//确定语言没自带该方法
        this.prototype[name] = func;
    }
    return this;
}

Number.method('integer', function () {
    return Math[this < 0 ? 'ceil' : 'floor'](this);
});

String.method('trim', function () {
    return this.replace(/^\s+|\s+$/g, '');//移除首尾处的空格
});


const test = document.querySelector('.wrapper .test');
console.log(test);
test.textContent = (-10 / 3).integer();
test.textContent = '"' + " neat ".trim() + '"';

//============================外部函数返回字面量对象，该对象引用外部函数状态变量============================
var myObject = (function () {
    var value = 0;

    //返回字面量对象
    return {
        increment: function (inc) {
            value += typeof inc === 'number' ? inc : 1;
        },
        getValue: function () {
            return value;
        }
    };
}());

console.log(typeof myObject === 'function');

var quo = function (status) {
    return {
        getStatus: function () {
            return status;
        }
    };
};

var MyQuo = quo('amazed');
test.textContent = MyQuo.getStatus();


var fade = function (node) {
    var level = 1;

    var step = function () {
        var hex = level.toString(16);
        node.style.backgroundColor = '#FFFF' + hex + hex;
        if (level < 15) {
            level++;
            setTimeout(step, 100);
        }
    };

    setTimeout(step, 100);
};

//即使外部函数fade已经完全返回了，但是他的变量level还能够被内部函数step访问以及修改。
//因此，只要我们还持有step函数就一直能访问外部函数的状态
//保护私有变量的关键就在于，我们把状态定义到外部函数中，而只返回内部函数(或者字面量对象)的引用
//那么他人就无法直接访问外部函数的状态了，想访问就只有通过内部函数了
fade(document.querySelector('.wrapper .test2'));


//====================内部函数持有外部函数状态=================================================
//糟糕了的例子
var add_the_handlers = function (nodes) {
    var i = 0;

    for (i = 0; i < nodes.length; i++) {
        const element = nodes[i];
        element.onclick = function (e) {//被绑定的函数不是立即执行的，等到他真正执行的时候i已经死等与5了
            alert(i);
        };
    }
};

// add_the_handlers(document.querySelectorAll('.wrapper .add'));

//改进的例子
var better = function (nodes) {
    var i = 0;
    var help = function (i) {
        return function () {
            alert(i);
        };
    };
    //借助内部函数暂时保存住当前变量，并且延迟执行
    //与前面不同的是，前面的函数定义在onclick上的函数是点击时才执行，此时i已经只等于5了
    //而better中，help函数是立即执行的，直接消费掉当时的i值，因此help返回的函数所调用的不是外部
    //状态变量i，而是help传给他的某个具体的值
    for (let i = 0; i < nodes.length; i++) {
        const element = nodes[i];
        element.onclick = help(i);
    }
};

better(document.querySelectorAll('.wrapper .add'));

//=====================回调即异步=======================

//====================Module==========================

//模块化就是将状态私有化
//具体方式就是创建一个持有私有状态的外部函数
//然后外部函数返回内部函数，此时内部函数拥有访问外部函数状态的特权
//我们把内部函数的引用返回给外部调用者，由于没有外部函数的引用，这样就很好的保护了外部函数的状态

String.method('deentityify', function () {

    //此为外部函数私有状态
    var entity = {
        quot: '"',
        lt: '<',
        gt: '>'
    };

    //此为内部函数，他才是真正绑定deentityify的函数
    return function () {
        return this.replace(/&([^&;]+);/g, function (a, b) {
            var r = entity[b];
            return typeof r === 'string' ? r : a;
        });
    };
}());//外部函数是立即执行的

var deen = document.querySelector('.wrapper .deen');
var s = '&lt;&quot;&gt;'.deentityify();
deen.textContent = '模块化验证：' + s;

//=====================利用外部函数状态做缓存的技术-memoize==========================================

//memo是缓存，formular是递归函数
//memoizer是一种缓存计算结构
var memoizer = function (memo, formular) {
    var recur = function (n) {
        var result = memo[n];

        if (typeof result !== 'number') {
            result = formular(recur, n);
            memo[n] = result;
        }

        return result;
    };
    return recur;
};

//利用memoizer可以生成计算斐波那契的函数fibonacci,只要一共formular即可
var fibonacci = memoizer([0, 1], function (recur, n) {
    return recur(n - 1) + recur(n - 2);
});

//提供另一种formular可以得到阶乘的计算函数
var factorial = memoizer([1, 1], function (recur, n) {
    return n * recur(n - 1);
});
console.log(fibonacci(10));

document.querySelector('.wrapper .fibonacci').textContent = 'fibonacci:' + fibonacci(30);
document.querySelector('.wrapper .factorial').textContent = 'factorial:' + factorial(10);

//======================对象继承======================================
//pseudoclass
var Mammal = function (name) {
    this.name = name;
};

Mammal.prototype.get_name = function () {
    return this.name;
};

Mammal.prototype.says = function () {
    return this.saying || '';
}

var mammal1 = new Mammal('Herb');
var name = mammal1.get_name();
console.log('mammal1 name:' + name);


var Cat = function (name) {
    this.name = name;
    this.saying = 'meow';
};

Cat.prototype = new Mammal();
Cat.prototype.purr = function (n) {
    var i, s = '';
    for (let i = 0; i < n; i++) {
        if (s) {
            s += '-'
        }
        s += 'r';
    }
    return s;
};
Cat.prototype.get_name = function () {
    return this.says() + ' ' + this.name + ' ' + this.says();
}
var myCat = new Cat('Brigeta');
console.log('says:' + myCat.says());
console.log('purr:' + myCat.purr(5));
console.log('name:' + myCat.get_name());


