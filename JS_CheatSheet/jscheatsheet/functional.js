//不走构造函数那一套，这个类似于真.工厂方法
let mammal = function (spec) {
    let that = {};

    that.get_name = function () {
        return spec.name;
    };

    that.says = function () {
        return spec.saying || '';
    };

    //这个that是内部字面量对象
    //他的状态太取决于入参，只要没有拿到入参的引用，则只有通过that访问状态
    return that;
};

const spec = { name: 'Miku' };
const myMammal = mammal({ name: 'Herb' });

let cat = function (spec) {
    spec.saying = spec.saying || '';
    //重Mammal工厂方法直接得到现成的对象
    let that = mammal(spec);
    
    //在mammal对象基础上进行改造
    that.purr = function(n){
        let i = 0,s = '';

        for (let i = 0; i < n; i++) {
            if(s){
                s += '-';
            }
            s += 'r';
        }
        return s;
    };

    that.get_name = function(){
        return that.says()+' '+spec.name+' '+that.says();
    };

    //老实说。这已经偏离了原来的构造函数以及prototype那一套
    //cat和mammal都是平级的Object对象，上面的prototype都是Object.prototype
    //cat只是在mammal基础上新增方法，从功能上好像复用了mammal的方法，但和原型链无关，更像是直接复制,然后修改加强
    return that;
};

const myCat = cat({name:'genji'});