/** function add(x: number, y: number): number {
    return x + y;
}

let myAdd = function (x: number, y: number): number {
    return x + y;
}

let deck = {
    suits: ['heart', 'spades', 'clubs', 'diamonds'],
    cards: Array(52),
    createCardPicker: function () {
        //使用箭头函数绑住当前娘家对象this
        return () => {
            let pickedCard = Math.floor(Math.random() * 52);
            let pickedSuit = Math.floor(pickedCard / 13);
            return { suit: this.suits[pickedSuit], card: pickedCard % 13 };
        }
    }
}

let cardPicker = deck.createCardPicker();
let pickedCard = cardPicker();
console.log('card: ' + pickedCard.card + ' of ' + pickedCard.suit);
*/
var deck = {
    suits: ['hearts', 'spades', 'clubs', 'diamonds'],
    cards: Array(52),
    createCardPicker: function () {
        var _this = this;
        return function () {
            var pickedCard = Math.floor(Math.random() * 52);
            var pickedSuit = Math.floor(pickedCard / 13);
            return {
                suit: _this.suits[pickedSuit],
                card: pickedCard % 13
            };
        };
    }
};
var cardPicker = deck.createCardPicker();
var pickedCard = cardPicker();
console.log('card: ' + pickedCard.card + ' of ' + pickedCard.suit);
