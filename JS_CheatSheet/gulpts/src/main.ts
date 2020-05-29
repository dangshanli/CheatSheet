import { sayHello } from './greet'

function showHello(divName: string, name: string) {
    const elt = document.querySelector('.' + divName);
    elt.textContent = sayHello(name);
}

showHello('greeting', 'TypeScript');
