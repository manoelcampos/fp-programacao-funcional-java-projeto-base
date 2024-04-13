import {getIteracoes, newArray} from './NewArray.js';

/*
Percorre um determinado vetor, executando operações como filter e map,
e mostra ao final o total de vezes que os elementos do vetor foram acessados
(total de vezes que o vetor foi percorrido).
*/
const numeros = newArray([-4, -3, -2, -1, 0, 1, 2, 3, 4, 5]);
const soma =
    numeros
        .filter(n => n >= 0)
        .map(n => n * 2)
        .reduce((subtotal, n) => subtotal + n);

console.log(`JS -> Soma: ${soma}`);
console.log(`Tamanho do vetor: ${numeros.length}`);
console.log(`Iterações: ${getIteracoes()}`);
