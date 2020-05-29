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

//更进一步的，在返回函数的那个函数入参里面，直接指定this指向当前娘家类型，这样this同时还有了确切的类型
interface Card {
    suit: string;
    card: number;
}

interface Deck {
    suits: string[];
    cards: number[];
    createCardPicker(this: Deck): () => Card;
}

let deck: Deck = {
    suits: ['hearts', 'spades', 'clubs', 'diamonds'],
    cards: Array(52),
    createCardPicker: function (this: Deck) {
        return () => {
            let pickedCard = Math.floor(Math.random() * 52);
            let pickedSuit = Math.floor(pickedCard / 13);
            return {
                suit: this.suits[pickedSuit],
                card: pickedCard % 13
            };
        }
    }
}

let cardPicker = deck.createCardPicker();
let pickedCard = cardPicker();
console.log('card: ' + pickedCard.card + ' of ' + pickedCard.suit);