let myString: string;
let myNum: number;
let bool: boolean;

bool = true;
myString = 'Hello Typescript!!!';
myNum = 223;
console.log(bool);

class Student {
    fullName: string;
    constructor(public firstName, public middleInitial, public lastName) {
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
}

interface Person {
    firstName: string;
    lastName: string;
}

function greeter(person: Person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}

let user = new Student("Jane", "M.", "User");

document.body.innerHTML = greeter(user);

let strArr: string[];
strArr = ['hello', 'world'];
console.log(strArr);

let numArr: number[];
numArr = [2, 3.4];
console.log(numArr);
let boorArr: boolean[];
boorArr = [false, true];
console.log(boorArr);

let strnumTuple: [string, number];
strnumTuple = ['hello', 3, 5, 6];
console.log(strnumTuple);

let myVoid: void = null;
console.log(myVoid);

let myNull: null = null;
let myUndefined: undefined = undefined;