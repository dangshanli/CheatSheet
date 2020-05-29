var myString;
var myNum;
var bool;
bool = true;
myString = 'Hello Typescript!!!';
myNum = 223;
console.log(bool);
var Student = /** @class */ (function () {
    function Student(firstName, middleInitial, lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
    return Student;
}());
function greeter(person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}
var user = new Student("Jane", "M.", "User");
document.body.innerHTML = greeter(user);
var strArr;
strArr = ['hello', 'world'];
console.log(strArr);
var numArr;
numArr = [2, 3.4];
console.log(numArr);
var boorArr;
boorArr = [false, true];
console.log(boorArr);
var strnumTuple;
strnumTuple = ['hello', 3, 5, 6];
console.log(strnumTuple);
var myVoid = null;
console.log(myVoid);
var myNull = null;
var myUndefined = undefined;
