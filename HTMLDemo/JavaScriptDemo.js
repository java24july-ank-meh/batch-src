function changeText(id) {
            id.innerHTML="Text Changed!";
        };

window.addEventListener("resize", function() {
	document.getElementById("title").innerHTML = "Window Resized!";
});

function makeUpperCase(word) {
	return word.toUpperCase();
}

function testVar() {
    var a = 30;
    if (true) {
        var a = 50;
        console.log(a);
    }
    console.log(a);
}

function testLet() {
    let a = 30;
    if (true) {
        let a = 30;
        console.log(a);
    }
    console.log(a);
}

const numbers = [];
numbers.push(11);
numbers.push(22);

class Parent {
    constructor(username, password) {
        this.username = username;
        this.password = password;
    }

    print() {
        console.log(this.username + ' ' + this.password);
    }
}

class Child extends Parent {
    constructor (username, password, age) {
        super(username, password);
        this.age = age;
    }

    static countParents() {
        console.log('There are two parents');
    }

    print() {
        console.log(this.username + ' is ' + this.age);
    }
}

let name = "John";
let template = `<h1>${makeUpperCase('Hello')}, ${name}</h1><p>This is a template</p>`;

document.getElementById("template").innerHTML = template;

let arr = [11, 22, 11, 23, 42];
let set = new Set(arr);
console.log(set);
set.forEach(function(args) {console.log(args);});