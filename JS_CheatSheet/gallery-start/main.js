const displayedImage = document.querySelector('.displayed-img');
const thumbBar = document.querySelector('.thumb-bar');

const btn = document.querySelector('button');
const overlay = document.querySelector('.overlay');

/* 遍历图片并添加至缩略图区 */

let myImg = ['images/pic1','images/pic2','images/pic3','images/pic4','images/pic5'];

for (let i = 0; i < myImg.length; i++) {
    const element = myImg[i];
    const newImage = document.createElement('img');

    newImage.onclick = function(){
        displayedImage.src = newImage.src;
    }

    newImage.setAttribute('src', element+'.jpg');
    thumbBar.appendChild(newImage);
}



/* 编写 变亮/变暗 按钮 */
btn.onclick = function(){
    if(btn.textContent === '变暗'){
        btn.textContent = '变亮';
        overlay.style.backgroundColor = 'rgba(0,0,0,0.5)';
    }else{
        btn.textContent = '变暗';
        overlay.style.backgroundColor = 'rgba(0,0,0,0)';
    }
}

