var div = document.querySelector('.index');
function printLabel(LabelledValue) {
    console.log(LabelledValue.label);
}
var myObj = { size: 10, label: 'size 10 object', rotate: 233 };
printLabel(myObj);
function createSquare(config) {
    var newSquare = { color: 'white', area: 100 };
    if (config.color)
        newSquare.color = config.color;
    if (config.width) {
        newSquare.area = config.width * config.width;
    }
    return newSquare;
}
var mySquare = createSquare({ color: 'black' });
var p1 = { x: 10, y: 20 };
// p1.x = 5;//在赋值给readonly属性就会报错
var a = [1, 2, 3, 4];
var ro = a;
// ro[0] =12;//readonly数组元素是不可改变的
// ro.push(5);//调用相关的方法都不行
// a = ro;//a和ro不可赋值，不可变数组和一般数组是不同类型
