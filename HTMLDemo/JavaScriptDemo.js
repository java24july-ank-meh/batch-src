function changeText(id) {
            id.innerHTML="Text Changed!";
        };

window.addEventListener("resize", function() {
	document.getElementById("title").innerHTML = "Window Resized!";
});

function makeUpperCase(word) {
	return word.toUpperCase();
}

let name = "John";
let template = `<h1>${makeUpperCase('Hello')}, ${name}</h1><p>This is a template</p>`;

document.getElementById("template").innerHTML = template;