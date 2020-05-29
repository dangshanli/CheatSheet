const para = document.querySelector('p');
para.addEventListener('click', updateName);

function updateName() {
    let name = prompt('输入一个新的名字：');
    para.textContent = '玩家1：' + name;
}


// document.addEventListener('DOMContentLoaded', function () {
//     console.log('24444 \n'+new Date());

// });

function createParagraph() {
    let pp = document.createElement('p');
    pp.textContent = '你点击了按钮' + '!';
    document.body.appendChild(pp);
}

const buttons = document.querySelectorAll('button');
buttons.forEach(element => {
    element.addEventListener('click', createParagraph);
});